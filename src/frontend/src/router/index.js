import Vue from "vue";
import VueRouter from "vue-router";
import Home from "@/components/Home";
import PokemonDic from"../components/PokemonDic"
import Map from"../components/Map"
import Test from "../components/Test"
import SingIn from "../components/user/SingIn"
import SingUp from "../components/user/SingUp"
import Modify from "../components/user/Modify"

Vue.use(VueRouter);
export default new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes: [
        { path: "/", component: Home },
        { path: "/pokemon", component: PokemonDic },
        { path: "/map", component: Map },
        { path: "/test", component: Test },
        { path: "/singin", component: SingIn },
        { path: "/singup", component: SingUp },
        { path: "/modify", component: Modify },

    ]
});
