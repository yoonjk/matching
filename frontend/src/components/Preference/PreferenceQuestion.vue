<template>
    <div>
        <div class="quiz-main" v-for="(element, index) in questions.slice(a,b)" :key="index">

            <v-progress-linear id="progressBar" rounded v-model="percentage" height="30" color="#FEBC0E" >
                <strong style="color: white;"> {{ percentage }}%</strong>
            </v-progress-linear>
                
            <div class="box-question">
                <h1 id="questionText"> {{ element.question }}</h1>
            </div>
            <div id="box-answers" style="padding-bottom: 50px;">
                <v-btn id="box-answer" v-for="(item, index) in element.suggestions" :key="index"> {{ item.suggestion }} </v-btn>
                
            </div>
        </div>

        <div style="text-align: center;"> 
            <v-btn block id="nextBtn" @click="goNextQuestion" color="#FEBC0E" rounded >다음</v-btn>
        </div>
    </div>

</template>

<script>
export default {
    data() {
        return {
            a: 0,
            b: 1,
            initial: 0,
            questions: [
                {
                    question: "question 1",
                    suggestions: [
                        { suggestion: "a1"},
                        { suggestion: "b1"}
                    ]
                },
                {
                    question: "question 2",
                    suggestions: [
                        { suggestion: "a2"},
                        { suggestion: "b2"}
                    ]
                },
                {
                    question: "question 3",
                    suggestions: [
                        { suggestion: "a3"},
                        { suggestion: "b3"}
                    ]
                },
            ]
        }
    },
    methods: {
        goNextQuestion() {
            if(this.b >= this.questions.length) {
                this.$router.push("/faceFinal").catch(() => {}); // FIXME: path change
            } else {
                this.a++;
                this.b++;
            }
        }
    },
    computed: {
        percentage: function () {
            console.log(this.b)
            return parseInt(this.a / this.questions.length * 100);
        }
    }
}
</script>

<style scoped>

#progressBar {
    margin-top: 30px;
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

#box-answers {
    text-align: center;
}

#box-answer {
    width:160px;
    height:180px;
    list-style: none;
    line-height: 2;
    border: 1px solid #cdd2d2;
    margin-bottom: 20px;
    border-radius: 15px;
    cursor: pointer;
}

#box-answer:hover{
    background-color: #e7eae0;
}
</style>