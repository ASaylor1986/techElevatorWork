<template>
    <button v-on:click="clickHandler" >{{msg}}</button>
</template>

<script>
export default {
    props: {
        btnmsg: String
    },
    data() {
        return {
            msg: this.btnmsg
        }
    },
    methods: {
        clickHandler() {
            this.$emit('magic-click');
            this.msg = this.msg.split('').reverse().join('');
        }
    }
}
</script>

<style>

</style>

