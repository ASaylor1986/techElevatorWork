<template>
    <div class="search">
        <input type="text" id="search" name="search" placeholder="Search Todo's..."/>
    </div>
</template>

<script>
export default {
    name: 'search-bar',
    data() {
        return {
            searchText: ''
        };
    },
    methods: {
        handleFilter() {
            this.$emit('filter', this.searchText);
        }
    }
}
</script>

<style scoped>
#search {
    width:100%;
    font-size:24px;
    font-family: 'Roboto Condensed', sans-serif;
    margin-top:50px;
    padding:10px;
}
</style>
