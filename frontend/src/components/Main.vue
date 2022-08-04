<template>
  <v-container>
    
    <v-col>
      <v-row id="match">
        <div style="width:40%"><img src="../assets/logo.png" /></div>
        <div style="width:60%;text-align: center; font-size: 25px;">외모로 연결</div>
      </v-row>
    
      <v-row id="match">
        <div style="width:60%;text-align: center; font-size: 25px;">마음으로 연결</div>
        <div style="width:40%"><img src="../assets/logo.png"/></div>
      </v-row>

      <v-row id="sub">
        <v-col id="chat">
          <div class="d-flex mb-2" style="justify-content: center;">
          <img id="img2" src="../assets/logo.png"/><div id="chat-count">5</div>
          </div>
          <div style="font-size:20px;">대화하기</div>
        </v-col>
        <v-col id="service">
          <div class="d-flex mb-2" style="justify-content: center;">
          <img id="img2" src="../assets/logo.png"/>
          </div>
          <div style="font-size:20px;">사후서비스</div>
        </v-col>
      </v-row>
    </v-col>
  </v-container>
</template>

<script>
export default {
  name: 'Main',
  data: () => ({
    
  })
};
</script>

<style>
#match{
  border-radius : 10px;
  border : 1px solid;
  padding: 20px 20px 20px 20px;
  margin : 10px;
  display : flex;
  align-items:center
}
#sub{
  margin : 10px;
  display : flex;
  align-items:center
}

#chat{
  border-radius : 10px;
  border : 1px solid;
  margin-right: 10px;
  text-align: center;
}
#service{
  border-radius : 10px;
  border : 1px solid;
  text-align: center;
}

img{
  width:100px;
  height:100px;
}

#img2{
  width:50px;
  height:50px;
}
#chat-count{
  font-weight: bold;
  display:flex;
  align-items:center;
  justify-content:center; 
  border:1px solid; 
  border-radius:100%;
  width:25px;
  height:25px;
}
</style>