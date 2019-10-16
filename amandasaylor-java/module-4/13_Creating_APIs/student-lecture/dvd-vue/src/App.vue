<template>
  <div id="app">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li>
          <router-link to="/actors" class="nav-link">Actors</router-link> 
        </li>
        <li>
          <router-link to="/films" class="nav-link">Films</router-link> 
        </li>
        <li>
          <router-link to="/customers" class="nav-link">Customers</router-link> 
        </li>
      </ul>
    </div>
  </nav>
    <router-view :apiPath="API_PATH"/>
  </div>
</template>

<script>
export default {
  data() {
    return {
      API_PATH: 'http://localhost:8080/mvc-controllers-part1-exercises/api/'
    }
  }  
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: left;
  color: #2c3e50;
}
#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}


</style>
