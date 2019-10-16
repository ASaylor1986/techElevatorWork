<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png" v-show="boxIsChecked === false"><br>
    <input type="checkbox" v-model="boxIsChecked"/>
    <!-- The content of the msg below is props downed to HelloWorld -->
    <HelloWorld v-for="n in 3" msg="Databases are where it's at!"  v-bind:key="n"/>
    <!-- <HelloWorld v-for="n in 3"  v-bind:msg="appendName(n)" v-bind:key="n"/> -->
    <HelloWorld v-for="n in 3" amanda="It's getting hot in here!" v-bind:key="n"/>

    <MagicButton id="hotTemp" btnmsg="Are you hot? I feel hot..." v-on:magic-click="temperature++" /><br>
    <!-- <MagicButton v-on:click="magic-click" /><br> -->
    <MagicButton id="coldTemp" btnmsg="It's cold. Wanna cuddle?" v-on:magic-click="temperature--" />
    <div id="temp"> {{temperatureDisplay}}</div> 
    <div id="weatherMessage">{{appendName('likes winter better 😏')}}</div>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
import MagicButton from './components/MagicButton.vue'

export default {
  name: 'app',
  components: {
    HelloWorld,
    MagicButton
  },
  data() {
    return {
      temperature: 75,
      boxIsChecked: false
    }
  },
  computed: {
    temperatureDisplay() {
      return this.temperature + '🌡'
    }
  },
  methods: {
    appendName(counter) {
      return 'Amanda ' + counter;
    }
  }
}
</script>

<style>


#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  background-color: aquamarine;
}
#temp {
  font-size: 42pt;
}
#hotTemp {
  width: 400px; 
  height: 50px; 
  background-color: red; 
  color: white;
  font-size: 30px;
}

#coldTemp {
  width: 400px; 
  height: 50px; 
  background-color: blue; 
  color: white;
  font-size: 30px;
}

#weatherMessage {
  font-size: 42pt;
}
</style>
