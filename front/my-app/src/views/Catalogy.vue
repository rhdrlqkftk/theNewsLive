
<template>
	<div>
        <br>
            <v-container>
                <v-row>
                    <v-col cols="12"
                     v-for="(list,index) in allNews"
                    :key="index"
                    >
                <v-card
                 
                    min-height="20vh"
                    width="100%"
                    align-center="align-center"
                    hover
                    v-if="(page-1)*5<=index && index<(page-1)*5 +5"
                    @click="goDetail(index)"
                    >
                    
                    <div>
                        <v-row>
                            <v-col cols="8"
                            style="text-align:start;padding-left:35px">
                            <span
                                class="font-weight-bold "
                                style="color:#000046 ;font-size:25px;">{{list.title}}
                            </span>
                            <div 
                            style="margin-top:1vw; width:95%;">
                                <v-chip
                                class="ma-2"
                                text-color="black"
                                color="indigo"
                                outlined
                                v-for="(topic,index2) in splitWord(list.topics)"
                                :key= "index2">
                                    {{topic}}
                                </v-chip>
                            </div>
                           
                            </v-col>
                            <v-col cols="4">
                                <v-img
                                    class="white--text align-end"
                                    height="90%"
                                    width="100%"
                                    v-bind:src="list.banner==='NO'?require('../assets/newsBK2.png'):list.banner"
                                >
                                    <v-card-title>
                            
                                    </v-card-title>
                                </v-img>
                            </v-col>
                        </v-row>
                    </div>
                </v-card>
                </v-col>
            </v-row>
                 <div class="text-center">
                    <v-pagination
                    v-model="page"
                    :length="Math.floor(allNews.length/5)+1"
                    prev-icon="mdi-menu-left"
                    next-icon="mdi-menu-right"
                    ></v-pagination>
                </div>       
            </v-container>
	</div>
</template>
<script>
export default {
   props:["allNews"],
   components : {
  },
  created(){
      console.log(this.allNews)
      console.log(this.allNews.length/5)
  },
  methods:{
      splitWord(target){
          var selectedWords = [];
          var words = target.split(",");
          for (var a in words){
              if (words[a].length > 0){
                  selectedWords.push(words[a]);
              }
          }
          return selectedWords;
      },
      goDetail(index){
                 this.$router.push({name:'newsdetail',params: { id: this.allNews[index].postId }})
        }
  },

  data () {
      return {
        page: 1,
      }
    },
};
</script>

<style>
.test {background: #000046;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #1CB5E0, #000046);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #1CB5E0, #000046); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

}
</style>
