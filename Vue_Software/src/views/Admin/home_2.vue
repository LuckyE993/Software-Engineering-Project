<script  setup>
import {
  ElMenu,
  ElContainer,
  ElAside,
  ElHeader,
  ElMain,
  ElIcon,
  ElMenuItem,
  ElDialog,
  ElButton,
} from "element-plus";
import {MessageBox, User,House} from '@element-plus/icons-vue'
import {reactive, ref} from "vue";
import {ElFooter} from "element-plus";

const username=ref("用户9527")

const dialogVisible = ref(false)


</script>

<template>
    <el-container class="father_con" ><!--主容器-->
      <el-header class="header" style="background: #000000;color: white">
        <p>你好，管理员</p>
        <el-button @click="dialogVisible=true" class="exit" type="danger" style="margin-left: 15px;font-weight: bold;" color="red" >退出登录</el-button>
      </el-header>
      <el-container class="son_con"><!--子容器-->
        <el-aside class="aside" width="200px">
          <div style="height: 80px;align-items: center;justify-content: center;display: flex">
            <img style="height: 80px;width: 100%;" src="@/assets/logo.png">
          </div>
          <el-menu class="el-menu" :default-active="$route.path" :router="true" text-color="white" active-text-color="white" >
            <el-menu-item class="el-menu-item" index="/management" ><el-icon><User/></el-icon>用户信息</el-menu-item>
          </el-menu>
        </el-aside>
        <el-container >
          <el-main>
            <router-view></router-view>
          </el-main>
          <el-footer style="background-color: black;height:200px;" ></el-footer>
        </el-container>
      </el-container>
    </el-container>
  <el-dialog
      v-model="dialogVisible"
      title="提示"
      width="500"
  >
    <span>确定退出吗？</span>
    <template #footer>
      <div class="dialog-footer">
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="dialogVisible = false">确定</el-button>
      </div>
    </template>
  </el-dialog>
</template>

<style scoped>
.father_con{
  height: 100%;
  width: 100%;
  display: flex;
  position: fixed;
}
.header{
  display: flex;
  justify-content: flex-end;
  align-items: center;
  font-size: large;
}
.exit:hover{
  background-color: #f3a2a2;
}
.el-menu{
  border: none;
  min-height:100vh;
  background-color:#000000;
}
.el-menu-item{
  justify-content: center;
}
.el-menu-item.is-active{
  background-color: rgba(124, 136, 136, 0.54);
  font-weight: bold;
}

</style>