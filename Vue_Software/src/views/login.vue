<script  setup>
import {computed, reactive, ref} from "vue";
import {ElButton, ElForm, ElFormItem, ElInput,}from "element-plus";
import { Iphone, Key,User } from '@element-plus/icons-vue';

const ruleForm = reactive({
  phonenum: '',
  password: ''
})

//对象可以有多个属性{}内，属性都有键和值key：value，数组属性可以有多个值 key:[{key:value},{key:value},{key:value}],每个值也相当于一个属性

const rules=reactive({
  phonenum:[
    { required: true,message:'手机号不能为空',trigger:'blur'}
  ],
  password:[
    {required:true,message:'密码不能为空',trigger:'blur'}
  ]
})

</script>

<template>
  <div style="height: 100%;width: 100%;background: #7fffca;position: fixed" class="flex-center-center">
    <div class=" bg-color-white flex-c-center-center " style="width: 600px;height: 500px;box-shadow: 20px 10px 5px #879687;border-radius: 10px ">
      <div style="height: 150px">
        <h1>
          <el-icon><User/>登 录</el-icon>
        </h1>
      </div>
      <div style="height: 150px;width: 300px;" >
        <!--v-moedl和：model不是一个东西-->
        <el-form :model="ruleForm" :rules="rules"  ref="loginForm" label-width="auto" style="max-width: 500px" >
          <el-form-item prop="phonenum">
            <el-input v-model="ruleForm.phonenum" placeholder="+86输入您的手机号" :prefix-icon="Iphone"/>
          </el-form-item>
          <el-form-item prop="password">
            <el-input v-model="ruleForm.password" placeholder="输入您的密码" type="password" show-password :prefix-icon="Key"/>
          </el-form-item>
        </el-form>
        <div style="height: 40px;">
          <router-link  to="/user" >
            <el-button type="primary"  plain round style="width:300px;height:30px">登录</el-button>
          </router-link>
        </div>
      </div>
      <nav>
        <router-link  to="/register" >
          <el-button type="success" size="small" link style="width:30px;height:30px;margin-left: 250px;">注册新用户</el-button>
        </router-link>
      </nav>
    </div>
  </div>
  <main><router-view></router-view></main>
</template>

<style scoped>
</style>