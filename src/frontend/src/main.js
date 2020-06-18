import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import router from './router'
import vuex from 'vuex'
import {store} from "./store";
import axios from "axios";
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'



Vue.config.productionTip = false
Vue.prototype.$http = axios
Vue.use(vuex)
Vue.use(BootstrapVue)
Vue.use(IconsPlugin)

new Vue({
  vuetify,
  router,
  vuex,
  store,
  BootstrapVue,
  IconsPlugin,
  axios,
  render: h => h(App)
}).$mount('#app')
