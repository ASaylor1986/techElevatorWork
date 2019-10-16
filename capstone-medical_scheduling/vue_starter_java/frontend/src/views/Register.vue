<template>
<div id="registrationPage">
  <div id="register" class="text-center">
    <form id="myForm" class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal" style="color: rgb(69, 66, 75);" id="divItem">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        There were problems registering this user.
      </div>
      <label for="username" class="sr-only"/>
      <input
        type="text"
        class="form-control divItem"
        placeholder="Choose a Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only"/>
      <input
        type="password"
        class="form-control divItem"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        class="form-control divItem"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <input
        type="firstName"
        class="form-control divItem"
        placeholder="First Name"
        v-model="user.firstName"
        required
      />
      <input
        type="lastName"
        class="form-control divItem"
        placeholder="Last Name"
        v-model="user.lastName"
        required
        style="margin-bottom: 20px;"
      />


      <div style="100%">
      <router-link :to="{ name: 'login' }" style=" color: #00008b;">
        Have an account?
      </router-link></div>
      <div style="100%">
      <button class="submit" type="submit" style=" margin: 20px;">
        Create Account
      </button> </div>
    </form>
  </div>
  </div>
</template>

<script>
export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        firstName: '',
        lastName: '',
        userType: 'patient',
        officeId: '1'
      },
      registrationErrors: false,
    };
  },
  methods: {
    register() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/register`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user),
      })
        .then((response) => {
          if (response.ok) {
            return (response.json());
          } else {
            this.registrationErrors = true;
            throw 'Register returned: ' + response.status;
          }
        })
        .then ((parsedData) => {
            if (parsedData.success) {
              this.$router.push({ path: '/', query: { registration: 'success' } });
            } else {
              this.registrationErrors = true;
            }
        })
        .catch((err) => console.log(err));
    },
  },
};
</script>

<style>

#registrationPage {
  display: flex;
  justify-content: center;
  
}

#register {
  /* display: flex; */
  margin-top: 10px;
  background-color: rgba(248, 246, 246, .7);
  padding: 30px;
  width: 35%;
  height: auto;
  justify-content: center;
  text-align: center;
  
}

#myForm > input{
  height: 40px;
  width: 90%;
  padding: 10px;
  border: 2px solid #6A7DBD;
  border-radius: 7%;
  margin: 10px;
}



#divItem {
  margin-bottom: 20px;
}
</style>
