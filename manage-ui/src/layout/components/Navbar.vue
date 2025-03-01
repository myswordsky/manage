<template>
  <div class="navbar">
    <div class="right-menu">
      <el-dropdown>
        <span class="el-dropdown-link">
          <el-avatar size="small" icon="UserFilled" />
          admin
          <el-icon><CaretBottom /></el-icon>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item @click="handleLogout">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router'
import { CaretBottom } from '@element-plus/icons-vue'

const router = useRouter()

const handleLogout = () => {
  router.push('/login')
}
</script>

<style lang="scss" scoped>
.navbar {
  height: 100%;
  display: flex;
  align-items: center;
  padding: 0 20px;
  
  .right-menu {
    margin-left: auto;
    
    .el-dropdown-link {
      display: flex;
      align-items: center;
      gap: 8px;
      cursor: pointer;
    }
  }
}
</style> 