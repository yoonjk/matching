<template>
  <div class="message-box" :style="this.cssVariables">
  </div>
</template>

<script>
export default {
  name: "ChatRoomMessageBox",
  props: {
    onLeft: {
      type: Boolean,
      default: false,
    },
  },
  computed: {
    cssVariables() {
      return {
        marginRight: this.onLeft ? 'auto' : '0',
        marginLeft: this.onLeft ? '0' : 'auto',
        backroundColor: this.conLeft ? '#e9ecef' : '#d0bfff',
      };
    },
  },
};
</script>

<style scoped>
.message-box {
  width: 65vw;
  min-height: 30px;
}
</style>
