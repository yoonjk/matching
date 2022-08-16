<template>
    <div>
        <div id="box-retry" style="text-align: center; margin-left: 15px; margin-right: 15px;"> 
                <v-btn block id="retryBtn" @click="retry" color="#868e96" rounded style="margin-top: 50px">다시하기(500원)</v-btn>
        </div>

        <v-container fluid style="margin-top: 30px;">
            <v-row dense id="main">
            <v-col v-for="(person, index) in people.slice(0,1)" :key="index" cols="12" xs="12">
                <v-card id="mainCard" class="pa-3" outlined v-on:click="goDetailPage(person.userId)" style="border:5px solid #b197fc;" color="#FFFFFF">
                <div id="percentLabel" style="background-color: #b197fc; " > {{person.fitPercent}}% match  </div>
                <img id="topImage" :src="getProfile(index)" @click="goDetailPage(person.userId)"/>
                <v-spacer></v-spacer>
                <v-card rounded id="nameLabel">{{person.name}}</v-card>
                </v-card>
            </v-col>
            </v-row>
           
            <v-row dense id="sub">
            <v-col v-for="(person, index) in people.slice(1)" :key="index" cols="6" xs="6">
                <v-card id="subCard" class="pa-3" outlined v-on:click="goDetailPage(person.userId)" style=" border:5px solid #b197fc; " color="#FFFFFF">
                <div id="percentLabel" style="background-color: #b197fc; "> {{person.fitPercent}}% match </div>
                <img id="bottomImages" :src="getProfile(index)" @click="goDetailPage(person.userId)"/>
                <v-spacer></v-spacer>
                <v-card rounded id="nameLabel">{{person.name}}</v-card>
                </v-card>
            </v-col>
            </v-row>
        </v-container>

    </div>
    
</template>

<script>
import { useAppStore } from '../../store/userState'
import { fetchUser, fetchMyData } from '../../worker/user';

