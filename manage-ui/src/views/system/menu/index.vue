<template>
  <div>菜单管理</div>
</template>

<script setup lang="ts">
import { ref, reactive, onMounted } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { Search, Refresh, Plus, Edit, Delete } from '@element-plus/icons-vue'
import type { MenuQuery, MenuForm, MenuItem } from '@/types/api/menu'
import { listMenu, getMenu, addMenu, updateMenu, delMenu, treeselect } from '@/api/system/menu'
import TreeSelect from '@/components/TreeSelect/index.vue'

// 查询参数
const queryParams = reactive<MenuQuery>({
  menuName: '',
  status: ''
})

const menuList = ref<MenuItem[]>([])
const menuOptions = ref([])
const loading = ref(false)
const open = ref(false)
const title = ref('')

// 表单参数
const form = reactive<MenuForm>({
  menuName: '',
  parentId: 0,
  orderNum: 0,
  path: '',
  component: '',
  isFrame: '1',
  isCache: '0',
  menuType: 'M',
  visible: '0',
  status: '0'
})

// 表单校验规则
const rules = {
  menuName: [{ required: true, message: '菜单名称不能为空', trigger: 'blur' }],
  orderNum: [{ required: true, message: '菜单顺序不能为空', trigger: 'blur' }],
  path: [{ required: true, message: '路由地址不能为空', trigger: 'blur' }]
}

// 获取菜单列表
const getList = async () => {
  loading.value = true
  try {
    const res = await listMenu(queryParams)
    menuList.value = res.data
  } finally {
    loading.value = false
  }
}

// 获取菜单下拉树列表
const getTreeselect = async () => {
  const res = await treeselect()
  menuOptions.value = res.data
}

// 表单重置
const reset = () => {
  form.menuId = undefined
  form.menuName = ''
  form.parentId = 0
  form.orderNum = 0
  form.path = ''
  form.component = ''
  form.isFrame = '1'
  form.isCache = '0'
  form.menuType = 'M'
  form.visible = '0'
  form.status = '0'
  form.perms = ''
  form.icon = ''
  form.remark = ''
}

// 搜索按钮操作
const handleQuery = () => {
  getList()
}

// 重置按钮操作
const resetQuery = () => {
  queryParams.menuName = ''
  queryParams.status = ''
  handleQuery()
}

// 新增按钮操作
const handleAdd = () => {
  reset()
  getTreeselect()
  open.value = true
  title.value = '添加菜单'
}

// 修改按钮操作
const handleUpdate = async (row: MenuItem) => {
  reset()
  await getTreeselect()
  const menuId = row.menuId
  const res = await getMenu(menuId)
  Object.assign(form, res.data)
  open.value = true
  title.value = '修改菜单'
}

// 提交按钮
const submitForm = async () => {
  try {
    if (form.menuId) {
      await updateMenu(form)
      ElMessage.success('修改成功')
    } else {
      await addMenu(form)
      ElMessage.success('新增成功')
    }
    open.value = false
    getList()
  } catch (error: any) {
    ElMessage.error(error.message)
  }
}

// 删除按钮操作
const handleDelete = (row: MenuItem) => {
  ElMessageBox.confirm('是否确认删除名称为"' + row.menuName + '"的数据项?', '警告', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(async () => {
    await delMenu(row.menuId)
    getList()
    ElMessage.success('删除成功')
  })
}

onMounted(() => {
  getList()
})
</script> 