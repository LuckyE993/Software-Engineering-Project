<script setup>

import {ElButton, ElIcon, ElTable, ElTableColumn} from "element-plus";
import {CirclePlus, CloseBold, Edit} from "@element-plus/icons-vue";
</script>

<template>
  <div style="display: flex;flex-direction: column">
    <div style="height: 50px;"><el-button type="success " style="margin-left: 1200px;width: 90px"><el-icon size="large" style="margin: 2px"><circle-plus/></el-icon>添加规则</el-button></div>
    <el-table :data="tableData" border style="width: 100% ;height: 500px">
      <el-table-column fixed prop="id" label="编号" width="180"  />
      <el-table-column prop="rule_name" label="规则名称" width="180" />
      <el-table-column prop="date" label="创建日期" width="180" />
      <el-table-column prop="set_people" label="创建人" width="180" />
      <el-table-column prop="department" label="部门" width="180" />
      <el-table-column prop="introduction" label="简介" width="180" />
      <el-table-column prop="operation" label="操作" width="180">
        <template #default>
          <el-button  type="primary" size="small">
            <el-icon size="large"><Edit/></el-icon>
            编辑
          </el-button>
          <el-button  color="red" type="primary" size="small" @click="handleClick">
            <el-icon size="large"><CloseBold/></el-icon>
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped>

</style>