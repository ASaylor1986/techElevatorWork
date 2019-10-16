<template>
  <div class="doctordashboard">
    <div id="header">
     <h1 id="docGreeting" style="">Physician Dashboard</h1> 
      <button @click="logout" class="submit" style="margin: 10px;">Logout</button>


    </div>
    <div id="mainBody">
    
    </div> 
    <div id="calendar">
        <vue-cal 
        hide-view-selector
        :time-from="9*60" 
        :time-to="17*60" 
        :time-step="30" 
        :events="events"
        :disable-views="['years', 'year', 'months', 'month']"
        :hide-weekdays="[6, 7]"
        :on-event-dblclick="onEventClick"
        @view-change="getEvents"> <div class="{ line: true, hours: !minutes }"
              slot="time-cell"
              slot-scope="{ hours, minutes }">
            <strong v-if="!minutes" style="font-size: 15px">{{ hours }}</strong>
            <span v-else style="font-size: 11px">{{ minutes }}</span>
          </div> </vue-cal> 
        <form>
        <v-dialog class="v-dialog v-dialog--active" v-model="showDialog" >
          <v-card class="v-card v-sheet theme--light">
            <v-card-title class="v-card__title " >
              <v-icon>{{ selectedEvent.icon }}</v-icon>
              <span>{{ selectedEvent.title }}</span>

              <v-spacer/>
              <strong>{{ (selectedEvent.start || '').substr(5, 5) }}-{{ (selectedEvent.start || '').substr(0, 4) }}</strong>
              <button class="redXButton" @click="showDialog=false, reloadMyPage()"> x</button>
            </v-card-title>
            <v-card-text id="apptForm"> 
              <p v-html="selectedEvent.contentFull"/>
                    <p for="title" class="sr-only" id="formItem">  Reason for Appointment:</p>
                      <input
                        type="text"
                        class="form-control"
                        v-bind:placeholder="selectedEvent.title "
                        v-model="selectedEvent.title"
                        required
                       
                      />
                    <p for="title" class="sr-only" id="formItem">  Patient First Name:</p>
                      <input
                        type="text"
                        class="form-control"
                        v-bind:placeholder="selectedEvent.patientFirstName "
                        v-model="selectedEvent.patientFirstName"
                        required
                        autofocus
                      />
                      <p for="title" class="sr-only" id="formItem">  Patient Last Name:</p>
                      <input
                        type="text"
                        class="form-control"
                        v-bind:placeholder="selectedEvent.patientLastName "
                        v-model="selectedEvent.patientLastName"
                        required
                        autofocus
                      />

                    <label for="class" class="sr-only" id="formItem"> Appointment Type:</label>
                      <select @change="selectClass($event)" v-model="selectedEvent.type" id="apptDropDown"   required>
                        <option selected value="">Please choose an Event Type</option>                      
                        <option value='available'>Available</option>
                        <option value='appt'>Patient Appointment</option>
                        <option value='unavailable'>Unavailable</option>
                      </select>
                    <p for="startTime" class="sr-only" id="formItem"><font color="red">Start Time: </font>{{ (selectedEvent.start || '').substr(10) }}</p>
                    
                    <p for="endTime" class="sr-only" id="formItem"><font color="red">End Time:   </font>
                    {{ (selectedEvent.end || '').substr(10) }}</p>
                    <div id="popUpButtons">
                      <button v-if="!hasEventId" @click="createEvent(); showDialog=false" type="button" class="submit">Create </button>   
                      <button v-if="hasEventId" @click="deleteEvent(); showDialog=false" type="button" class="submit">Delete</button>
                      <button v-if="hasEventId" @click="updateEvent(); showDialog=false" type="button" class="submit">Update</button>
                    </div>    
            </v-card-text>
          </v-card>
        </v-dialog>
        </form>
  </div>

      <div id="event">
        <vue-cal 
          hide-view-selector
          :time-from="9*60" 
          :time-to="17*60" 
          :time-step="30" 
          default-view="day"
          :disable-views="['years', 'year', 'week', 'month']"
          @cell-focus="selectedDate = $event"
          :events="events"
          :on-event-dblclick="onEventClick"
          >
          <div class="{ line: true, hours: !minutes }"
              slot="time-cell"
              slot-scope="{ hours, minutes }">
            <strong v-if="!minutes" style="font-size: 15px">{{ hours }}</strong>
            <span v-else style="font-size: 11px">{{ minutes }}</span>
          </div>
        </vue-cal>
    </div>
  </div>
