<template>
<div>
    <h1>8강전 1라운드</h1>
    <h2>마음이 가는 사용자를 선택해주세요</h2>
    <img src="../../assets/logo.png" v-on:click="selectUser" />
    <h1>VS</h1>
    <img src="../../assets/logo.png" v-on:click="selectUser" />
</div>

</template>

<script>
export default {
    methods: {
        selectUser() {
            console.log("haha")
        }
    }
}
</script>


<style scoped>
img {
    border: 5px solid rgb(215, 213, 71);
}
</style>
