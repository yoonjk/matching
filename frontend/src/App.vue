<template>
  <div id="app">
    <!-- <img alt="Vue logo" src="./assets/logo.png"> -->
    <ChatMain msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import ChatMain from './components/chat/ChatMain.vue'

export default {
  name: 'App',
  components: {
    //HelloWorld,
    ChatMain
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
