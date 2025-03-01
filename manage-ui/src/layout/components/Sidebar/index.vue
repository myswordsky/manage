<template>
  <el-menu
    :default-active="activeMenu"
    :background-color="variables.menuBg"
    :text-color="variables.menuText"
    :active-text-color="variables.menuActiveText"
    :unique-opened="true"
    router
  >
    <el-menu-item index="/dashboard">
      <el-icon><House /></el-icon>
      <template #title>首页</template>
    </el-menu-item>
    
    <el-sub-menu index="system">
      <template #title>
        <el-icon><Setting /></el-icon>
        <span>系统管理</span>
      </template>
      <el-menu-item index="/system/user">用户管理</el-menu-item>
      <el-menu-item index="/system/role">角色管理</el-menu-item>
      <el-menu-item index="/system/menu">菜单管理</el-menu-item>
      <el-menu-item index="/system/dept">部门管理</el-menu-item>
    </el-sub-menu>
  </el-menu>
</template>

<script setup lang="ts">
import { computed } from 'vue'
import { useRoute } from 'vue-router'
import { House, Setting } from '@element-plus/icons-vue'
import variables from '@/styles/variables.module.scss'

const route = useRoute()
const activeMenu = computed(() => route.path)
</script> 