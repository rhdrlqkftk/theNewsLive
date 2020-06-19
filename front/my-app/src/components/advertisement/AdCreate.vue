<template>
<div class="bk text-center">
      <v-card
    class="mx-auto"
    max-width="100vw"
    
  >
    <v-card-text>
      <h1 class=" text--primary text-center">
        광고 등록 페이지
      </h1>
      <div class="text--primary">
          <v-form>
    <v-container>
      <v-row>

        <v-col cols="6" sm="6" md="6">
          <v-text-field
            label="price"
            v-model="price"
            filled
            rounded
            prefix="₩"
            dense
          ></v-text-field>
        </v-col>
        <v-col cols="6" sm="6" md="6">
          <v-text-field
            label="months"
            filled
            v-model="months"
            prefix="M"
            rounded
            dense
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="12" md="12">
          <v-text-field
            label="content"
            v-model="content"
            filled
            rounded
            dense
          ></v-text-field>
        </v-col>
        <v-col cols="12" sm="12" md="12">
            <v-file-input
                v-model="image"
                accept="image/png, image/jpeg, image/bmp"
                placeholder="Pick an avatar"
                prepend-icon="mdi-camera"
                label="Avatar"
            ></v-file-input>
        </v-col>


      </v-row>
    </v-container>
  </v-form>
      </div>
    </v-card-text>
    <v-card-actions>
    <v-btn class="btn-center" rounded color="primary" dark @click="registerButtonClick()">등록</v-btn>
    </v-card-actions>
  </v-card>
             
  </div>
</template>

<script>
import axios from "axios";
export default {
    data(){
        return {
            image:null,
            price: 0,
            months: 0,
            content: "",
            dialog: false,
            posts: [],
        }
    },
    methods:{
        registerButtonClick(){
            const email = this.$store.state.UserInfo.kakao_account.email;
            // console.log(email);
                    var formData = new FormData();
                    formData.append("price", this.price);
                    formData.append("months", this.months);
                    formData.append("content", this.content);
                    formData.append("image", this.image);
                    formData.append("userEmail", email);
                    axios
                    .post('http://k02b2041.p.ssafy.io:8080/api/v1/advertisement',formData,
                        // {
                            // headers:{
                                // 'content-type': "multipart/form-data"
                            // }
                        // }
                        )
                    .then(response=>{
                      alert('공고 등록 성공했습니다!');
                      console.log(response.data);
                    });
        },
    },
    
}
</script>

<style scoped>
.bk{background: #000046;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #1CB5E0, #000046);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #1CB5E0, #000046); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */


    height: 90vh;
    width: 100%;
    padding:5vw;
}
.text-center{
    text-align: center;
}
.btn-center {
  margin-top: 3px;
  left: 50%;
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%);
}

</style>