<template>
  <div class="hello">
    <h1>{{ msg }} {{ amanda }}</h1>
    
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String, //pulls in the content of the message from App.vue. The content comes down from App into the props, props down
    amanda: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
