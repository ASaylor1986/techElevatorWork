<template>
  <div class="container">
    <form method="GET" class="form-inline" v-on:submit.prevent="getCustomers">
      <input name="search" type="text" placeholder="Search" class="form-control"  v-model="search"/>
      <div class="form-group">
        <label for="sortBy">Sort:</label>
        <select name="sortBy" class="form-control" v-model="sortBy">
          <option value="last_name">Last Name</option>
          <option value="email">Email</option>
          <option value="active">Active</option>
        </select>
      </div>
      <input name="submit" value="Search" type="submit" class="btn btn-primary" />
    </form>
    <table class="table">
      <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Active</th>
      </tr>
      
        <tr v-for="customer in customers" :key="customer.email">
          <td>
            {{customer.firstName}}
            {{customer.lastName}}
          </td>
          <td>
            {{customer.email}}
          </td>
          <td>
            {{customer.active ? 'Yes' : 'No'}}
          </td>
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
            customers: [],
            search: '',
            sortBy: 'last_name'
        }

    },
    methods: {
        getCustomers() {
            fetch(this.apiPath + 'customers?search=' + this.search + '&sortBy=' + this.sortBy)
            .then(response => response.json())
            .then(parsedData => this.customers = parsedData);
        }
    }
};
</script>

<style>
</style>
