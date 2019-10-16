<template>
  <div id="app">
    <fun-table />
  </div>
</template>

<script>
import FunTable from './components/FunTable.vue';

export default {
  name: 'app',
  components: {
    FunTable
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
