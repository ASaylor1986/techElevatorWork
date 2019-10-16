<template>
    <div class="user-profile">
        <h1>User</h1>
        <pre>{{user}}</pre>
        <button @click="handleBackButton">Back to List of Users</button>
    </div>
</template>

<script>
import userService from '@/service/UserService.js';

export default {
    data() {
        return {
            user: null
        }
    },
    methods: {
        getUser(id) {
            userService.get(id).then(user => this.user = user);
        },
        handleBackButton() {
            this.$router.push({name: 'users'});
        }
    },
    created() {
        this.getUser(this.$route.params.id);
    }

}
</script>

<style>

</style>
