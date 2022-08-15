<template>
    <div>
        <div class="quiz-main" v-for="(element, index) in questions.slice(a,b)" :key="index" style="margin-left: 20px; margin-right: 20px">

            <v-progress-linear id="progressBar" rounded v-model="percentage" style="width:100%; border-radius:20px;" height="30" color="#7048e8" >
                <strong style="color: white;"> {{ percentage }}%</strong>
            </v-progress-linear>
                
            <div class="box-question" >
                <h1 id="questionText"> {{ element.question }}</h1>
            </div>
            <div id="box-answers" style="padding-bottom: 50px;">
                <v-btn id="box-answer" v-on:click="selectLeftAnswer(element)" v-bind:color="clickedLeft ? '#666666' : '#F3F4F6'" > {{ element.suggestions[0].suggestionContent }} </v-btn>
                <v-btn id="box-answer" v-on:click="selectRightAnswer(element)" v-bind:color="clickedRight ? '#666666' : '#F3F4F6'" > {{ element.suggestions[1].suggestionContent }} </v-btn>                
            </div>

            <div style="text-align: center;"> 
                <v-btn block id="nextBtn" @click="goNextQuestion" color="#7048e8" rounded style="height: 50px">다음</v-btn>
                <v-snackbar v-model="alert" Bottom flat color="red" rounded="pill" :timeout="1500">
                <span class="snackText">
                    한 가지를 선택해주세요
                </span>
                </v-snackbar>
            </div>
        </div>

        
    </div>

</template>

<script>
import { useAppStore } from '../../store/userState'
import { setUser } from '../../worker/user';

export default {
    setup() {
        const store = useAppStore();
        return { store }
    },
    data() {
        return {
            a: 0,
            b: 1,
            initial: 0,
            alert: false,
            clickedLeft: false,
            clickedRight: false,
            questions: [
                {
                    question: "당신은 당신의 반려동물과 모르는 사람 중 하나만 살릴 수 있다. 당신은 누구를 살릴 것인가? ",
                    suggestions: [
                        { suggestionContent: "반려동물", answer: "Y"},
                        { suggestionContent: "모르는 사람", answer: "N"}
                    ],
                    userTableColName: "petPrefer"
                },
                {
                    question: "약속이 끝나고 아무도 없는 집에 혼자 있을 때",
                    suggestions: [
                        { suggestionContent: "어둡고 외로워", answer: "E"},
                        { suggestionContent: "혼자만의 시간 행복해.", answer: "I"}
                    ],
                    userTableColName: "mbtiMind"
                },
                {
                    question: "사과 하면 떠오르는 것은?",
                    suggestions: [
                        { suggestionContent: "빨갛다 맛있다", answer: "S"},
                        { suggestionContent: "뉴턴 백설공주", answer: "N"}
                    ],
                    userTableColName: "mbtiRecog"
                },
                {
                    question: "나 교통사고 났어.",
                    suggestions: [
                        { suggestionContent: "보험 들었어? 병원 갔어?", answer: "T"},
                        { suggestionContent: "많이 다쳤어? 괜찮아?", answer: "F"}
                    ],
                    userTableColName: "mbtiJudge"
                },
                {
                    question: "오늘은 친한 친구들과의 약속이다. 당신의 도착시간은?",
                    suggestions: [
                        { suggestionContent: "약속시간 10분 전", answer: "J"},
                        { suggestionContent: "5분 지각", answer: "P"}
                    ],
                    userTableColName: "mbtiTactics"
                }
            ]
        }
    },
    methods: {
        selectLeftAnswer(object) {
            // toggle event
            this.clickedLeft = !this.clickedLeft
            if(this.clickedRight) {
                this.clickedRight = !this.clickedRight
            }

            // update value in user object
            this.store.user[object.userTableColName] = object.suggestions[0].answer
        },
        selectRightAnswer(object) {
            // toggle event
            this.clickedRight = !this.clickedRight
            if(this.clickedLeft) {
                this.clickedLeft = !this.clickedLeft
            }

            // update value in user object
            this.store.user[object.userTableColName] = object.suggestions[1].answer
        },
        goNextQuestion() {
            if(this.clickedLeft === false && this.clickedRight === false) {
                this.alert = true;
                return;
            } else {
                this.clickedLeft = false
                this.clickedRight = false
                if(this.b >= this.questions.length) {
                    setUser()
                    this.$router.push("/").catch(() => {});
                } else {
                    this.a++;
                    this.b++;
                }
            }

            
        }
    },
    computed: {
        percentage: function () {
            return parseInt(this.a / this.questions.length * 100);
        }
    }
}
</script>

<style lang="scss" scoped>


#progressBar {
    margin-top: 80px;
    display: flex;
    justify-content:center;
    align-items: center;
}

#questionText{
    text-align: center;
    margin-top: 50px;
    padding-bottom:50px;
    font-size: 24px;
}

#box-answers {
    text-align: center;
}

#box-answer {
    width:150px;
    height:150px;
    list-style: none;
    line-height: 2;
    margin-left: 10px;
    margin-right: 10px;
    border: 1px solid #DDDDDD;
    border-radius: 15px;
    font-size: 12px;
    cursor: pointer;
}

#nextBtn {
    margin-top: 50px;
    color: white;
    font-size: 24px;
}

</style>