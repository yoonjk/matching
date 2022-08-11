<template>
  <div id="app">
    <StatusBar />
    <GNB />
    <!-- <img alt="Vue logo" src="./assets/logo.png" /> -->
    <!-- <HelloWorld msg="Welcome to Your Vue.js App" /> -->
    <RequestList isIn />
    <Test />
  </div>
</template>

<script>
// import HelloWorld from "./components/HelloWorld.vue";
import RequestList from "./components/RequestList";
import StatusBar from "./components/_common/StatusBar.vue";
import GNB from "./components/_common/GNB.vue";

export default {
  name: "App",
  components: {
    // HelloWorld,
    RequestList,
    StatusBar,
    GNB,
  },
};
</script>

<style lang="scss">
@import "./styles/index.scss";
/* #app { */
/* font-family: Avenir, Helvetica, Arial, sans-serif; */
/* -webkit-font-smoothing: antialiased; */
/* -moz-osx-font-smoothing: grayscale; */
/* text-align: center; */
/* color: #2c3e50; */
/* margin-top: 60px; */
/* } */

#app {
  background-color: #f1f3f5;
}
</style>
