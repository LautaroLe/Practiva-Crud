import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

import AddUser from '@/components/AddUser.vue'
import UsersList from '@/components/UsersList.vue'
import User from '@/components/User.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/users',
    name: 'users',
    component: UsersList
  },
  {
    path: '/user/:id',
    name: 'user',
    component: User
  },
  {
    path: '/create-user',
    name: 'create-user',
    component: AddUser
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
