<template>
  <div id="app">

    <burst-background><div style="font-size: 64px">{{ allText }}</div></burst-background>


    <input-emitter v-on:entered-text="addTextToAllText"></input-emitter>
    <input-emitter color="skyblue" @entered-text="addTextToAllText"></input-emitter>
    <input-emitter color="lightseagreen" @entered-text="addTextToAllText"></input-emitter>



  </div>
</template>

<script>
import emoji from 'node-emoji';


import HelloWorld from './components/HelloWorld.vue';
import BurstBackground from './components/BurstBackground.vue';
import InputEmitter from './components/InputEmitter.vue';

export default {
  name: 'app',
  components: {
    HelloWorld,
    BurstBackground,
    InputEmitter
  },
  data() {
    return {
      allText : ''
    }
  },
  methods: {
    addTextToAllText(text) {
      this.allText += ' ' + emoji.get(text);
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
}
</style>
