import Vue from 'vue'
import Router from 'vue-router'
import auth from './auth'
import DoctorDashboard from './views/DoctorDashboard.vue'
import PatientDashboard from './views/PatientDashboard.vue'
import Login from './views/Login.vue'
import Register from './views/Register.vue'
import UpdateOfficeInfo from './views/UpdateOfficeInfo.vue'


Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/doctor_dashboard",
      name: "doctor_dashboard",
      component: DoctorDashboard,
      Event,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/patient_dashboard",
      name: "patient_dashboard",
      component: PatientDashboard,
      Event,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/update_office_info",
      name: "updateOfficeInfo",
      component: UpdateOfficeInfo,
      meta: {
        requiresAuth: false
      }
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);
  const user = auth.getUser();

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && !user) {
      next("/");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