</template>

<script>

import VueCal from 'vue-cal'
import 'vue-cal/dist/vuecal.css'
import auth from '../auth';
import {DateTime} from "luxon";

export default {
  components: {
    VueCal,
  },
  props:{
    apiPath: String
  },

  data() {
    return {
      selectedEvent: {},
      showDialog: false,
      weekStart: DateTime.local().startOf('week'),
      officeHours: [
        {
          day: "Monday",
          open: "9:00",
          close: "17:00"
        },
        {
          day: "Tuesday",
          open: "9:00",
          close: "17:00"
        },
        {
          day: "Wednesday",
          open: "9:00",
          close: "17:00"
        },
        {
          day: "Thursday",
          open: "9:00",
          close: "17:00"
        },
        {
          day: "Friday",
          open: "9:00",
          close: "17:00"
        }
      ],
      events: [
        {
          timestamp: '',
          eventid: '',
          start: '',
          end: '',
          title: '',
          patientFirstName: '',
          patientLastName: '',
          class: 'type'
        },
    
      ],
     user: {
        username: '',
        password: '',
        firstName: '',
        lastName: '',
        userId: '',
        userType: '',
      },
      invalidCredentials: true,
    };
  },
  methods: {
    logout() {
      auth.logout();
      this.$router.push('/');
    },
    createAvailable(event){
      if (event) {
         this.weekStart=DateTime.fromJSDate(event.startDate).startOf('week');
      }
      for (let d = 0; d < 7; d++) {
            let currentDay = this.weekStart.plus({ days: d });
            let dayHours = this.officeHoursForDay(currentDay.weekdayLong);
            for (let dh of dayHours) {
              let opening = this.setTime(currentDay, dh.open);
              let closing = this.setTime(currentDay, dh.close);
              for (
                let t = opening;
                t.valueOf() < closing.valueOf();
                t = t.plus({ minutes: 30 })
              ) {
                let ts = t.valueOf(); //get timestamp
                if ((this.events.find(item => item.timestamp === ts) === undefined) && (ts > DateTime.local().valueOf())) { //if statement for greater than dateTimeLocal
                  this.events.push({
                    timestamp: ts,
                    start: t.toFormat("yyyy-MM-dd HH:mm"),
                    end: t.plus({ minutes: 30 }).toFormat("yyyy-MM-dd HH:mm"),
                    title: "Click to Schedule",
                    class: "available"
                  });
                }
              }
            }
          }
        this.events.sort((a, b) => a.timestamp - b.timestamp);
    },
    getEvents(event){
      fetch(this.apiPath + '/api/events', {
          method: 'GET',
          headers: {
            Accept: 'application/json',
                    'Content-Type': 'application/json',
                    Authorization: 'Bearer ' + auth.getToken() 
          }})
        .then(response => {
          return response.json();
        })
        .then(parsedData => {
          this.events = parsedData;
          for(let e of this.events){
            e.timestamp= DateTime.fromFormat(e.start, "yyyy-MM-dd HH:mm").valueOf();
          }
          this.createAvailable(event);
        })
    },
    getUserInfo() {

      let user = auth.getUser();
      this.user.username = user.sub;
    },

    createEvent() {console.log("called create")
      fetch(`${this.apiPath}/api/events`,{
        method: 'POST',
        headers: {
          "Content-Type": "application/json",
          Authorization: 'Bearer ' + auth.getToken() 
        },
        body: JSON.stringify(this.selectedEvent)
      })
      .then(parsedData => {
          this.events = parsedData;
      })
      .catch((err) => console.error(err));
      document.location.reload(true);
    },

    updateEvent(){
        fetch(`${this.apiPath}/api/events/${this.selectedEvent.eventId}`, {
          method: 'PUT',
          headers: {
            Accept: 'application/json',
                    'Content-Type': 'application/json',
                    Authorization: 'Bearer ' + auth.getToken() 
          },
          body: JSON.stringify(this.selectedEvent)
        })
        .then((response) => {
          if(response.ok){
            this.$emit('showEvents');
          }
        })
        .catch((err) => console.error(err));
        document.location.reload(true);
      },

      deleteEvent(id){
            fetch(`${this.apiPath}/api/events/${this.selectedEvent.eventId}`, {
                method: 'DELETE',
                headers:{
                    Accept: 'application/json',
                    'Content-Type': 'application/json',
                    Authorization: 'Bearer ' + auth.getToken() 
                },
                body: JSON.stringify(this.selectedEvent)
            })
            .then((response) =>{
                if(response.ok){
                    const index = this.events.map(event => event.eventId).indexOf(id);
                    this.events.splice(index, 1);
                }
            })
            .catch((err) => console.err(err));
            document.location.reload(true);

        },
      selectClass(event){
        this.selectedEvent.class = (event.target.value);
      },

      reloadMyPage() {
        document.location.reload(true);
      },


    onEventClick (event, e) {
    this.selectedEvent = event
    this.showDialog = true
    e.stopPropagation()
    },
    officeHoursForDay(day) {
        return this.officeHours.filter(item => item.day === day);
      },
      setTime(dateTime, time) {
        let timeParts = time.split(":");
        let h = timeParts[0];
        let m = timeParts[1];
        return dateTime.set({ hour: h, minutes: m });
      },
      goToUpdateOfficeInfo() {
        this.$router.push('/update_office_info')
      },


    },
    computed:{
        hasEventId(){
        return this.selectedEvent.eventId != undefined;
      }

    },
      created() {
        this.getUserInfo();
        this.getEvents();
      }
      
    };
    
