<template>
    <div>
        <MenuBar page="MindQuestion" />
        

        <div fluid style="margin-top: 30px;">
            <v-row dense id="main">
                <v-col v-for="(person, index) in people.slice(0,1)" :key="index" cols="12" xs="12">
                    <v-card id="mainCard"  v-on:click="goDetailPage">
                        <div id="percentLabel" style="background-color: #b197fc;" >100% 매칭</div>
                        <div style="display:flex;width:100%;padding-left:20px;">
                            <div style="width:60%"><img id="topImage" :src="getProfile(index)" @click="goDetailPage"/></div>
                            <div style="width:40%; display:flex; justify-content: center; align-items: center;">
                            <v-col>
                                <v-btn rounded large style="font-size:17px;">상세정보</v-btn>
                                <v-btn rounded large style="margin-top:20px; font-size:17px;">대화요청</v-btn>
                            </v-col>
                            </div>
                        </div>
                        <div style="display:flex; align-items:center;"><v-icon large color="#f8d459" class="mr-2">mdi-crown</v-icon><span style="font-size:25px;font-weight:bold;"> {{person.name}} </span><v-icon large color="#f8d459" class="ml-2">mdi-crown</v-icon></div>
                    </v-card>
                </v-col>
            </v-row>
           
            <v-row dense id="sub">
            <v-col v-for="(person, index) in people.slice(1)" :key="index" cols="6" xs="6">
                <v-card id="subCard"  v-on:click="goDetailPage">
                <div id="percentLabel" style="background-color: #b197fc; ">90% 매칭</div>
                <img id="bottomImages" :src="getProfile(index)" @click="goDetailPage"/>
                <div rounded id="nameLabel">{{person.name}}</div>
                </v-card>
            </v-col>
            </v-row>
        </div>
        
        <div style="text-align: center; margin-bottom:20px;"> 
            <v-btn text dark rounded id="retryBtn" @click="retry">다시하기 (-500P)</v-btn>
        </div>

    </div>
    
</template>

<script>
import { useAppStore } from '../../store/userState'
import MenuBar from "../MenuBar.vue";

export default {
    components : {
        MenuBar
    },
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
                    name: "위대한 오랑우탄",
                    age: "20",
                    userId: "1",
                    profileFilename: "w_2419.jpg"
                },
                {
                    name: "위대한 고양이",
                    age: "21",
                    userId: "2",
                    profileFilename: "w_2420.jpg"
                },
                {
                    name: "김국은3",
                    age: "22",
                    userId: "3",
                    profileFilename: "w_2423.jpg"
                },
                {
                    name: "김국은4",
                    age: "23",
                    userId: "4",
                    profileFilename: "w_2424.jpg"
                },
                {
                    name: "김국은5",
                    age: "24",
                    userId: "5",
                    profileFilename: "w_2427.jpg"
                },
                
            ]
        }
    },
    methods: {
        retry() {
            // TODO: implement decrease point
            this.$router.push("/mindQuestion").catch(() => {});
        },
        goDetailPage() {
            this.$router.push("/matchDetail").catch(() => {});
            // this.$router.push({name: 'MatchDetail', params: {user: this.finalUser, mydata : this.finalMyData}})
        },
        getProfile(i){
            return require("@/assets/" + this.people[i].profileFilename)
        }
    },
    created() {
        // TODO: assign reponse to people array
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
    height: 300px;
    border-radius: 20px;
    border:2px solid #b197fc; 
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
    border:2px solid #b197fc; 
}

#percentLabel {
    width: 85%;
    height:30px;
    display: flex;
    align-items: center;
    justify-content:center; 
    transform: translateY(-50%);
    border-radius: 0 0 20px 20px;
    color: white;
    font-size:20px;
}

#retryBtn {
    /* display : flex;
    align-items:center; */
    /* margin-top: 50px; */
    background-color: #7950f2;
    height:50px;
    font-size:18px;
}

#box-user {
    background-color: #C4C4C4;
}   

#topImage {
    height: 195px;
    width: 195px;
    object-fit: cover;
    border-radius: 100%;
    /* margin-bottom: 10px; */
}

#bottomImages {
    height: 150px;
    width: 150px;
    object-fit: cover;
    border-radius: 100%;
    margin-bottom: 10px;
}

#nameLabel {
    /* color: white;
    background-color: #7950f2; */
    width: 95%;
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 20px;
    font-weight:bold;
}


</style>