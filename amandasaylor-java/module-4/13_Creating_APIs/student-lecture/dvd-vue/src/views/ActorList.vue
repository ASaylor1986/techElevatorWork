<template>
  <div class="container">
  <form class="form-inline" @submit.prevent="getActors">
    <input class="form-control" placeholder="Search" v-model="searchText">
    <input class="btn btn-primary" value="Submit" type="submit">
  </form>
  <table class="table">
    <tr>
      <th>Name</th>
    </tr>
      <tr v-for="(actor, index) in actors" :key="index">
        <td>{{actor.firstName}} {{actor.lastName}}</td>
      </tr>
  </table>
  </div>
</template>

<script>
export default {
    props: {
        apiPath: String
    },
    data() {
        return {
            actors: [],
            searchText: ''
        }
    },
    methods: {
        getActors(){
            fetch(this.apiPath + 'actors?search=' + this.searchText)
            .then(response => response.json())
            .then(parsedData => this.actors = parsedData)
            .catch(err => console.log(err));
        }
    }

};
</script>

<style>
</style>
