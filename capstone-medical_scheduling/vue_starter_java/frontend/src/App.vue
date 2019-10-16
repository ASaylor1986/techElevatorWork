<template>

  <div id="app">
    <div id="nav" class="navbar-dark">
      <div id="button1">
      <p class="nav-items" style="color: white; background-color: rgb(106, 125, 189);">Pencil<b>Me</b>In <small>&trade;</small></p>
      <p class="nav-items"><router-link :to="{ name: 'login' }" style="text-decoration:none; color: #6A7DBD" >Home</router-link></p>
      <p class="nav-items"><a v-on:click="getDashboardLink()" class="link" style="text-decoration:none; color: #6A7DBD;" >Dashboard</a> </p>

      </div>
      <div id="button2">
      <p class="nav-items"><router-link :to="{ name: 'register' }" style="text-decoration:none; color: #6A7DBD;" >Register</router-link></p>
      </div>
    </div> 
    <router-view :apiPath="API_PATH"/>
  </div>
</template>

<script>
import auth from './auth';
export default{
  data(){
    return {
      API_PATH: process.env.VUE_APP_REMOTE_API,
    }
  },
  methods:{
    getDashboardLink(){
      let user = auth.getUser();
            

          switch(user.rol) {
            case 'patient':
              this.$router.push('/patient_dashboard');
              break;
            case 'doctor':
              this.$router.push('/doctor_dashboard');
              break;
            default:
              this.$router.push('/patient_dashboard');
          }
    },
  }

}
  
</script>

<style>
@import url('https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700&display=swap');

body {
  margin: 0px;
  padding: 0px;
  font-family: 'Open Sans', sans-serif;
  font-weight: 300;
  background-image: url('img/pediatricianOffice.jpg');
  height: 100%; 
  background-position: stretch;
  background-repeat: no-repeat;
  background-size: cover;
  background-image: lightness(40% );
}

#app {
  padding-bottom: 10px;
}

.selected {
  background-color: #00008b;
  color: white;
}

#nav {
  margin: 0;
  background-color: rgba(248, 246, 246, .8);
  display: flex;
  justify-content: space-between;
  /* margin-bottom: 10px; */
}

#button1 {
  display: flex;
}

#button2 {
  display: flex;
}

.nav-items {
  font-size: 2em;
  font-weight: 400;
  padding: 10px;
}

.nav-items:hover {
    color: white;
    background-color: rgba(0,0,139, .65);
}

.nav-items >a:hover {
    color: white;
    text-decoration: none;
}

.submit {
  color: white;
  background-color: rgb(106, 125, 189);
  padding: 10px;
  border-radius: 10%;
}

.redXButton {
  width: 20px;
  height: 28px;
  font-size: .6em;
  position: absolute;
  top: -8px;
  right: 1px;

  border-radius: 10%;
  border: 1px solid black;
  
}

</style>
