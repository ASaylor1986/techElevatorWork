<template>
  <div id="app">
    <the-header/>
    <left-sidebar />
    <right-sidebar/>
    <main-content/>
    <the-footer />
    <aside class="sidebar-left">Left Sidebar</aside>
    <article>Article</article>
    <aside class="sidebar-right">Right Sidebar</aside>
    <footer>Footer</footer>
  </div>
</template>

<script>

import TheHeader from '.components/TheHeader.vue';
import LeftSidebar from '.components.LeftSidebar.vue';
import MainContent from '.components.MainContent.vue';
import RightSidebar from '.components.RightSidebar.vue';
import TheFooter from '.components.TheFooter.vue';

export default {
  name: "app",
  components: {
    TheHeader,
    LeftSidebar,
    RightSidebar,
    MainContent,
    TheFooter

  }
};
</script>

<style>
body {
  margin: 0px;
  padding: 0px;
}
#app {
  display: grid;
  grid-template-columns: 150px auto 150px;
  grid-template-rows: 60px 1fr 100px;
  grid-gap: 1em;
  height: 100vh;
}

header,
aside,
article,
footer {
  background: #eaeaea;
  padding: 1em;
  color: #949494;
}

header,
footer {
  grid-column: 1 / 4;
}
</style>