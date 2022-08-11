<template>
  <div class="screen">
    <h1>{{ user }}</h1>
  </div>
</template>

<script>
import { prevData, user, receiver } from "./_worker/api";

export default {
  name: "ChatRoom",
  data() {
    return {
      dummyOptions: {
        turn: 0,
      },
      messages: prevData,
      user,
      receiver,
    };
  },
  methods: {
    
  },
  created() {
    setInterval(() => {
      dummy;
    });
  },
};
</script>

<style scoped>
.screen {
  width: 100vw;
  height: 100vh;
}

h1 {
  margin: 7px 0;
}
</style>
