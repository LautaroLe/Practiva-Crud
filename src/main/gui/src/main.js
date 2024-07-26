import { createApp } from 'vue'
import App from './App.vue'

import router from './router'
import store from './store' //no se para que sirve
import '@/assets/bootstrap.min.css'

createApp(App).use(store).use(router).mount('#app')