export default {
    setup(){
        const store = useAppStore()
        return {store}
    },
    data() {
        return {
            a: 0,
            b: 1,
            finalUser: null,
            finalMyData: null,
            reponses: [],
            myDatas: [],
            people: [
                {
                    "userId": "user1",
                    "mydataId": "user1",
                    "job": "coder",
                    "mbtiMind": "I",
                    "mbtiRecog": "N",
                    "mbtiJudge": "F",
                    "mbtiTactics": "P",
                    "userPoint": 20000,
                    "petPrefer": "N",
                    "nickname": "위대한 고양이",
                    "agreeFlag": "Y",
                    "hobby": "재테크/투자",
                    "profileFilename": "m_1000.jpg",
                    "name": "박상현",
                    "gender": "M",
                    "age": 28,
                    "address": "서울시 서초구 방배동",
                    "assets": "20000000",
                    "consumePtn1": "투자",
                    "consumePtn2": "식비",
                    "consumePtn3": "교통",
                    "investProp": "고위험",
                    "fitPercent": "100"
                },
                {
                    "userId": "user2",
                    "mydataId": "user2",
                    "job": "IT",
                    "mbtiMind": "I",
                    "mbtiRecog": "N",
                    "mbtiJudge": "F",
                    "mbtiTactics": "P",
                    "userPoint": 200000,
                    "petPrefer": "N",
                    "nickname": "위대한 강아지",
                    "agreeFlag": "Y",
                    "hobby": "게임/코딩/프로그래밍",
                    "profileFilename": "m_1002.jpg",
                    "name": "변상운",
                    "gender": "M",
                    "age": 26,
                    "address": "서울시 강남구 청담동",
                    "assets": "100000000",
                    "consumePtn1": "식비",
                    "consumePtn2": "투자",
                    "consumePtn3": "패션/쇼핑",
                    "investProp": "중위험",
                    "fitPercent": "97"
                },
                {
                    "userId": "user3",
                    "mydataId": "user3",
                    "job": "학생",
                    "mbtiMind": "I",
                    "mbtiRecog": "N",
                    "mbtiJudge": "F",
                    "mbtiTactics": "J",
                    "userPoint": 69000,
                    "petPrefer": "Y",
                    "nickname": "위대한 거북이",
                    "agreeFlag": "Y",
                    "hobby": "스포츠/피트니스",
                    "profileFilename": "m_1003.jpg",
                    "mydataId": "user3",
                    "name": "테스터3",
                    "gender": "M",
                    "age": 31,
                    "address": "서울특별시 송파구 잠실동",
                    "assets": "80000000",
                    "consumePtn1": "여행/숙박",
                    "consumePtn2": "패션/쇼핑",
                    "consumePtn3": "투자",
                    "investProp": "저위험",
                    "fitPercent": "94"
                },
                {
                    "userId": "user4",
                    "mydataId": "user4",
                    "job": "교수",
                    "mbtiMind": "E",
                    "mbtiRecog": "S",
                    "mbtiJudge": "T",
                    "mbtiTactics": "J",
                    "userPoint": 44000,
                    "petPrefer": "Y",
                    "nickname": "위대한 토끼",
                    "agreeFlag": "Y",
                    "hobby": "음악/악기",
                    "profileFilename": "m_1005.jpg",
                    "mydataId": "user4",
                    "name": "테스터4",
                    "gender": "M",
                    "age": 30,
                    "address": "서울특별시 송파구 마천동",
                    "assets": "150000000",
                    "consumePtn1": "문화/여가",
                    "consumePtn2": "뷰티/미용",
                    "consumePtn3": "경조/선물",
                    "investProp": "초저위험",
                    "fitPercent": "90"
                },
                {
                    "userId": "user5",
                    "mydataId": "user5",
                    "job": "은행원",
                    "mbtiMind": "I",
                    "mbtiRecog": "N",
                    "mbtiJudge": "F",
                    "mbtiTactics": "P",
                    "userPoint": 12000,
                    "petPrefer": "N",
                    "nickname": "위대한 뱀",
                    "agreeFlag": "Y",
                    "hobby": "어학",
                    "profileFilename": "w_2415.jpg",
                    "name": "테스터5",
                    "gender": "W",
                    "age": 26,
                    "address": "서울특별시 서초구 반포동",
                    "assets": "380000000",
                    "consumePtn1": "교육/학습",
                    "consumePtn2": "문화/여가",
                    "consumePtn3": "식비",
                    "investProp": "저위험",
                    "fitPercent": "86"
                }
            ]
        }
    },
    methods: {
        retry() {
            // TODO: implement decrease point
            this.$router.push("/mindQuestion").catch(() => {});
        },
        async goDetailPage(userId) {
            // fetch user and myData object for finalUser
            this.finalUser = await fetchUser(userId)
            this.finalMyData = await fetchMyData(userId)

            this.$router.push({name: 'MatchDetail', params: {user: this.finalUser, mydata : this.finalMyData}})
        },
        getProfile(i){
            return require("@/assets/" + this.people[i].profileFilename)
        }
    },
    beforeMount() {
        // this.people = this.store.aiResult    // assign reponse to people array
    }
}
</script>


<style scoped>

#main{
  margin : 10px;
  display : flex;
  align-items:center;
}
#sub{
  margin : 10px;
  display : flex;
  align-items:center;
}

#mainCard {
    display:flex;
    justify-content:center;
    align-items: center;
    flex-direction: column;
    color: white;
    height: 400px;
    border-radius: 20px;
}

#subCard {
    display:flex;
    justify-content:center;
    align-items: center;
    flex-direction: column;
    color: white;
    height: 250px;
    border-radius: 20px;
    margin-bottom: 20px;
}

#percentLabel {
    width: 90%;
    display: flex;
    align-items: center;
    justify-content:center; 
    transform: translateY(-50%);
    border-radius: 0 0 10px 10px;
    color: white;
}

#retryBtn {
    display : flex;
    align-items:center;
    color: white;
}

#box-user {
    background-color: #C4C4C4;
}   

#topImage {
    height: 80%;
    width: 80%;
    object-fit: cover;
    border-radius: 20px;
    margin-bottom: 10px;
}

#bottomImages {
    height: 80%;
    width: 80%;
    object-fit: cover;
    border-radius: 20px;
    margin-bottom: 10px;
}

#nameLabel {
    color: white;
    background-color: #7950f2;
    width: 90%;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 12px;
}


</style>