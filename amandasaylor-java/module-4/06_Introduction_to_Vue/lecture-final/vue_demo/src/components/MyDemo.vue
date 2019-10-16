<template>
    <div class="main">
        <h2>{{ title }}</h2>
        <p class="description">{{ desc }}</p>
    </div>
</template>

<script>
export default {
    data() {
        return {
            title: 'My Demo',
            desc: 'A very basic demonstration of a component.'
        }
    }

}
</script>

<style scoped>

    p {
        color: green;
    }

</style>
