<template>
    <div>
        <div id="box-retry" style="text-align: center; margin-left: 15px; margin-right: 15px;"> 
                <v-btn block id="retryBtn" @click="retry" color="#868e96" rounded style="margin-top: 50px">다시하기(500원)</v-btn>
        </div>

        <v-container fluid style="margin-top: 30px;">
            <v-row dense id="main">
            <v-col v-for="(person, index) in people.slice(0,1)" :key="index" cols="12" xs="12">
                <v-card id="mainCard" class="pa-3" outlined v-on:click="goDetailPage" style="border:5px solid #b197fc;" color="#FFFFFF">
                <div id="percentLabel" style="background-color: #b197fc; " >100% match</div>
                <img id="topImage" :src="getProfile(index)" @click="goDetailPage"/>
                <v-spacer></v-spacer>
                <v-card rounded id="nameLabel">{{person.name}}, {{person.age}}세</v-card>
                </v-card>
            </v-col>
            </v-row>
           
            <v-row dense id="sub">
            <v-col v-for="(person, index) in people.slice(1)" :key="index" cols="6" xs="6">
                <v-card id="subCard" class="pa-3" outlined v-on:click="goDetailPage" style=" border:5px solid #b197fc; " color="#FFFFFF">
                <div id="percentLabel" style="background-color: #b197fc; ">100% match</div>
                <img id="bottomImages" :src="getProfile(index)" @click="goDetailPage"/>
                <v-spacer></v-spacer>
                <v-card rounded id="nameLabel">{{person.name}}, {{person.age}}세</v-card>
                </v-card>
            </v-col>
            </v-row>
        </v-container>

    </div>
    
</template>

<script>
import { useAppStore } from '../../store/userState'

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
                    name: "김국은1",
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
                {
                    name: "김국은6",
                    age: "25",
                    userId: "6",
                    profileFilename: "w_2435.jpg"
                },
                {
                    name: "김국은7",
                    age: "26",
                    userId: "7",
                    profileFilename: "w_2437.jpg"
                },
                {
                    name: "김국은8",
                    age: "27",
                    userId: "8",
                    profileFilename: "w_2438.jpg"
                },
                {
                    name: "김국은9",
                    age: "28",
                    userId: "9",
                    profileFilename: "w_2441.jpg"
                }
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