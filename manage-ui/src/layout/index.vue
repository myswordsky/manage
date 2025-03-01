<template>
  <div class="app-wrapper">
    <div class="sidebar-container">
      <Sidebar />
    </div>
    <div class="main-container">
      <div class="header">
        <Navbar />
      </div>
      <AppMain />
    </div>
  </div>
</template>

<script setup lang="ts">
import { Navbar, Sidebar, AppMain } from './components'
import variables from '@/styles/variables.module.scss'
</script>

<style lang="scss" scoped>
.app-wrapper {
  display: flex;
  width: 100%;
  height: 100%;
}

.sidebar-container {
  width: v-bind('variables.sideBarWidth');
  height: 100%;
  background-color: v-bind('variables.menuBg');
  transition: width 0.3s;
}

.main-container {
  flex: 1;
  display: flex;
  flex-direction: column;
  overflow: hidden;
  
  .header {
    height: 50px;
    background: #fff;
    box-shadow: 0 1px 4px rgba(0, 21, 41, 0.08);
  }
}
</style> 