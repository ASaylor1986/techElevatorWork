<template>
    <table>
        <tr v-for="r in rowCount" :key="r">
            <td v-for="c in colCount" :key="c" v-on:mouseenter="changeCellColor">
                <span v-show="currentRow == r && currentCol == c">🦄</span>
            </td>
        </tr>
    </table>
</template>

<script>
export default {
    data() {
        return {
            currentRow: 1,
            currentCol: 1,
            rowCount: 10,
            colCount: 10
        }
    },
    methods: {
        handleArrowKeys(event) {
            if (event.key === 'ArrowLeft' && this.currentCol > 1) this.currentCol--;
            if (event.key === 'ArrowRight' && this.currentCol < this.colCount) this.currentCol++;
            if (event.key === 'ArrowUp' && this.currentRow > 1) this.currentRow--;
            if (event.key === 'ArrowDown' && this.currentRow < this.rowCount) this.currentRow++;
        },
        changeCellColor(event) {
            event.target.style.backgroundColor = `rgb(${this.random256()}, ${this.random256()}, ${this.random256()})`;
        },
        random256() {
            return Math.floor(Math.random() * 256);
        }
    },
    created() {
        document.addEventListener('keyup', this.handleArrowKeys);
    },
    destroyed() {
        document.removeEventListener('keyup', this.handleArrowKeys);
    }
}
</script>

<style scoped>
table {
    table-layout: fixed;
    border-collapse: collapse;
    border: 1px solid black;
    width: 100%;
    font-size: 2em;
}

td {
    border: 1px solid black;
    height: 2em;
}

</style>
