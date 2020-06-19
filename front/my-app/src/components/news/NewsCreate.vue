<template>
<!-- 해결해야할 것 ( 임시저장, 컴플릿 ) -->
    <v-container>
        <div cols="3"
                    id="scroll-target"
                    style="max-height: 80vh"
                    class="fdfdfd overflow-y-auto"
        >
             <div style="height:100px" >
                <v-row justify="center">
                    <v-col cols="1"></v-col>
                    <v-col cols="8" align="center">
                           <br>
                            <v-text-field
                            v-model="Title"
                            label="기사 제목을 입력해주세요."
                            ></v-text-field>
                    </v-col>
                         <v-col cols="1"></v-col>
                </v-row>
                   
            </div>    
            <br>
                    
        <vue-editor
            id="editor"
            useCustomImageHandler
            @image-added="handleImageAdded"
            v-model="content"
            v-scroll:#scroll-target
            ></vue-editor>
        <br>
        </div>
        <!--완성된 기사 미리 보기로 설정하기. // 뉴스 타이틀을 가지고 왔어... 그리고? 어떻게 보내줘야하지? -->
        <v-footer absolute="absolute" class="font-weight-medium">
            <v-row>
                 <v-col class="text-left" cols="2"></v-col>
                <v-col class="text-left" cols="4">
                    <v-btn text="text" @click.stop="dialog.preview = true">
                        <v-icon>mdi-history</v-icon>
                        <strong>미리보기</strong>
                    </v-btn>
                    &nbsp;
                    <v-btn @click="goTempStore(1)" text="text">
                        <v-icon>mdi-message-text</v-icon>
                        <strong>임시 저장</strong>
                    </v-btn>
                </v-col>
                <v-col class="text-right" cols="4">
                    <v-btn
                        class="mr-4"
                        rounded="rounded"
                        color="black"
                        dark="dark"
                        @click.stop="dialog.complete = true"
                        @click= goTempStore(2)
                        >Complete</v-btn>
                </v-col>
                 <v-col class="text-left" cols="2"></v-col>
            </v-row>
        </v-footer>
        <v-dialog v-model="dialog.preview" max-width="1000">
            <v-card>
                <v-row>
                    <v-spacer></v-spacer>
                    <v-btn icon="icon" dark="dark" @click="previewBack()" class="mr-6">
                        <v-icon color="black darken-2">mdi-close</v-icon>
                    </v-btn>
                </v-row>
                <div class="output ql-snow">
                    <div class="ql-editor" v-html="content"></div>
                </div>
            </v-card>
        </v-dialog>
        <v-dialog v-model="dialog.complete" max-width="700">
                   <v-card >
                       <v-container v-if ="ResponseChk==false" >
                            <v-img src="https://cdn.dribbble.com/users/1319489/screenshots/3773110/earth-gif-loop.gif"></v-img>   
                            <v-divider></v-divider>
                            <v-row>
                                <v-col class ="text-center">
                                    <v-btn
                                    class="mr-4"
                                    rounded="rounded"
                                    color="black"
                                    dark="dark"
                                    @click="completeBack()"
                                    >Cancel</v-btn>
                            </v-col>
                            </v-row>
                       </v-container>
                       <v-container v-else>
                           <v-row v-if="picture==='NO'">
                               <v-card-title>대표이미지를 넣어주세요!</v-card-title>
                                <v-col cols="12" sm="12" md="12">
                                <v-file-input
                                    v-model="image"
                                    accept="image/png, image/jpeg, image/bmp"
                                    placeholder="Pick an avatar"
                                    prepend-icon="mdi-camera"
                                    value ="image"
                                ></v-file-input>
                            </v-col>
                           </v-row>
                       <v-row >
                           <v-card-title>카테고리를 선택해주세요.</v-card-title>
                            <v-spacer></v-spacer>
                            <v-btn icon="icon" dark="dark" @click="completeBack()" class="mr-2">
                                <v-icon color="black darken-2">mdi-close</v-icon>
                            </v-btn>
                        </v-row>
                            <v-divider></v-divider>
                      <v-row >
                      <v-col cols="4">
                      <div class="text-center" @click="checkBox(0)" >
                      <v-avatar size="100px"><div class="font_color font-weight-bold" v-if="checkNum===0">OK</div><v-img v-else src="https://image.flaticon.com/icons/svg/3028/3028819.svg"></v-img></v-avatar>
                            <div class="mt-2 white--text  text--lighten-1 font-weight-bold "
                              style="font-size:20px;"> 경제
                            </div>
                            경제
                      </div>
                      </v-col>
                      <v-col cols="4">
                          <div class="text-center" @click="checkBox(1)">
                          <v-avatar size="100px" ><div class="font_color font-weight-bold" v-if="checkNum===1">OK</div><v-img v-else src="https://image.flaticon.com/icons/svg/3022/3022568.svg"></v-img></v-avatar>
                            <div
                              class="mt-2  white--text  text--lighten-1 font-weight-bold "
                              style="font-size:20px;">  스포츠
                            </div>
                            스프츠
                          </div>
                      </v-col>
                      <v-col cols="4">
                          <div class="text-center" @click="checkBox(2)">
                          <v-avatar size="100px" ><div class="font_color font-weight-bold" v-if="checkNum===2">OK</div><v-img v-else src="https://image.flaticon.com/icons/svg/927/927313.svg"></v-img></v-avatar>
                            <div 
                              class=" mt-2 white--text  text--lighten-1 font-weight-bold "
                              style="font-size:20px;">  사회
                            </div>
                            사회
                          </div>
                      </v-col>
                      <v-col cols="4">
                          <div class="text-center" @click="checkBox(3)">
                          <v-avatar size="100px" ><div class="font_color font-weight-bold" v-if="checkNum===3">OK</div><v-img v-else src="https://image.flaticon.com/icons/svg/2910/2910311.svg"></v-img></v-avatar>
                            <div 
                              class=" mt-2 white--text  text--lighten-1 font-weight-bold "
                              style="font-size:20px;"> 증시
                            </div>
                            증시
                          </div>
                      </v-col>
                      <v-col cols="4">
                          <div class="text-center" @click="checkBox(4)">
                          <v-avatar size="100px" ><div class="font_color font-weight-bold" v-if="checkNum===4">OK</div><v-img v-else src="https://image.flaticon.com/icons/svg/1969/1969986.svg"></v-img></v-avatar>
                            <div 
                              class=" mt-2 white--text  text--lighten-1 font-weight-bold "
                              style="font-size:20px;"> I T
                            </div>
                            IT
                          </div>
                      </v-col>
                      <v-col cols="4">
                          <div class="text-center" @click="checkBox(5)">
                          <v-avatar size="100px" ><div class="font_color font-weight-bold" v-if="checkNum===5">OK</div><v-img v-else src="https://image.flaticon.com/icons/svg/2913/2913359.svg"></v-img></v-avatar>
                            <div 
                              class=" mt-2 white--text  text--lighten-1 font-weight-bold "
                              style="font-size:20px;"> 연예
                            </div>
                            연예
                          </div>
                      </v-col>
                    </v-row>
                    <v-divider></v-divider>
                        <v-card-title v-if="SimilarData.length==0" >유사기사가 없습니다.</v-card-title>
                        <v-card-title v-else>유사기사가 {{SimilarData.length}}개 있습니다.</v-card-title>
                    <v-divider></v-divider>
                        <v-row >
                            <v-col class ="text-center">
                                  <v-carousel style="height:325px" hide-delimiters show-arrows-on-hover> 
                                    <v-carousel-item  v-for="k in SimilarData.length" :key="k"> 
                                        <v-card v-for="(list,index) in SimilarData" :key="index" @click="goSubjected(list.subject.subjectId)">
                                            <NewsSimilarCard v-bind:title="list.posts[0].title" v-bind:img="list.posts[0].banner" v-bind:content="list.posts[0].content"></NewsSimilarCard>
                                            <span v-if="subJectedIDChk">유사기사로 선택되었습니다.</span>
                                            <span v-else>유사기사를 선택해주세요.</span>
                                        </v-card>
                                    </v-carousel-item>
                                  </v-carousel>
                            </v-col>                        
                        </v-row>
                        <v-divider></v-divider>
                        <v-row>
                            <v-col class ="text-center">
                                <v-btn
                                class="mr-4"
                                rounded="rounded"
                                color="black"
                                dark="dark"
                                @click="GoComplete()"
                                >Complete</v-btn>
                                <v-btn
                                class="mr-4"
                                rounded="rounded"
                                color="black"
                                dark="dark"
                                @click="completeBack()"
                                >Cancel</v-btn>
                            </v-col>
                        </v-row>
                    </v-container>
             </v-card>
        </v-dialog>
    </v-container>
