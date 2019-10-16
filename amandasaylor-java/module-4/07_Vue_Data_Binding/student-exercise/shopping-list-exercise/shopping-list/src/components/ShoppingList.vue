<template>
  <div class="shopping-list">
    <h1>My Shopping List</h1>
    <ul>
      <li v-for="grocery in groceries" :class="{completed: grocery.completed === true}">
        {{grocery.item}}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "shopping-list",
  data() {
    return {
      groceries: [
        {item: "milk", completed: true}, {item: "bread", completed: true}, {item: "eggs", completed: true}, {item: "flour", completed: false}, {item: "sugar", completed: false}, {item: "bananas", completed: false}, 
        {item: "apples", completed: false}, {item: "cookies", completed: false}, {item: "cheese", completed: false}
      ]
    }
  }

}
</script>

<style>
.shopping-list {
  width:450px;
  background: #fff;
  margin: 50px auto;
  font-family: 'Roboto Condensed', sans-serif;
  border-radius: 10px;
}
h1 {
  background:#f2f2f2;
  color:#5c8578;
  padding:10px;
  font-size:24px;
  text-transform: uppercase;
  text-align: center;
  margin-bottom: 0px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}
ul {
  list-style-type: none;
  margin:0px;
  padding:0px;
}
li {
  font-size: 24px;
  border-bottom:1px solid #f2f2f2;
  padding:10px 20px;
}
li:last-child{
  border:0px;
}
li.completed {
  text-decoration: line-through;
  color:darkgrey;
}
</style>
