<template>
  <div class="homeMain">
    <b-carousel
            id="carousel-1"
            v-model="slide"
            :interval="4000"
            controls
            indicators
            img-width="1024px"
            img-height="480px"
            style="text-shadow: 1px 1px 2px #333;"
            @sliding-start="onSlideStart"
            @sliding-end="onSlideEnd"
    >

      <b-carousel-slide caption="고라파덕" img-src="https://image.fmkorea.com/files/attach/new/20180928/486616/562458984/1292832035/16954a32052d2fcef4368736f8b522e7.jpg"/>
      <b-carousel-slide caption="이상해꽃" img-src="https://image.fmkorea.com/files/attach/new/20180928/486616/562458984/1292870465/99b983892094b5c6d2fc3736e15da7d1_1.png"/>
      <b-carousel-slide caption="피카츄"  img-src="https://image.fmkorea.com/files/attach/new/20180928/486616/562458984/1292870465/f03af8a80dbb666e73e9744ed4fea64f.png"/>
      <b-carousel-slide caption="고스트" img-src="https://image.fmkorea.com/files/attach/new/20180928/486616/562458984/1292832035/a5d4ca67bf30a1033b6e4d2dde9cebc8.jpg"/>
      <b-carousel-slide caption="파이리" img-src="https://image.fmkorea.com/files/attach/new/20180928/486616/562458984/1292832035/7db935e2b1b244b190d06b7323998955.jpg"/>
      <b-carousel-slide caption="야도란" img-src="https://image.fmkorea.com/files/attach/new/20180928/486616/562458984/1292832035/3f3435a302e4c35a623f60d454c7b5b8.jpg"/>

    </b-carousel>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        slide: 0,
        sliding: null
      }
    },
    methods: {
      onSlideStart() {
        this.sliding = true
      },
      onSlideEnd() {
        this.sliding = false
      }
    }
  }
</script>
<style>
  .homeMain{
    width: 80%;
    margin: 0 auto;
  }
</style>
