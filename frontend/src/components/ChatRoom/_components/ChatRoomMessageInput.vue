<template>
  <div class="chat-input-wrapper">
    <AddSVG />
    <input
      type="textarea"
      placeholder="메세지를 입력하세요."
      @input="updateText($event)"
      @keyup.enter="confirmText($event)"
    />
    <button type="button">-></button>
  </div>
</template>

<script>
import AddSVG from "@/assets/icons/add.svg";
export default {
  name: "ChatRoomMessageInput",
  data() {
    return {
      text: "",
    };
  },
  methods: {
    updateText(event) {
      this.text = event.target.value;
    },
    confirmText() {
      this.$emit("sentMessageContent", this.text);
      this.text = "";
    },
  },
  components: {
    AddSVG,
  }
};
</script>

<style lang="scss" scoped>
.chat-input-wrapper {
  display: flex;
  justify-content: center;
}

button {
  width: 40px;
  height: 40px;
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
  border: none;
  height: 28px;
  width: calc(100% - 50px);
  margin-bottom: 0;
  margin-top: 10px;
  margin-right: 12px;
  padding-left: 10px;
  border-radius: 10px;
  background-color: colors.$GRAY3;

  &:focus {
    outline: none;
  }
}
</style>
