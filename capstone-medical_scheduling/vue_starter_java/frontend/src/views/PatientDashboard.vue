<template>
  <div class="patientdashboard">
    <div id="header">
     <h1 id="patientGreeting" style="color: white;">Patient Dashboard</h1>

  
       <button @click="logout" class="submit" >Logout</button>

    </div>
    <div id="mainBody">

    <div id="patientEvent">
        <h2>Upcoming Appointments</h2>
        <div v-for="event in userEvents" :key="event.eventId" id="patientApptIds">
        <h4 id="apptTitle"> <b> Reason for Visit: <font color="rgb(69, 66, 75);">{{event.title}}</font></b></h4>
        <p><b> Appointment Date:  <font color="rgb(69, 66, 75);">{{ (event.start || '').substr(5, 5) }}-{{ (event.start || '').substr(0, 4) }}</font></b></p>
        <p><b> Start Time: <font color="rgb(69, 66, 75);">{{ (event.start || '').substr(10) }}</font></b></p>
        <p> <b>End Time: <font color="rgb(69, 66, 75);">{{ (event.end || '').substr(10) }}</font></b></p>
        </div>
    </div> 
      
    <div id="patientCalendar">
      <h2>Doctor's Availability</h2>
        <vue-cal 
        hide-view-selector
        :time-from="9*60" 
        :time-to="17*60" 
        :time-step="30" 
        :events="events"
        default-view="week"
        :disable-views="['years', 'year', 'months', 'month', 'day']"
        :hide-weekdays="[6, 7]"
        :on-event-dblclick="onEventClick"
        @view-change="getEvents"> <div class="{ line: true, hours: !minutes }"
              slot="time-cell"
              slot-scope="{ hours, minutes }">
            <strong v-if="!minutes" style="font-size: 15px">{{ hours }}</strong>
            <span v-else style="font-size: 11px">{{ minutes }}</span>
          </div></vue-cal>  
    
      <form>
      <v-dialog class="v-dialog v-dialog--active" v-model="showDialog" >
          <v-card class="v-card v-sheet theme--light">
            <v-card-title class="v-card__title">
              <v-icon>{{ selectedEvent.icon }}</v-icon>
              <span>{{ selectedEvent.title }}</span>
              <v-spacer/>
              <strong>{{ (selectedEvent.start || '').substr(5, 5) }}-{{ (selectedEvent.start || '').substr(0, 4) }}</strong>
              <button class="redXButton" @click="showDialog=false" > x</button>
            </v-card-title>
            <v-card-text id="apptForm"> 
              <p v-html="selectedEvent.contentFull"/>
                    <label for="title" class="sr-only" id="formItem"> Reason for Visit:</label>
                      <input
                        type="text"
                        class="form-control"
                        v-bind:placeholder="selectedEvent.title "
                        v-model="selectedEvent.title"
                        required
                        autofocus
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
              <select @change="selectClass($event)" v-model="selectedEvent.type" id="apptDropDown" required>
                <option selected="selected" value='appt'>Patient Appointment</option>
                <option selected="selected" value='appt'>Web Consult</option>
                <option selected="selected" value='appt'>Referral</option>
              </select>
              <p for="startTime" class="sr-only" id="formItem"><font color="red">Start Time: </font>{{ (selectedEvent.start || '').substr(10) }}</p>
              <p for="endTime" class="sr-only" id="formItem"><font color="red">End Time:   </font>
                    {{ (selectedEvent.end || '').substr(10) }}</p>


              <div id="popUpButtons">
                <button @click="createEvent(); showDialog=false"  class="submit" type="button" style="margin: 10px;">Book Appointment</button>   
              </div>    
            </v-card-text>
          </v-card>
        </v-dialog>
      </form>
  </div>


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
          eventId: '',
          start: '',
          end: '',
          title: '',
          patientFirstName: '',
          patientLastName: '',
          class: ''
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

      userEvents: [
      {
        userId: '',
        eventId: '',
        start: '',
        end: '',
        title: '',
        patientFirstName: '',
        patientLastName: '',
        class: ''
        },

      ],
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
                if ((this.events.find(item => item.timestamp === ts) === undefined) && (ts > DateTime.local().valueOf())) { //if statement for greater than dateTimeLocal{
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
            e.title = "UNAVAILABLE"
            e.class = "hideMe"
          }
          this.createAvailable(event);
        })
    },
    getUserInfo() {

      let user = auth.getUser();
      this.user.username = user.sub;
      // this.user = user;
    },

    createEvent() {
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

    selectClass(event){
      this.selectedEvent.class = (event.target.value);
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
      getUserEvents() {
        fetch(`${this.apiPath}/api/userevents/${auth.getUser().uid}`, {
        method: 'GET',
        headers: {
        Accept: 'application/json',
        'Content-Type': 'application/json',
        Authorization: 'Bearer ' + auth.getToken()
        }
        })
        .then(response =>{
        return response.json();
        })
        .then(parsedData =>{
        this.userEvents = parsedData
        })
        .catch((err) => console.error(err));
        },
    },
    

      created() {
        this.getUserInfo();
        this.getEvents();
        this.getUserEvents();
      }
      
    };
    
</script>


<style>

#patientApptIds {
  padding: 10px;
  background-color: rgba(117, 123, 121, .30);
  border: 1px solid #6A7DBD;
  margin: 10px;
}

#patientGreeting {
  color: white;
  padding: 10px;
  margin: 0px 0px 10px;
}
#header{
  text-align: center;
}
#patientEvent {
  width: 37%;
  height: 50%;
  margin: 20px;
  float: left;
  justify-content: center;
  /* text-align: center; */
  background-color: white; 
  /* color: black; */
}
#patientCalendar {
  width: 57%;
  margin: 20px;
  float: left;
  background-color: rgba(248, 246, 246);
}
#patientCalendar h2 {
  background-color: #6A7DBD;
  color: white;
  font-weight: 300;
  padding: 5px;
}

#calendarButtons {
  display: flex;
  justify-content: space-around;
  padding: 10px;
}

.vuecal__menu {
  background-color: #6A7DBD;
  color: white;
}

.vuecal__title *{
    color: #6A7DBD;
}

.vuecal__menu > button:hover {
  background-color: rgba(0,0,139, .5);
}

.appt {
  background-color: rgba(209, 138, 193, .5);
}

.vuecal__event.unavailable {
  background: repeating-linear-gradient(45deg, transparent, transparent 10px, #f2f2f2 10px, #f2f2f2 20px);/* IE 10+ */
  color: #999;
  display: flex;
  justify-content: center;
  align-items: center;
}
.vuecal__event.unavailable .vuecal__event-time {display: none;align-items: center;}


.vuecal__cell.today {
  background-color: rgba(229, 229, 229);
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

.vuecal__now-line {
  color: #6A7DBD;
}

.vuecal__cell-content {
padding: 10px;
}


.vuecal__heading .weekday-label {
    color: rgb(69, 66, 75);
}

#patientEvent >h2 {
  background-color: #6A7DBD;
  color: white;
  font-weight: 300;
  padding: 5px;
}

.vuecal__event-time {
  display: none;
}

.hideMe {
  display: none;
}



</style>


<!--color: rgb(69, 66, 75);
border: 2px solid #6A7DBD;

-->