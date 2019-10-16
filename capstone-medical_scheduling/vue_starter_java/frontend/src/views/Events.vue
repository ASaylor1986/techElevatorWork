<template>
    <div class="Events">
    <div class="header">
      <h2>Events <span>({{reviews.length}})</span></h2>
      <a href="#" class="event-review" v-on:click="$emit('addEvent')">
        <i class="far fa-address-card"></i> Add Event
      </a>
    </div>
    <div class="event" v-for="event in events" :key="event.id">
      <div class="event-left">
        <div class="review-actions">
          <a href="#" class="update-review" v-on:click="updateEvent(parseInt(event.id))">
            <i class="far fa-edit"></i> Update
          </a>
          <a href="#" class="delete-review" v-on:click="deleteEvent(event.id)">
            <i class="far fa-trash-alt"></i> Delete
          </a>
        </div>
      </div>
      <div class="event-info">
        <h2>{{event.title}}</h2>
        <span>{{event.eventstart}} | {{event.eventend}}</span>
        <p class="feedback">{{event.content}}</p>
      </div>
    </div>
  </div>
</template>

<script>
import auth from '../auth';
export default {
    name: "Events",
    props: {
        apiURL: String
    },
    data(){
        return{
            events:[]
        };
    },
    methods:{
        updateEvent(id){
            this.$emit('updateEvent', id)
        },
        deleteEvent(id){
            fetch(`${this.apiURL}/events/${id}`,{
                method: 'DELETE',
                headers:{
                    Accept: 'application/json',
                    'Content-Type': 'application/json',
                    Authorization: 'Bearer' + auth.getToken() 
                },
                body: JSON.stringify(this.event)
            })
            .then((response) =>{
                if(response.ok){
                    const index = this.events.map(review => event.eventid).indexOf(id);
                    this.events.splice(index, 1);
                }
            })
            .catch((err) => console.err(err));

        }
    },
    created(){
        fecth(this.apiURL)
        .then((response) => {
            return response.json();

        })
        .then((events) => {
            this.events = events;
        })
        .catch((err) => console.error(err));
    }
};
</script>

<style>

</style>
