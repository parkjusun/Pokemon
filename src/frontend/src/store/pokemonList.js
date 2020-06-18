import axios from "axios";

const  state = {
    context:`http://localhost:5000/`,
    pokemon:[],
    count:0
}
const actions = {
    async search({commit}){
        axios.get(state.context+`pokemon/list`)
            .then(({data})=>{

                commit('SEARCH',data)
            })
            .catch(()=>{

                alert('통신 실패')

            })
    }

}
const  mutations ={
    SEARCH(state,data){
        state.pokemon = []
        state.count = data.count;


        data.forEach(item => {state.pokemon.push({
            image: item.url,
            name: item.name,
            stamina: item.stamina,
            atk: item.atk,
            def: item.def,
            type1: item.prim,
            type2: item.secondary,
            cp: item.cp,

        })})

    }
}


const getters ={
    pokemon: state => state.pokemon,
}

export default{
    name:'pokemonList',
    namespaced:true,
    state,
    actions,
    getters,
    mutations

}