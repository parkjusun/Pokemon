import axios from "axios";

const  state = {
    context:`http://localhost:5000/`,
    pokemon:[],
    count:0
}
const actions = {
    async login({commit},payload){
        axios.post(state.context+`user/singup`,payload,{
            authorization: "JWT fefege..",
            Accept: "application/json",
            "Content-Type": "application/json"
        })
            .then(({data})=>{
                commit('LOGIN',data)
                alert((data)? "아이디 중복": "회원가입성공")
            })
            .catch(()=>{
                alert('통신 실패')
            })
    },
    async idcheck({commit},userid){
        axios.get(state.context+`user/${userid}`)
            .then(({data})=>{
                commit('LOGIN',data)
                alert((data)? "아이디 중복" : "사용가능한 아이디" )
            })
            .catch(()=>{

                alert('통신 실패')

            })
    }

}
const  mutations ={
    LOGIN(){

    },
    idcheck(){

    }
}


const getters ={

}

export default{
    name:'singup',
    namespaced:true,
    state,
    actions,
    getters,
    mutations

}