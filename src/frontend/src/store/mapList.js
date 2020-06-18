import axios from "axios";

const  state = {
    context:`http://localhost:5000/`,
    road:[],
    count:0
}
const actions = {
    async search({commit}){
        axios.get(state.context+`road/list`)
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
        state.road = []
        state.count = data.count;
        data.forEach(item => {state.road.push({
            streetName: item.streetName,
            streetIntroduction: item.streetIntroduction,
            gunLength: item.gunLength,
            demandTime: item.demandTime,
            startingPointName: item.startingPointName,
            startingPointAddress: item.startingPointAddress,
            startingPointNumberAddress: item.startingPointNumberAddress,
            endPointName: item.endPointName,
            endPointNameAddress: item.endPointNameAddress,
            endPointnumberAddress: item.endPointnumberAddress,
            phoneNumber: item.phoneNumber,
            managementAgencyName: item.managementAgencyName,
            baseDate: item.baseDate,
            location: [item.latitude,item.longitude],
            providerName: item.providerName,


        })})

    }
}


const getters ={
    road: state => state.road,
}

export default{
    name:'mapList',
    namespaced:true,
    state,
    actions,
    getters,
    mutations

}