<template>
    <div class="mapMain">
        <h1>산책로</h1>
        <div class="mapClass">
            <div id="map"></div>
        </div>
        <br>

        <div>
            <b-input-group size="L">
                <b-form-input
                        v-model="filter"
                        type="search"
                        id="filterInput"
                        placeholder="Search"
                ></b-form-input>
            </b-input-group>

            <b-table striped hover
                     :items="items"
                     :current-page="currentPage"
                     :per-page="perPage"
                     :filter="filter"
                     :filterIncludedFields="filterOn"
                     @filtered="onFiltered"
                     @row-clicked="showMap"
                     :fields="fields"
                     small>
                <template v-slot:cell(detail)="data">
                    <b-icon icon="search" @click="detail(data.item)"/>
                </template>


            </b-table>


            <b-pagination
                    id="pages"
                    v-model="currentPage"
                    :total-rows="totalRows"
                    :per-page="perPage"
                    align="center"
            >

            </b-pagination>
        </div>

    </div>
</template>
<script>
    import {mapState} from "vuex";

    export default {
        data(){
            return{
                fields: [
                    { key: 'streetName', label: '산책로 이름'},
                    { key: 'demandTime', label: '걸리는 시간'},
                    { key: 'startingPointName', label: '시작지점'},
                    { key: 'endPointName', label: '도착지점'},
                    { key: 'phoneNumber', label: '전화번호'},
                    { key: 'managementAgencyName', label: '관리기관'},
                    { key: 'baseDate', label: '등록일자'},
                    { key: 'providerName', label: '제공기관명'},
                    { key: 'detail', label: '자세히보기'},

                ],
                x: 37.552388,
                y: 126.937694,
                totalRows: 0,
                currentPage: 1,
                perPage: 5,
                filter: null,
                filterOn: [],
                iwContent: '<div style="margin: 0 auto; padding: 5px; text-align: center;">비트캠프</div>',
                check: true
            }
        },
        mounted() {

            this.$store.dispatch("mapList/search");


            const script = document.createElement('script');
            /* global kakao */
            script.onload = () => kakao.maps.load(this.initMap);
            script.src = 'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=9056d8c1d590cb2f7569fc1b534f6715';
            document.head.appendChild(script);

        },
        updated() {
            if(this.check)
            this.totalRows = this.items.length
            this.check = false

        },
        computed: {
            ...mapState({
                items: state => state.mapList.road,
            }),
            rows() {

                return this.items.length
            },

        },

        methods: {
            initMap() {
                var container = document.getElementById('map');
                var options = {
                    center: new kakao.maps.LatLng(this.x, this.y),
                    level: 1
                };
                var map = new kakao.maps.Map(container, options);
                map.setMapTypeId(kakao.maps.MapTypeId.ROADMAP);

                var markerPosition  = new kakao.maps.LatLng(this.x, this.y);
                var mapTypeControl = new kakao.maps.MapTypeControl();
                map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);
                var zoomControl = new kakao.maps.ZoomControl();
                map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
                var marker = new kakao.maps.Marker({
                    position: markerPosition,
                });
                // 마커가 지도 위에 표시되도록 설정합니다
                marker.setMap(map);
                var infowindow = new kakao.maps.InfoWindow({
                    map: map, // 인포윈도우가 표시될 지도
                    position : markerPosition,
                    content : this.iwContent,
                });
                infowindow.open(map, marker);


            },
            showMap(i){
                this.x = i.location[0]
                this.y = i.location[1]
                this.iwContent = '<div @click="detail" style="margin: 0 auto; padding: 5px; text-align: center;">'+i.streetName+'</div>'
                this.initMap()


            },
            onFiltered(filteredItems) {

                this.totalRows = filteredItems.length
                this.currentPage = 1
            },
            detail(i){
                const h = this.$createElement
                const titleVNode = h('div', { domProps: { innerHTML: i.streetName} })
                const messageVNode = h('div', { class: ['foobar'] }, [
                    h('p', { class: ['text-center'] }, [h('strong', '소개')]),
                    h('p', { class: ['text-center'] }, [ i.streetIntroduction]),
                ])
                this.$bvModal.msgBoxOk([messageVNode], {
                    title: [titleVNode],
                    buttonSize: 'sm',
                    centered: true, size: 'sm'
                })
            }
        }
    }
</script>
<style>
    .mapMain{
        margin: 0 auto;
        text-align: center;
        padding-top: 10px;
        width: 80%;
    }


    #map{
        margin: 0 auto;
        text-align: center;
        width: 1280px;
        height: 650px;
    }

</style>
