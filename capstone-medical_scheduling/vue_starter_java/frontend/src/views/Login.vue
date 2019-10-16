<template>
<div id="loginPage">
<div id="Info">
  <div id="officeInfoHeader">
    <div style="background-color: rgba(106, 125, 189, .5); width: 100%; padding: 10px;">
  <h2 >{{office.officeName}}</h2></div>
<h3>Giving children the care they deserve</h3>
<p>
The All About Kids Pediatric Clinic offers primary pediatric care for children
from birth through adolescence, whether your child is sick,
needs shots or just a check-up.
</p>
<p>The clinic is located on {{office.officeAddress}}, {{office.city}}, {{office.state}} {{office.zip}}. </p>
<p style="font-weight: bold;">We can be reached by phone at {{office.phone}}</p>
<p>Visit Cost: ${{office.visitCost}}</p>
</div>
<div id="hours">
  <table width="100%">
    <tbody>
      <tr>
        <th colspan="1" >
          <div style="background-color: rgba(106, 125, 189, .5); width: 100%; padding: 10px;">
          <h2 style="text-align: center;" >Office Hours</h2></div>
        </th>
      </tr>
      <tr>
        <td>{{office.weekdayHours}}</td>
      </tr>
      <tr >
        <td >{{office.satHours}}</td>
      </tr>
      <tr>
        <td>{{office.sunHours}}</td>
      </tr>
    </tbody>
  </table>
  </div>
  </div>
  <div id="login" class="text-center">
    <form id="loginForm" class="form-signin" @submit.prevent="login">
    <div id="loginDiv">
      <div style="background-color: rgba(106, 125, 189, .5); padding: 10px; margin: 5px;">
    <h1 class="h3 mb-3 font-weight-normal divItem" style="margin: 0px;">Patient/Provider Sign In</h1></div>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
    <label for="username" class="sr-only"/>
      <input
        type="text"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only"/>
      <input
        type="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <label for="userType" class="sr-only"/>
      <button class="submit" type="submit" style="margin: 0px 20px 10px;">Sign in</button>
    
      <p style="margin-bottom: 10px; font-weight: 400;"> Are you a new patient?</p><router-link :to="{ name: 'register' }" style="color: #ff0000; font-weight: bold;">Click here to register!</router-link>
      </div>
    </form>

  </div>
</div>
</template>

<script>
import auth from '../auth';

export default {
  name: 'login',
  components: {},
  props:{
    apiPath: String
  },
  data() {
    return {
      office: {
        id: '',
        officeName: '',
        officeAddress: '',
        officeCity: '',
        officeState: '',
        officeZip: '',
        officePhone: '',
        visitCost: '',
        weekdayHours: '',
        satHours: '',
        sunHours: ''
      },
      user: {
        username: '',
        password: '',
        userType: '',

      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/login`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user),
      })
        .then((response) => {
          if (response.ok) {
            return response.text();
          } else {
            this.invalidCredentials = true;
          }
        })
        .then((token) => {
          if (token != undefined) {
            if (token.includes('"')) {
              token = token.replace(/"/g, '');
            }
            auth.saveToken(token);
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
          }
        })
        .catch((err) => console.error(err));
    },
    logout() {
      auth.logout();
      this.$router.push('/');
    },

    getOffice(){
       fetch(this.apiPath + '/api/info')
      .then(response => {
      return response.json();
       })
      .then(parsedData => {
      this.office = parsedData[0];
       })
     .catch((err => console.log(err)));
    }

  },
  created(){
    this.getOffice();
  }

};
</script>

<style>
td {
  font-size: 1.5em;
}
#Info {
  display: flex;
  width: 100%;
  justify-content: center;
  padding-top: 0px;
  color: rgb(69, 66, 75);
  margin-bottom: 10px;
}
#Info p {
  margin-bottom: 10px;
}

#Info div {
  float: left;
  width: 40%;
  background-color: rgba(248, 246, 246, .7);
  padding: 30px;
  margin:5px;
  text-align: center;
  padding-bottom: 20px;
}

#loginForm {
  display: flex;
  width: 100%;
  justify-content: center;
  color: rgb(69, 66, 75);
}
.divItem {
  margin-bottom: 20px;
}

#loginDiv {
  width: 45%;
  padding: 30px;
  padding-bottom: 20px;
  background-color: rgba(248, 246, 246, .7);
  text-align: center;
  justify-content: center;
}

#loginDiv > input{
  height: 40px;
  width: 90%;
  padding: 10px;
  border: 2px solid #6A7DBD;
  border-radius: 7%;
  margin: 10px;
}
</style>