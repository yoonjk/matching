import axios from "axios";
import Vue from "vue";
import { createPinia, PiniaVuePlugin } from "pinia";

import App from "./App.vue";

Vue.config.productionTip = false;
Vue.prototype.$axios = axios;
Vue.use(PiniaVuePlugin);

const pinia = createPinia();

new Vue({
  render: (h) => h(App),
  pinia,
}).$mount("#app");
