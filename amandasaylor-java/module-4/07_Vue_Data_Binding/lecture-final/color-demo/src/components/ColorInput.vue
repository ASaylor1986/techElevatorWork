<template>
    <div>
        <input :class="{big : currentColor === 'pink'}" :style="{backgroundColor: currentColor}" type="text" v-model="currentColor">
        <span v-show="currentColor === 'purple'">Purple is awesome!</span>
    </div>
</template>

<script>
export default {
    data() {
        return {
            currentColor: 'gray'
        }
    }
}
</script>

<style>

.big {
    font-size: 32pt;
}

</style>
