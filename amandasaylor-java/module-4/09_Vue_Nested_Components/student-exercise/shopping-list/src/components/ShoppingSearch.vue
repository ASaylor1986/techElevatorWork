<template>
    <form class="search">
        <input type="text" id="search" name="search" v-on:keyup="filterTasks" v-model="searchText" placeholder="Search Shopping List..."/>
    </form>
</template>

<script>
export default {
    name: 'shopping-search',
    data() {
        return {
            searchText: ''
        };
    },
    methods: {
        filterTasks() {
            this.$emit('filter-tasks', this.searchText);
        }
    }
}
</script>

<style scoped>

form {
    display: flex;
    justify-content: flex-end;
    padding: 0.5em;
}

form * {
    padding: 0.5em;
    margin: 1em;
}

form input {
    flex: 2;
    font-size: 1em;
}

form button {
    width: 20%;
}

</style>