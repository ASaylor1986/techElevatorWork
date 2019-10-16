<template>
  <div class="container">
    <form class="form-inline" @submit.prevent="getFilms">
      <div class="form-group">
        <label for="minimumLength">Minimum Length:</label>
        <input class="form-control" name="minimumLength" v-model="minLength">
      </div>
      <div class="form-group">
        <label for="maximumLength">Maximum Length:</label>
        <input class="form-control" name="maximumLength" v-model="maxLength">
      </div>
      <div class="form-group">
        <label for="genre">Genre:</label>
        <select class="form-control" name="genre" v-model="genre">
          <option value="Comedy">Comedy</option>
          <option value="Action">Action</option>
          <option value="Horror">Horror</option>
          <option value="Family">Family</option>
          <option value="Drama">Drama</option>
        </select>
      </div>
      <input class="btn btn-primary" name="search" value="Search" type="submit">
    </form>
    <table class="table">
      <tr>
        <th>Title</th>
        <th>Description</th>
        <th>Release Year</th>
        <th>Length</th>
        <th>Rating</th>
      </tr>
      <tr v-for="film in films" :key="film.title">
        <td>{{film.title}}</td>
        <td>{{film.description}}</td>
        <td>{{film.releaseYear}}</td>
        <td>{{film.length}}</td>
        <td>{{film.rating}}</td>
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
      films: [],
      minLength: 0,
      maxLength: 1000,
      genre: 'Comedy'
    };
  },
  methods: {
    getFilms() {
      fetch(`${this.apiPath}films?minimumLength=${this.minLength}&maximumLength=${this.maxLength}&genre=${this.genre}`)
        .then(response => response.json())
        .then(parsedData => (this.films = parsedData))
        .catch(err => console.log(err));
    }
  }
};
</script>

<style>
</style>