</script>


<style>

#apptForm> .sr-only {
  width: 99%;
}
#apptForm >input, #apptDropDown {
  width: 100%;
  border: 2px solid #6A7DBD;
  border-radius: 7%;

}
#calendar {
  width: 67%;
  height: auto;
  margin: 20px;
  float: left;
  background-color: rgba(248, 246, 246);
}

#calendarButtons {
  display: flex;
  justify-content: space-around;
  padding: 10px;
}
#docGreeting {
  color: white;
  padding: 10px;
}

#event {
  width: 27%;
  margin: 20px;
  float: left;
  justify-content: center;
  text-align: center;
  background-color: rgb(248, 246, 246);
  color: white;
} 
#formItem {
  font-weight: bold;
}

#formItem.sr-only {
  margin: 5px;
  width: 100%
}
#header{
  text-align: center;
}
#popUpButtons {
  display: flex;
  justify-content: space-evenly;
}

#popUpButtons > button{
  padding: 10px;
}


.angle {
  color: white;
}
.appt {
  background-color: rgba(255,255,0, .15);
}
.available {
  background-color: #e6ffe6;
  border: .5px solid #e6e6e6;
}



div.vuecal__title-bar {
  background-color: #6A7DBD;
  color: white;
}
.vuecal__body {
  border: 0px 0px  1px 1px solid black;
}
.vuecal__cell-content {
padding: 10px;
}
.vuecal__cell.current{
  background-color: rgba(0,0,139, .05)
}
.vuecal__cell.selected {
  color: rgb(0,0,139);
  border:1px solid rgba(0,0,139, .5);
  background-color: rgba(0,0,139, .15);
}
.vuecal__cell.out-of-scope {
  background-color: rgba(0,0,139, .05);
  color: darkgray;
}
.vuecal__cell.today {
  background-color: rgba(229, 229, 229);
}
.vuecal__event-time {
  display: none;
}
.vuecal__event.unavailable {
  background: repeating-linear-gradient(45deg, transparent, transparent 10px, #f2f2f2 10px, #f2f2f2 20px);/* IE 10+ */
  color: #999;
  display: flex;
  justify-content: center;
  align-items: center;
}
.vuecal__event.unavailable .vuecal__event-time {
  display: none;
  align-items: center;
}
.vuecal__heading .weekday-label {
    color: rgb(69, 66, 75);
}
.vuecal__menu > button:hover {
  background-color: rgba(0,0,139, .5);
}
.vuecal__now-line {
  color: #6A7DBD;
}
.vuecal__title > span{
    color: white;
}




.v-card__title{
  background-color: rgb(69, 66, 75);
  color: white;
  margin-bottom: 10px;
}
.v-card__text {
  padding: 20px;
  text-decoration: none;
} 
.v-dialog.v-dialog--active {
  max-width: 50%;
  margin: 0px;
}


</style>


<!--color: rgb(69, 66, 75);
border: 2px solid #6A7DBD;

-->