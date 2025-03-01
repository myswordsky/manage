<template>
  <div>角色管理</div>
</template>

<script setup lang="ts">
import { ref, reactive, onMounted } from 'vue'
import { ElMessage, ElMessageBox, ElTree } from 'element-plus'
import { Search, Refresh, Plus, Edit, Delete, Operation } from '@element-plus/icons-vue'
import type { RoleQuery, RoleForm, RoleInfo } from '@/types/api/role'
import { listRole, getRole, addRole, updateRole, delRole, changeRoleStatus, getRoleMenus, updateRoleMenus } from '@/api/system/role'

// 查询参数
const queryParams = reactive<RoleQuery>({
  pageNum: 1,
  pageSize: 10,
  roleName: '',
  roleKey: '',
  status: ''
})

const roleList = ref<RoleInfo[]>([])
const total = ref(0)
const loading = ref(false)
const open = ref(false)
const menuOpen = ref(false)
const title = ref('')
const menuRef = ref<InstanceType<typeof ElTree>>()
const menuOptions = ref([])
const currentRoleId = ref(0)

// 表单参数
const form = reactive<RoleForm>({
  roleName: '',
  roleKey: '',
  roleSort: 0,
  status: '0'
})

// 表单校验规则
const rules = {
  roleName: [{ required: true, message: '角色名称不能为空', trigger: 'blur' }],
  roleKey: [{ required: true, message: '权限字符不能为空', trigger: 'blur' }],
  roleSort: [{ required: true, message: '显示顺序不能为空', trigger: 'blur' }]
}

// 获取角色列表
const getList = async () => {
  loading.value = true
  try {
    const res = await listRole(queryParams)
    roleList.value = res.data.rows
    total.value = res.data.total
  } finally {
    loading.value = false
  }
}

// 表单重置
const reset = () => {
  form.roleId = undefined
  form.roleName = ''
  form.roleKey = ''
  form.roleSort = 0
  form.status = '0'
  form.remark = ''
}

// 搜索按钮操作
const handleQuery = () => {
  queryParams.pageNum = 1
  getList()
}

// 重置按钮操作
const resetQuery = () => {
  queryParams.roleName = ''
  queryParams.roleKey = ''
  queryParams.status = ''
  handleQuery()
}

// 新增按钮操作
const handleAdd = () => {
  reset()
  open.value = true
  title.value = '添加角色'
}

// 修改按钮操作
const handleUpdate = async (row: RoleInfo) => {
  reset()
  const roleId = row.roleId
  const res = await getRole(roleId)
  Object.assign(form, res.data)
  open.value = true
  title.value = '修改角色'
}

// 提交按钮
const submitForm = async () => {
  try {
    if (form.roleId) {
      await updateRole(form)
      ElMessage.success('修改成功')
    } else {
      await addRole(form)
      ElMessage.success('新增成功')
    }
    open.value = false
    getList()
  } catch (error: any) {
    ElMessage.error(error.message)
  }
}

// 删除按钮操作
const handleDelete = (row: RoleInfo) => {
  ElMessageBox.confirm('是否确认删除角色编号为"' + row.roleId + '"的数据项?', '警告', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    await delRole(row.roleId)
    getList()
    ElMessage.success('删除成功')
  })
}

// 角色状态修改
const handleStatusChange = async (row: RoleInfo) => {
  try {
    await changeRoleStatus(row.roleId, row.status)
    ElMessage.success('修改成功')
  } catch (error) {
    row.status = row.status === '0' ? '1' : '0'
  }
}

// 菜单权限按钮操作
const handleMenuAuth = async (row: RoleInfo) => {
  currentRoleId.value = row.roleId
  const res = await getRoleMenus(row.roleId)
  menuRef.value!.setCheckedKeys(res.data)
  menuOpen.value = true
}

// 提交菜单权限
const submitMenuAuth = async () => {
  const menuIds = menuRef.value!.getCheckedKeys() as number[]
  await updateRoleMenus(currentRoleId.value, menuIds)
  menuOpen.value = false
  ElMessage.success('授权成功')
}

onMounted(() => {
  getList()
})
</script> 