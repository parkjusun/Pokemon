<template>
  <div id="app">
    <b-navbar toggleable type="dark" variant="dark">
      <b-navbar-brand @click="home" class="font-italic">PokeMon </b-navbar-brand>
      <b-navbar-toggle target="navbar-toggle-collapse">
        <template v-slot:default="{ expanded }">
          <b-icon v-if="expanded" icon="chevron-bar-up"></b-icon>
          <b-icon v-else icon="chevron-bar-down"></b-icon>
        </template>
      </b-navbar-toggle>

      <b-collapse id="navbar-toggle-collapse" is-nav>
        <b-navbar-nav class="ml-auto">
          <b-nav-item @click="signout" >로그인</b-nav-item>
          <b-nav-item @click="pokemondic">포켓몬 도감</b-nav-item>
          <b-nav-item @click="mapList">산책로</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>


    <div class="wrapper">
      <router-view />
    </div>
    <router-view name="footer" />
  </div>
</template>
<script>

  export default {
    name: 'App',

    data() {
      return {
        sliding: null
      }
    },
    methods: {
      home(){
        this.$router.push("/")
      },
      signout(){
        this.$router.push('/singin')
      },
      pokemondic(){
        this.$router.push('/pokemon')

      },
      mapList(){
        this.$router.push('/map')
      }
    }
  }
</script>
