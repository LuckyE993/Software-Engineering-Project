<script setup>
import {ElForm, ElFormItem, ElInput, ElOption, ElSelect} from "element-plus";
import {reactive} from "vue";
import {ElButton} from "element-plus";

const form=reactive({
  username:"",
  phonenum:"",
  password:"",
  confirmpass:"",
  email:""
})

</script>

<template>
  <div style="display: flex;justify-content: center"><p style="font-size: 30px">修改用户信息</p></div>
  <div  style="display: flex;flex-direction: column;margin-left:32%;margin-top:50px;height: 100%" >
      <el-form :model="form" label-width="auto"  style="width: 400px;">
        <el-form-item label=用户名:>
          <el-input style="height:50px;" v-model="form.username" />
        </el-form-item>
        <el-form-item label=手机号:>
          <el-input style="height:50px;"v-model="form.phonenum" />
        </el-form-item>
        <el-form-item label=密码:>
          <el-input style="height:50px;"v-model="form.password" />
        </el-form-item>
        <el-form-item label=确定密码:>
          <el-input style="height:50px;"v-model="form.confirmpass" />
        </el-form-item>
        <el-form-item label=邮箱:>
          <el-input style="height:50px;"v-model="form.email" />
        </el-form-item>
        <el-button style="height: 35px;width: 100px;margin-left: 180px" type="primary">提交信息</el-button>
      </el-form>
  </div>
  <main><router-view></router-view></main>
</template>

<style scoped>

</style>