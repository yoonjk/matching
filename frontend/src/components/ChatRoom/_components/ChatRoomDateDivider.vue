<template>
  <div class="date-divider-wrapper">
    <div class="date-divider-decortaion"></div>
    <p>{{ `${this.year}년 ${this.month}월 ${this.day}일` }}</p>
  </div>
</template>

<script>
export default {
  name: "ChatRoomDateDivider",
  props: {
    date: {
      type: String, // 'yyyymmdd'
      required: true,
    },
    newYear: {
      type: Boolean,
      default: false,
    },
  },
  computed: {
    year() {
      return this.date.slice(0, 4);
    },
    month() {
      return this.date.slice(4, 6);
    },
    day() {
      return this.date.slice(6, 8);
    },
  },
};
</script>

<style scoped>
.date-divider-wrapper {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 15px;
}

.date-divider-decoration {
  width: 100%;
  height: 1px;
  background-color: #ddd;
  position: absolute;
  z-index: 50;
}

p {
  width: 100%;
  margin: 15px 10px;
  color: #ddd;
  font-size: 12px;
  position: absolute;
  z-index: 51;
}
</style>
