<template>
    <div>
        <input :style="{backgroundColor: color}" v-model="enteredText"><button @click="sendEvent">Emit</button>
    </div>
</template>

<script>
export default {
    props: {
        color: {
            type: String,
            default: 'red'
        }
    },
    data() {
        return {
            enteredText: '',
        }
    },
    methods: {
        sendEvent() {
            this.$emit('entered-text', this.enteredText)
        }
    }
}
</script>

<style scoped>

</style>
