<template>
  <div id="app">
    <color-input />
    <color-input />
    <color-input />
    <color-input />
    <color-input />
  </div>
</template>

<script>
import ColorInput from './components/ColorInput.vue';

export default {
  name: 'app',
  components: {
    ColorInput
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
