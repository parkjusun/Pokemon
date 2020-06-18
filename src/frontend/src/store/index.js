import Vue from 'vue'
import Vuex from 'vuex'
import pokemonList from './pokemonList'
import mapList from './mapList'
import singup from './singup'
import singin from './singin'


Vue.use(Vuex)
export const store = new Vuex.Store({
       modules:{
       pokemonList,mapList,singup,singin
       }
})