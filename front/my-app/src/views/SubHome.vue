<template>
    <div>
		<div class= "mt-5">
		   <v-row>
              <v-col cols="12" md="1"></v-col>
              <v-col cols="12" md="4">
                <div align="left" class="mt-7">
                <!-- <span  class="blue--text font-weight-bold " style="font-size:40px;">The News Live</span> -->
                <br><br>  
                  <div align="left" class="gray font-weight-bold mt-3" style="font-size:25px;">
                  <div class="h1 text-center" style="text-shadow: 2px 2px 2px gray;" ><strong>최근 기사</strong></div>
                  </div> 
                  <br> 
				  <v-divider></v-divider>
				  <v-divider></v-divider>
				  <v-divider></v-divider>
                  <v-divider class= "mb-5" style="background-color:black;"></v-divider>
                  <v-btn 
                    class="del mt-4"
					style="background-color:white; "
                    width="100%"
                    v-for="(item,idx) in posts"
                    v-bind:key="idx"
                    dark
                    large
					@click="selectImage(idx)"
                  > 
                  <div class="mb-2 mr-2 font-weight-bold " style="color:#021b79; width:100%; font-size:18px " >{{item.title}}</div> 
                </v-btn>
                </div>
              </v-col> 
			  <v-col cols="12" md="1"></v-col>
              <v-col cols="12" md="5" >
				<div  class = "mt-7"
				>
                <v-carousel  v-model="selected" hide-delimiters show-arrows-on-hover interval="4000" > 
                	<v-carousel-item v-for="k in len" :key="k" > 
                    	<v-row 
							
						>
                			<v-hover v-slot:default="{ hover }">
					<v-card
						v-if ="len!=0"
						light="light"
						align-center="align-center"
						:elevation="hover ? 16 : 2"
						class="mx-auto">
						
						<v-img
						style="box-shadow: 0px 0px 20px #000;"
						class="white--text align-end"
						height="500px"
						v-bind:src="posts[selected].banner ==='NO'  ?require('../assets/newsBK2.png'):posts[selected].banner"
						@click="goDetail(posts[selected].postId)"
						>
						<v-expand-transition>
						<div
							v-if="hover"
							class=" d-flex transition-fast-in-fast-out darken-2 v-card--reveal  text-center"
							style=" height: 100%; text-shadow: -1px 0 #424242, 0 1px #424242, 1px 0 #424242, 0 -1px #424242;"
						>
						<p style="font-size:5vw;"><strong style="">
							   자세히 보기
						</strong></p>
						
						</div>
						</v-expand-transition>
						<v-card-text>
						
						</v-card-text>
						
						</v-img>
					</v-card>
              </v-hover>
                    </v-row>
                </v-carousel-item>
                </v-carousel>
				</div>
              </v-col>
            </v-row>
    	</div>
	<br>
	<div class="back_g" style="height:570px;box-shadow: 0px 0px 20px #000;">
		<v-row >
      <v-col cols="6" >
        <v-img style="top:15%; height:23vw; width:49vw" src="../assets/newsRegi.gif"></v-img>
      </v-col>
      <v-col cols="6">
                <!-- <v-card -->
                  <!-- class="mx-auto" -->
                  <!-- style="top:5%" -->
                  <!-- max-width="80%" -->
				  <!-- height="25vw" -->
                <!-- > -->
                  <!-- <v-card-text > -->
					<div style="margin-top:6vw color:white; text-align: left; margin-top:7vw;padding-left:13vw;">
					<p style="font-size:3vw; color:white; text-shadow: 2px 2px 2px gray;">
						신뢰할 수 있는 기사
					</p>
                    <p style="font-size:3vw; color:white; text-shadow: 2px 2px 2px gray;">
                      블록체인 News 기록
                    </p>
                    <div  style="font-size:15px;  color:white; ">
                      News Live에 작성되는 모든 기사들은 <strong>Hyperledger 블록체인 네트워크</strong>에 기록됩니다.<br>
                      또한, 수정, 삭제 등의 조작 <strong>모두 기록</strong>됩니다.<br>
                      따라서 기자는 기사 작성에 있어 신중해야 하며, 이를 통해 구독자로 부터 평가를 받게 됩니다.<br>
                      이를 통해 사용자는 <strong>신뢰할 수 있는 기사</strong>를 제공받을 수 있습니다.
                    </div>
					  </div>
                  <!-- </v-card-text> -->
                <!-- </v-card> -->
      </v-col>
		</v-row>
	</div>
	<div style="background: (58, 76, 168); height:570px">
		<v-row >
			<v-col cols="6" >
				<div style="margin-top:6vw color:white; text-align: left; margin-top:7vw;padding-left:13vw;">
                    <p style="font-size:3vw; color:black; text-shadow: 2px 2px 2px gray;">
                      블록체인을 통한 광고 수익 분배
                    </p>
					<p style="font-size:3vw; color:black; text-shadow: 2px 2px 2px gray;">
                      공정한 수익의 분배
                    </p>
                    <div  style="font-size:15px;  color:black; ">
                      기자들은 기사가 블록체인에 저장되어 제약을 받게 됩니다. 하지만 <strong>광고 수익을 분배</strong> 받습니다.<br>
                      구독자들이 기사를 클릭할 때마다 <strong>기사의 조회수가 블록체인에 기록</strong>됩니다.<br>
                      이렇게 쌓인 기사의 조회수를 통해 <strong>광고료를 비율에 따라 지급</strong>받습니다.<br>
                      <br>
                      <strong>*1개의 계정은 1개의 기사에 1번의 조회수를 늘릴 수 있도록 제한했습니다.</strong>
                    </div>
				</div>
     			</v-col>
			<v-col cols="5">
				<v-img style="top:15%; height:23vw; width:49vw" src="../assets/adDivide.gif"></v-img>
			</v-col>
			<v-col cols="1">
			</v-col>
		</v-row>
	</div>
