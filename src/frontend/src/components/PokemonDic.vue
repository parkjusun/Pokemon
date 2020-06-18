<template>
    <div class="poke_main">
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
                 :fields="fields"
                 :filterIncludedFields="filterOn"

                 :total-rows="totalRows"
                 @filtered="onFiltered"

                 @row-clicked="showModal"
                 small>

            <template v-slot:cell(image)="data">
                <img id="pokemonimg" :src=data.value />
            </template>

        </b-table>


        <b-pagination
                id="pages"
                v-model="currentPage"
                :total-rows="totalRows"
                :per-page="perPage"
                align="center"
                aria-controls="my-table"
        >
        </b-pagination>
    </div>



</template>

<script>
    import { mapState } from "vuex";

    export default {
        name: "PokemonDic",
        data() {
            return {
                fields: [
                    { key: 'image', label: 'image'},
                    { key: 'name', label: 'name', sortable: true, sortDirection: 'desc'},
                    { key: 'stamina', label: 'stamina',sortable: true, sortDirection: 'desc'},
                    { key: 'atk', label: 'atk',sortable: true, sortDirection: 'desc'},
                    { key: 'def', label: 'def',sortable: true, sortDirection: 'desc'},
                    { key: 'type1', label: 'type1'},
                    { key: 'type2', label: 'type2'},
                    { key: 'cp', label: 'cp',sortable: true, sortDirection: 'desc'}

                ],
                perPage: 10,
                currentPage: 1,
                totalRows: 1,
                filter: null,
                filterOn: [],
                check: true
            }
        },
        mounted() {
            this.$store.dispatch("pokemonList/search")
        },
        updated() {
            if(this.check)
            this.totalRows = this.items.length
            this.check = false
        },
        computed: {
            ...mapState({
                items: state => state.pokemonList.pokemon,
            }),
            rows() {
                return this.items.length
            }
        },
        methods:{
            showModal(i){
                const h = this.$createElement
                const titleVNode = h('div', { domProps: { innerHTML: i.name} })
                const messageVNode = h('div', { class: ['foobar'] }, [
                    h('b-img', {
                        props: {
                            src: i.image,
                            thumbnail: true,
                            center: true,
                            fluid: true, rounded: 'circle'
                        }
                    }), h('p', { class: ['text-center'] }, [h('strong', 'STAMINA : '+ i.stamina) ]),
                    h('p', { class: ['text-center'] }, [h('strong', 'ATK : '+ i.atk) ]),
                    h('p', { class: ['text-center'] }, [h('strong', 'DEF : '+ i.def) ]),
                    h('p', { class: ['text-center'] }, [h('strong', 'TYPE : '+ i.type1+" "+i.type2) ]),
                    h('p', { class: ['text-center'] }, [h('strong', 'CP : '+ i.cp) ]),

                ])
                this.$bvModal.msgBoxOk([messageVNode], {
                    title: [titleVNode],
                    buttonSize: 'sm',
                    centered: true, size: 'sm'
                })
            },
            onFiltered(filteredItems) {
                this.totalRows = filteredItems.length
                this.currentPage = 1


            }
        },

    }
</script>

<style>
    .poke_main{
        margin: 0 auto;
        padding-top: 20px;
        text-align: center;
        width: 80%;
    }

    .table_1 thead{
        background-color: cornsilk;
    }
    .font-weight-black tr th{
        font-size: 13px;
    }
    #pokemonimg {
        width: 150px;

    }

</style>