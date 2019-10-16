<template>
  <div id="app" >
    <shopping-list></shopping-list>
  </div>
</template>

<script>
import ShoppingList from './components/ShoppingList';

export default {
  name: 'app',
  components: {
    ShoppingList
  }
}
</script>

<style>
body {
  background: #FF00FF;
  background: radial-gradient(circle, #FF00FF 50%, #FF00FF 100%);
}
</style>