</div>
</template>
    <script >
	  import axios from "axios";
		export default {
			data() {
				return {
					selected : 0,
					search: null,
					posts: [],
					len:0
				};
			}, 
			mounted(){
     		 	this.getRecent();
    		},
			methods: {
				goSearch(content) {
					console.log(content)
				},
				selectImage(idx)
				{
					this.selected = idx
				},
				goDetail(idx){
					// console.log(idx)
				 this.$router.push({name:'newsdetail',params: { id: idx }})
            	}
				,
				getRecent(){
					axios
					.get('http://k02b2041.p.ssafy.io:8080/api/v1/posts/desc')
					.then(response=>{
						// console.log("getRecent()",response.data);
						this.posts = response.data;
						console.log("posts 확인",this.posts.length)
						this.len = this.posts.length;
					})
					.catch(e=>{
						console.error(e);
					})
				},
				findByTitle(target){
					console.log(target);
					axios
					.get("http://k02b2041.p.ssafy.io/api/v1/posts/find/" + target)
					.then(response => {
						this.posts = response.data;
						this.$forceUpdate();
					})
				},
				breakpointObject() {
					// Use in computed property
					switch (this.vuetify.breakpoint.name) {
						case 'xs': return '220px'
						case 'sm': return '400px'
						case 'md': return '500px'
						case 'lg': return '600px'
						case 'xl': return '800px'
					}
				}
			}
		}
    </script>
    <style>
	.back_g{background: #000046;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #1CB5E0, #000046);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #1CB5E0, #000046); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

	}
	.test {
		background: #000046;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #1CB5E0, #000046);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #1CB5E0, #000046); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

	}
	.bk{background: #000046;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #1CB5E0, #000046);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #1CB5E0, #000046); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

		height: 90vh;
		width: 100%;
		padding:5vw;
	}	
	.del{
		width:100%;
        padding:10px 10px;
		text-overflow: ellipsis;
		white-space: nowrap;
 	 	overflow: hidden;
	}
	.v-card--reveal {
  align-items: center;
  bottom: 0;
  justify-content: center;
  opacity: .7;
  position: absolute;
  width: 100%;
}

	</style>