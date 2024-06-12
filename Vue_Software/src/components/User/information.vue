<script setup>

import {ElCard,ElIcon,ElLink,ElAvatar,ElButton} from "element-plus";
import { User} from "@element-plus/icons-vue";
import {reactive,ref} from "vue";
import {ElDialog} from "element-plus";
import {ElForm, ElFormItem} from "element-plus";
import {ElInput} from "element-plus";

const user_information=reactive({
  username: "SQX",
  phonenum: "1734735721",
  email:"17727877921@163.com",
  permission:"正常",
  password:"123544"
})

let changedialog=ref(false);


</script>

<template>
  <div style="display: flex;flex-direction: column;margin-left: -30px;height: 500px;justify-content: center">
    <div style="height: 80px;width: 1200px;margin-left: 40px;">
      <el-card style="font-size: large">
        <el-icon size="large"><User/></el-icon>
        个人信息
      </el-card>
    </div>
    <div style="width: 1200px;margin-left: 40px;">
      <el-card style="font-size: 30px" >
        <div style="display: flex ">
          <p style="margin-left: 30px"><el-avatar :size="230" style="font-size: 60px;margin-bottom: 15px">用户</el-avatar></p>
          <div style="margin-left: 120px">
            <p style="margin-bottom: 10px">用户名:{{user_information.username}}</p>
            <p style="margin-bottom: 10px">手机号:{{user_information.phonenum}}</p>
            <p style="margin-bottom: 10px">邮箱:{{user_information.email}}</p>
            <p style="margin-bottom: 10px">许可证:{{user_information.permission}}</p>
            <p style="margin-bottom: 10px" >密码:********</p>
            <el-button  type="primary" @click="changedialog=true" >修改个人信息</el-button>
            <el-button  type="success" @click="changedialog=true" >修改密码</el-button>
          </div>
        </div>
      </el-card>
    </div>
    <el-dialog v-model="changedialog" title="修改个人信息" width="400">
      <el-form :model="user_information" label-width="100px">
        <el-form-item label="用户名:" >
          <el-input  v-model="user_information.username" autocomplete="off" />
        </el-form-item>
        <el-form-item label="手机号:" >
          <el-input  v-model="user_information.phonenum" autocomplete="off" />
        </el-form-item>
        <el-form-item label="邮箱:" >
          <el-input  v-model="user_information.email" autocomplete="off" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="changedialog = false">取消</el-button>
          <el-button type="primary" @click="changedialog = false">
            确认
          </el-button>
        </div>
      </template>
    </el-dialog>
  </div>
  <main><router-view></router-view></main>
</template>

<style scoped>

</style>