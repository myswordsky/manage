<template>
  <div class="dashboard-container">
    <el-row :gutter="20">
      <el-col :span="6">
        <el-card shadow="hover">
          <template #header>
            <div class="card-header">
              <span>用户总数</span>
            </div>
          </template>
          <div class="card-body">
            <el-statistic :value="1000">
              <template #prefix>
                <el-icon><User /></el-icon>
              </template>
            </el-statistic>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="hover">
          <template #header>
            <div class="card-header">
              <span>角色总数</span>
            </div>
          </template>
          <div class="card-body">
            <el-statistic :value="10">
              <template #prefix>
                <el-icon><UserFilled /></el-icon>
              </template>
            </el-statistic>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="hover">
          <template #header>
            <div class="card-header">
              <span>部门总数</span>
            </div>
          </template>
          <div class="card-body">
            <el-statistic :value="20">
              <template #prefix>
                <el-icon><Office /></el-icon>
              </template>
            </el-statistic>
          </div>
        </el-card>
      </el-col>
      <el-col :span="6">
        <el-card shadow="hover">
          <template #header>
            <div class="card-header">
              <span>菜单总数</span>
            </div>
          </template>
          <div class="card-body">
            <el-statistic :value="50">
              <template #prefix>
                <el-icon><Menu /></el-icon>
              </template>
            </el-statistic>
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script setup lang="ts">
import { User, UserFilled, Office, Menu } from '@element-plus/icons-vue'
</script>

<style lang="scss" scoped>
.dashboard-container {
  padding: 20px;
  
  .el-card {
    margin-bottom: 20px;
    
    .card-header {
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
    
    .card-body {
      padding: 20px 0;
      text-align: center;
    }
  }
}
</style> 