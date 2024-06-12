<script setup>

import {Iphone, Message, User} from "@element-plus/icons-vue";
import {ElCheckbox,ElLink,ElButton, ElForm, ElFormItem, ElInput} from "element-plus";
import {reactive, ref} from "vue";

const form=reactive({
  phonenum:"",
  message:""
})
const rules=reactive({
  phonenum:[
    {required:true,message:"手机号不能为空",trigger:'blur'}
  ],
  message:[
    {required:true,message:"验证码不能为空",trigger:'blur'}
  ]
})

let isSend= true;
let sendmsg=ref("发送短信");

const send=()=>{
  if (!this.form.phonenum) {
    this.$message.error("请填写手机号后获取验证码！");
  } else {
            this.isSend = false;
            let timer = 60;
            this.sendmsg = timer + "s";
            this.timeFun = setInterval(() => {
              --timer;
              this.sendmsg = timer + "s";
              if (timer === 0) {
                this.isSend = true;
                this.sendmsg = "重新发送";
                clearInterval(this.timeFun);
              }
            }, 1000);
          }
}
</script>

<template>
  <div style="height: 100%;width: 100%;display: flex;align-items: center;justify-content: center;background: #7fffca;position: fixed">
    <div class="flex-c-center-center" style="background: #ffffff;height: 500px;width: 600px;border-radius: 10px;box-shadow: 20px 10px 5px #879687;">
      <div style="height: 150px" >
        <h1>
          <el-icon><User/>注 册</el-icon>
        </h1>
      </div>
      <div class="flex-c-center-center" style="height: 180px;width: 330px;" >
        <el-form :model="form" :rules="rules" ref="registerform" style="max-width: 350px;" >
          <el-form-item label="手机号:" prop="phonenum">
            <el-input  v-model="form.phonenum" placeholder="输入您的手机号"  :prefix-icon="Iphone">
             <template #prepend>+86</template>
            </el-input>
          </el-form-item>
          <el-form-item label="验证码:" prop="message">
            <el-input v-model="form.message" placeholder="输入短信验证码" :prefix-icon="Message">
              <template #append>
                <el-button  style="width:90px;background: #00aaff;font-size:15px;color: white" @click="send(form)" v-if="isSend" >发送短信</el-button>
                <el-button  style="width:90px;background: #00aaff;font-size:15px;color: white" v-if="!isSend" >{{sendmsg}}</el-button>
              </template>
            </el-input>
          </el-form-item>
          <el-checkbox style="margin-left: 50px" name="type">您已阅读并同意《<el-link type="primary" >用户使用协议</el-link>》</el-checkbox>
          <el-form-item>
            <el-button type="primary"  round style="width:200px;height:40px;margin-left: 70px">注册</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
  <main><router-view></router-view></main>
</template>

<style scoped>

</style>