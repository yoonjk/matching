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

        <div id="answers" style="padding-bottom: 50px;">
            <v-btn id="answer1" color="#666666">비슷한 사람</v-btn>
            <v-btn id="answer2" color="#F3F4F6">반대의 사람</v-btn>
        </div>
        
        <div style="text-align: center;"> 
            <v-btn id="nextBtn" @click="goNextPage" color="#FEBC0E" rounded >다음</v-btn>
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
    padding-bottom:50px;
}

#questionText{
    text-align: center;
    padding-bottom:50px;
}

#answers{
    text-align: center;
    border: 1px;
    border-color:#DDDDDD
}

#answer1{
    width:160px;
    height:180px;
    color: #FFFFFF
}

#answer2{
    width:160px;
    height:180px;
    color: #000000
}
</style>