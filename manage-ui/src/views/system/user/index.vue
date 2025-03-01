<template>
  <div>用户管理</div>
</template>

<script setup lang="ts">
import { ref, reactive, onMounted } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { Search, Refresh, Plus, Edit, Delete } from '@element-plus/icons-vue'
import type { UserQuery, UserForm, UserInfo } from '@/types/api/user'
import { listUser, getUser, addUser, updateUser, delUser, changeUserStatus } from '@/api/system/user'

// 查询参数
const queryParams = reactive<UserQuery>({
  pageNum: 1,
  pageSize: 10,
  userName: '',
  phonenumber: '',
  status: ''
})

const userList = ref<UserInfo[]>([])
const total = ref(0)
const loading = ref(false)
const open = ref(false)
const title = ref('')

// 表单参数
const form = reactive<UserForm>({
  userId: undefined,
  userName: '',
  nickName: '',
  phonenumber: '',
  email: '',
  status: '0'
})

// 表单校验规则
const rules = {
  userName: [{ required: true, message: '用户名称不能为空', trigger: 'blur' }],
  nickName: [{ required: true, message: '用户昵称不能为空', trigger: 'blur' }]
}

// 获取用户列表
const getList = async () => {
  loading.value = true
  try {
    const res = await listUser(queryParams)
    userList.value = res.data.rows
    total.value = res.data.total
  } finally {
    loading.value = false
  }
}

// 表单重置
const reset = () => {
  form.userId = undefined
  form.userName = ''
  form.nickName = ''
  form.phonenumber = ''
  form.email = ''
  form.status = '0'
}

// 搜索按钮操作
const handleQuery = () => {
  queryParams.pageNum = 1
  getList()
}

// 重置按钮操作
const resetQuery = () => {
  queryParams.userName = ''
  queryParams.phonenumber = ''
  queryParams.status = ''
  handleQuery()
}

// 新增按钮操作
const handleAdd = () => {
  reset()
  open.value = true
  title.value = '添加用户'
}

// 修改按钮操作
const handleUpdate = async (row: any) => {
  reset()
  const userId = row.userId
  const res = await getUser(userId)
  Object.assign(form, res.data)
  open.value = true
  title.value = '修改用户'
}

// 提交按钮
const submitForm = async () => {
  try {
    if (form.userId) {
      await updateUser(form)
      ElMessage.success('修改成功')
    } else {
      await addUser(form)
      ElMessage.success('新增成功')
    }
    open.value = false
    getList()
  } catch (error: any) {
    ElMessage.error(error.message)
  }
}

// 删除按钮操作
const handleDelete = (row: any) => {
  ElMessageBox.confirm('是否确认删除用户编号为"' + row.userId + '"的数据项?', '警告', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    await delUser(row.userId)
    getList()
    ElMessage.success('删除成功')
  })
}

// 用户状态修改
const handleStatusChange = async (row: any) => {
  try {
    await changeUserStatus(row.userId, row.status)
    ElMessage.success('修改成功')
  } catch (error) {
    row.status = row.status === '0' ? '1' : '0'
  }
}

onMounted(() => {
  getList()
})
</script> 