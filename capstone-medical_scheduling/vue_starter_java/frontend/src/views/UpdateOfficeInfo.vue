<template>

  <div class="office">
   <form @submit.prevent="updateOffice" id="officeInfo">
    <div class="officeHeader">
      <h2>Office Information</h2>
    </div>
    <div id="officeInput">
          <div class="officeInfoInput">
          <label for="officeName">Office Name: </label>
          <input type="text" placeholder="Office Name">
          </div>
          <div class="officeInfoInput">
          <label for="officeAddress">Office Address: </label>
          <input type="text" placeholder="Office Address">
          </div>
          <div class="officeInfoInput">
          <label for="officeCity">Office City: </label>
          <input type="text" placeholder="Office City">
          </div>
          <div class="officeInfoInput">
          <label for="officeState">Office State: </label>
          <input type="text" placeholder="Office State">
          </div>
          <div class="officeInfoInput">
          <label for="officeZip">Office Zip: </label>
          <input type="text" placeholder="Office State">
          </div>
          <div class="officeInfoInput">
          <label for="officePhone">Office Phone: </label>
          <input type="text" placeholder="Office Phone">
          </div>
          <div class="officeInfoInput">
          <label for="visitCost">Office Visit Cost: </label>
          <input type="text" placeholder="Office Visit Cost">
          </div>
          <div class="officeInfoInput">
          <label for="officeName">Office Hours: </label>
          <input class="hours" type="text" placeholder="M-F Hours">
          <input class="hours" type="text" placeholder="Sat Hours">
          <input class="hours" type="text" placeholder="Sun Hours">
          </div>  
          <div>
          <button  id="submit" type="submit">Update</button>
          </div>
    </div>
  </form>
  </div>
</template>

<script>
export default {
    props:{
        apiPath: String,
        eventID: Number
    },
    data(){
        return{
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
        }
    },
    methods:{
    
    // getOffice(){
    //    fetch(this.apiPath + '/api/info')
    //   .then(response => {
    //   return response.json();
    //    })
    //   .then(parsedData => {
    //   this.office = parsedData[0];
    //    })
    //  .catch((err => console.log(err)));
    // },
    updateOffice() {
      fetch(`${this.apiPath}/api/info/${this.office.id}`,{
        method: 'POST',
        headers:{
          "Content-Type": "application/json"
        },
        body: JSON.stringify(this.office)
      })
      .then((response) =>{
        if(response.ok){
          this.$emit('showOffice');
        }
      })
      .catch((err) => console.error(err));
    },
    backToDash() {
      this.$router.push('/doctor_dashboard');
    }

    },    
    created(){
      this.getOffice();
    }
};
</script>

<style>
.officeHeader {
  background-color: #6A7dbd;
  color: white;
  text-align: center;
}
h2 {
  font-weight: 300;
  text-align: center;
}
.office {
  margin-top: 20px;
  display: flex;
  justify-content: center;
}
#officeInfo {
  background-color: white;
  width: 25%;
}
#officeInput {
  padding: 10px;
}

label {
  display: inline-block;
}
#officeInput> input {
  float: right;
  padding-right: 30%;
}
.hours {
  display: flex;
  flex-direction: column;
}
</style>
