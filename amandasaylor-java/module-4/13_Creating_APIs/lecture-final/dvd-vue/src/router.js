import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/Home.vue'
import ActorList from './views/ActorList.vue'
import FilmList from './views/FilmList.vue'
import CustomerList from './views/CustomerList.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/actors',
      name: 'actors',
      component: ActorList
    },
    {
      path: '/films',
      name: 'films',
      component: FilmList
    },
    {
      path: '/customers',
      name: 'customers',
      component: CustomerList
    }
  ]
})
