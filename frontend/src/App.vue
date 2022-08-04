<template>
<v-app>
  <MenuBar/>
  <div style="margin-top:30px;">
  <Main/>
  </div>
</v-app>
</template>

<script>
import MenuBar from './components/MenuBar';
import Main from './components/Main';

export default {
  name: 'App',

  components: {
    Main,
    MenuBar
  },

  data: () => ({
    //
  }),
};
</script>
<style>
@font-face {
  font-family: "S-CoreDream-5Medium";
  src: url("https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-5Medium.woff")
    format("woff");
  font-weight: normal;
  font-style: normal;
}
#app {
  font-family: "S-CoreDream-5Medium";
}
</style>