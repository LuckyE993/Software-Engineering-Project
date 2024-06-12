<script setup>
import {ElButton} from "element-plus";
</script>

<template>
  <div class="flex-c-center-center" style="width: 100%;height:100%;position: fixed" >
    <div class="flex-c-center-center" style="background:#ffffff;height: 500px;width: 600px;box-shadow: 20px 10px 5px #879687;border-radius: 10px" >
      <h1 style="flex:1 ;">企业级网络抽奖系统</h1>
      <h3 style="flex:1;">Good luck to you!</h3>
      <img style="height: 300px;" src="@/assets/gift.png">
      <nav style="flex:4">
        <router-link  to="/login" >
          <el-button  type="success"  style="height: 50px;width: 200px;" >快速体验</el-button>
        </router-link>
      </nav>
    </div>
  </div>
  <main><router-view></router-view></main>
</template>

<style scoped>
.flex-c-center-center{
  background: #7fffca;
}
</style>