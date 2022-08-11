<template>
  <div class="chat-input-wrapper">
    <input
      type="textarea"
      placeholder="메세지를 입력하세요."
      @input="updateText($event)"
    />
    <button type="button">-></button>
  </div>
</template>

<script>
export default {
  name: "ChatRoomMessageInput",
  data() {
    return {
      text: '',
    }
  },
  methods: {
    updateText(event) {
      this.text = event.target.value;
    }
  }
};
</script>

<style lang="scss" scoped>
button {
  width: 20px;
  height: 20px;
  margin: 10px 0;
  all: unset;
  cursor: pointer;
  transition: background-color 100ms;

  &:hover {
    background-color: #fefefe;
    border-radius: 50%;
  }
}

input[type="textarea"] {
  height: 20px;
  width: calc(100% - 50px);
  margin-right: 12px;
  border-radius: 10px;
  background-color: #dee2e6;
}
</style>
