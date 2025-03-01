<template>
  <div class="error-container">
    <div class="error-content">
      <el-result
        icon="warning"
        title="404"
        sub-title="抱歉，您访问的页面不存在"
      >
        <template #extra>
          <el-button type="primary" @click="$router.push('/')">返回首页</el-button>
        </template>
      </el-result>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.error-container {
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #f0f2f5;
  
  .error-content {
    width: 100%;
    max-width: 500px;
    padding: 32px;
    background: #fff;
    border-radius: 4px;
  }
}
</style> 