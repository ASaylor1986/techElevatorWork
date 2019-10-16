<template>
    <div class="users">
        <h1>Users</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="user in users" :key="user.id">
                    <td><router-link :to="{name: 'user', params: {id: user.id}}">{{user.id}}</router-link></td>
                    <td>{{user.name}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import userService from '@/service/UserService.js';

export default {
    data() {
        return {
            users: []
        }
    },
    methods: {
        getUsers() {
            userService.list().then(users => this.users = users);
        }
    },
    created() {
        this.getUsers();
    }
}
</script>

<style>
td, th {
    padding: 6px;
    margin: 0;
}
tr:nth-child(even) {
    background-color: lightgray;
}
</style>