</template>
<script>
    import NewsSimilarCard from './TypeNewsCard/NewsDetail/NewsSimilarCard.vue'
    import dedent from 'dedent'
    import {VueEditor} from "vue2-editor";
    import axios from "axios"; 
    import { API_BASE_URL } from "../../config";
    export default {
        name: "newscreate",
        components: {
            VueEditor,
            NewsSimilarCard
        },
        data() {
            return {
                dialog: {
                    preview: false,
                    complete: false
                },
                subJectedIDChk:false,
                subJectedID: "", //selected 10개 string  
                ResponseChk:false,
                similar:false,
                SimilarData:{},
                PostID :-1,
                checkNum: -1, // selecedId 
                selected: {},
                picture: "NO",
                Title: " ",
                Email: " ",
                image:" ",
                // <strong class="ql-font-serif ql-size-large" style="color: rgb(230, 0,
                // 0);">always</strong> <p><span class="ql-font-serif" style="color: gray" >*아래에
                // 기사 내용을 작성해주세요.</span></p><p><br></p>
                content: dedent `
                <p><br></p><p><strong class="ql-size-large" style="background-color: gray; color: rgb(255, 255, 255)">News SubTitle 입력</strong></p><p><br></p>
                <p><strong class=" ql-size-middle">CONTENTS 작성란입니다. </strong><u style="color:gray"> (*영상 및 사진 첨부 가능)</u> </p>
                <p class="ql-font-serif" style="color: rgb(230, 0, 0);"></p>
                <p><br></p><p><br></p><p><br></p><p><br></p>
                <p><br></p>
                <p><span class="ql-font-serif" style="color: gray" >*소 속 : </span></p>
                <p><span class="ql-font-serif" style="color: gray">*이메일 : </span></p>
                <p><span class="ql-font-serif" style="color: gray">*기자 이름 : </span></p>
                <strong class="ql-font-serif ql-size-middle" >[ⓒ 더뉴스라이브 & mk.co.kr, 무단전재 및 재배포 할 수 없으며 블록체인 시스템에 의해 모두 기록됩니다.]</strong>
                `
            }
        },
        watch: {
            content: function () {
                this.content = this
                    .content
                    .replace("img src", "img style='height:250px;' src")
            }
        },
        methods: {
            checkBox(num){
            this.checkNum = num;
            },
            goSubjected(num1){
                this.subJectedIDChk= !this.subJectedIDChk; 
                this.subJectedID = num1; 
            },
            goTempStore(num) {
                // PostID가 -1이라는 것은 처음 들어온 것. 
                // num ==1 이면 임시저장, num==2이면 complete
                if(num ==1 || this.PostID == -1) //임시저장이거나, 처음 들어온거라면.  
                {
                    this.Email = this.$store.state.UserInfo.kakao_account.email
                     
                    // console.log("이메일", this.Email );
                    // console.log("제목", this.Title );
                    axios
                    .post(API_BASE_URL + "/api/v1/posts", {
                            author: this.Email,
                            content : this.content,
                            title : this.Title,
                            banner: this.picture
                    })
                    .then(response => {
                    //    console.log(response)
                       this.PostID = response.data; 
                    //    console.log("PostId",this.PostID)
                        if(num == 2) // 2번째꺼라면, 
                        {
                            this.goSimilar();
                        } 
                   })
                    .catch(() => {
                    })
                }
            },
            previewBack() {
                this.dialog.preview = false;
            },
            completeBack()
            {
                this.dialog.complete = false;    
            },
            goSimilar(){
                 axios
                    .get(API_BASE_URL + "/api/v1/posts/suggestion/" + this.PostID)
                    .then(response => {
                        this.ResponseChk = true,
                        this.SimilarData = response.data.subjectItems;
                    })
                    .catch(() => {
                    })    
            },
            GoComplete()
            {
                var jj = this.subJectedID
                console.log(this.subJectedID)
                if(!this.subJectedID)
                {
                    jj = -1;
                }
                axios
                    .put(API_BASE_URL + "/api/v1/posts/" + this.PostID,{
                        subjectId: jj,
                        kinds: this.checkNum,
                        banner: this.picture

                    })
                    .then(response => {
                       alert("기사 작성이 완료되었습니다.")
                    //    console.log("기사작성완료",response);
                       this.$router.push({path:'/'})
                    })
                    .catch(() => {
                    })    
            },
        handleImageAdded: function (file, Editor, cursorLocation) {
            var formData = new FormData();
            formData.append("imagedata", file);
            formData.append('access_token', "734557e45c02228f6199d46e3050799a79f54874ae16cb5b3e38a0c67389f376" );
            axios({
                url: 'https://upload.gyazo.com/api/upload',
                method: 'POST',
                headers: {
                    Accept: 'application/json'
                },
                data: formData
            }).then((result) => {
                    let url = result.data.url;
                    Editor.insertEmbed(cursorLocation, 'image', url);
                    if(this.picture== "NO")
                    {
                        this.picture = url;
                    }
                })
                .catch((err) => {
                    console.log(err);
                })
            },
            BannerImageAdded() {
            var formData = new FormData();
            formData.append("imagedata", this.image);
            formData.append('access_token', "734557e45c02228f6199d46e3050799a79f54874ae16cb5b3e38a0c67389f376" );
            axios({
                url: 'https://upload.gyazo.com/api/upload',
                method: 'POST',
                headers: {
                    Accept: 'application/json'
                },
                data: formData
            })
            .then((result) => {
                let url = result.data.url;
                this.picture = url;
            })
            .catch((err) => {
                console.log(err);
            })
            }
    },
    watch:{
        image:function(val){
            console.log("2131");
            this.BannerImageAdded();
        }
    }
}
</script>
<style>
    #editor {
        height: 680px;
    }
    .ql-snow .ql-editor img {
        height: 250px;
    }
    .fff {
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .fdfdfd{
        overflow-y: scroll;
    }
    .fdfdfd::-webkit-scrollbar {
        display: none;
    }
    .font_color{
    background: linear-gradient(to right, #fbcac9, #8ca6ce);
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    font-size: 35px;
    }
</style>