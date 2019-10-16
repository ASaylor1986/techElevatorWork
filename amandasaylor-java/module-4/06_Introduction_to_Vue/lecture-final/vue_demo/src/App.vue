<template>
  <div id="app">
    <my-demo></my-demo>
    <img alt="Vue logo" src="./assets/logo.png">
    <p>Vue</p>
    <my-demo></my-demo>
    <my-demo></my-demo>
  </div>
</template>

<script>
import MyDemo from './components/MyDemo.vue';

export default {
  name: 'app',
  components: {
    MyDemo
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
