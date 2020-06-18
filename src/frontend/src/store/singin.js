import axios from "axios";
import router from '../router'
const  state = {
    context:`http://localhost:5000/`,
    resultString:""
}
const actions = {
    async login({commit},payload){
        axios.post(state.context+`user/singin`,payload,{
            authorization: "JWT fefege..",
            Accept: "application/json",
            "Content-Type": "application/json"
        })
            .then(({data})=>{
                commit('LOGIN',data)
                if(data === "로그인 성공"){
                    alert("로그인 성공")
                    router.push('/')
                }else{
                    alert(data)
                }
            })
            .catch(()=>{
                alert('통신 실패')
            })
    }

}
const  mutations ={
    LOGIN(){

    }
}


const getters ={
    resultString: state => state.resultString,
}

export default{
    name:'singup',
    namespaced:true,
    state,
    actions,
    getters,
    mutations

}