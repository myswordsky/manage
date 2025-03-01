<template>
  <div>部门管理</div>
</template>

<script setup lang="ts">
import { ref, reactive, onMounted } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { Search, Refresh, Plus, Edit, Delete } from '@element-plus/icons-vue'
import type { DeptQuery, DeptForm, DeptInfo } from '@/types/api/dept'
import { listDept, getDept, addDept, updateDept, delDept, treeselect } from '@/api/system/dept'
import TreeSelect from '@/components/TreeSelect/index.vue'

// 查询参数
const queryParams = reactive<DeptQuery>({
  deptName: '',
  status: ''
})

const deptList = ref<DeptInfo[]>([])
const deptOptions = ref([])
const loading = ref(false)
const open = ref(false)
const title = ref('')

// 表单参数
const form = reactive<DeptForm>({
  parentId: 0,
  deptName: '',
  orderNum: 0,
  leader: '',
  phone: '',
  email: '',
  status: '0'
})

// 表单校验规则
const rules = {
  deptName: [{ required: true, message: '部门名称不能为空', trigger: 'blur' }],
  orderNum: [{ required: true, message: '显示排序不能为空', trigger: 'blur' }],
  email: [{ type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }],
  phone: [{ pattern: /^1[3-9]\d{9}$/, message: '请输入正确的手机号码', trigger: ['blur', 'change'] }]
}

// 获取部门列表
const getList = async () => {
  loading.value = true
  try {
    const res = await listDept(queryParams)
    deptList.value = res.data
  } finally {
    loading.value = false
  }
}

// 获取部门下拉树列表
const getTreeselect = async () => {
  const res = await treeselect()
  deptOptions.value = res.data
}

// 表单重置
const reset = () => {
  form.deptId = undefined
  form.parentId = 0
  form.deptName = ''
  form.orderNum = 0
  form.leader = ''
  form.phone = ''
  form.email = ''
  form.status = '0'
}

// 搜索按钮操作
const handleQuery = () => {
  getList()
}

// 重置按钮操作
const resetQuery = () => {
  queryParams.deptName = ''
  queryParams.status = ''
  handleQuery()
}

// 新增按钮操作
const handleAdd = () => {
  reset()
  getTreeselect()
  open.value = true
  title.value = '添加部门'
}

// 修改按钮操作
const handleUpdate = async (row: DeptInfo) => {
  reset()
  await getTreeselect()
  const deptId = row.deptId
  const res = await getDept(deptId)
  Object.assign(form, res.data)
  open.value = true
  title.value = '修改部门'
}

// 提交按钮
const submitForm = async () => {
  try {
    if (form.deptId) {
      await updateDept(form)
      ElMessage.success('修改成功')
    } else {
      await addDept(form)
      ElMessage.success('新增成功')
    }
    open.value = false
    getList()
  } catch (error: any) {
    ElMessage.error(error.message)
  }
}

// 删除按钮操作
const handleDelete = (row: DeptInfo) => {
  ElMessageBox.confirm('是否确认删除名称为"' + row.deptName + '"的数据项?', '警告', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    await delDept(row.deptId)
    getList()
    ElMessage.success('删除成功')
  })
}

// 取消按钮操作
const cancel = () => {
  open.value = false
  reset()
}

onMounted(() => {
  getList()
})
</script> 