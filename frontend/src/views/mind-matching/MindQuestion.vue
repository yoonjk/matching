<template>
    <div>
        <div id="steps">
            <v-avatar id="step1" color="#FEBC0E" size="36">1</v-avatar>
            <v-avatar id="step2" color="#FEBC0E" size="36">2</v-avatar>
            <v-avatar id="step3" color="#FEBC0E" size="36">3</v-avatar>
        </div>
        <div>
            <h1 id="guideText">매칭 전 몇 가지만 확인할게요!</h1>
            <h1 id="questionText">질문 어쩌구 저쩌구</h1>
        </div>

    </div>
</template>

<script>
export default {
    
}
</script>

<style scoped>
#steps {
    padding-top:50px;
    padding-left:10px;
    padding-bottom:50px;
    font-size: 16px;
    color: white;
}

#step1{
    margin-right:20px;
}
#step2{
    margin-right:20px;
}
#step3{
    margin-right:20px;
}

#guideText{
    text-align: center;
    font-weight: normal;
    font-size: 20px;
}

</style>