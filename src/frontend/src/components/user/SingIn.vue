<template>
    <div class="loginMain">
        <div id="loginMain_1">
            <h1 class="font-weight-bold">SingIn!</h1>
            <b-input-group prepend="아이디" class="mb-3">
                <b-form-input id="userid" type="text"/>
            </b-input-group>
            <b-input-group prepend="비밀번호" class="mb-3">
                <b-form-input id="passwd" type="text"/>
            </b-input-group>
            <div class="mt-3">
                <b-button-group>
                    <b-button @click="singin" variant="success">로그인</b-button>
                    <b-button @click="singup" variant="info">회원가입</b-button>
                </b-button-group>
            </div>
        </div>


    </div>
</template>

<script>
    import {mapState} from "vuex";

    export default {
        name: "login",
        computed: {
            ...mapState({
                resultString: state => state.singin.resultString,
            })
        },
        methods : {
            singin(){
                this.$store.dispatch('singin/login', {
                    userid : document.getElementById('userid').value,
                    passwd : document.getElementById('passwd').value,
                })

            },
            singup(){
                this.$router.push("/singup")
            }
        },
    }
</script>

<style scoped>
    .loginMain{
        margin: 0 auto;
        text-align: center;
        width: 60%;
        height: 1000px;
        background-image: url("https://image.fmkorea.com/files/attach/new/20180928/486616/562458984/1292870465/f03af8a80dbb666e73e9744ed4fea64f.png");

    }
    #loginMain_1{
        margin: 0 auto;
        padding-top: 7%;
        margin-left: 13%;
        width: 30%;
    }
</style>