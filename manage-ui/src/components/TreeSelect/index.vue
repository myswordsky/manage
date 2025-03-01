<template>
  <el-select
    v-model="value"
    :placeholder="placeholder"
    clearable
    class="tree-select"
    :disabled="disabled"
    @change="handleChange"
  >
    <el-option value="0" label="顶级菜单" v-if="showRoot" />
    <el-option
      v-for="item in options"
      :key="item.id"
      :value="item.id"
      :label="item.label"
      :disabled="item.disabled"
    >
      <span :style="{ paddingLeft: item.level * 20 + 'px' }">{{ item.label }}</span>
    </el-option>
  </el-select>
</template>

<script setup lang="ts">
import { ref, watch } from 'vue'
import type { MenuTree } from '@/types/api/menu'

interface TreeOption {
  id: number
  label: string
  level: number
  disabled?: boolean
}

const props = defineProps({
  modelValue: {
    type: [String, Number],
    default: undefined
  },
  data: {
    type: Array as () => any[],
    required: true
  },
  placeholder: {
    type: String,
    default: '请选择'
  },
  disabled: {
    type: Boolean,
    default: false
  },
  showRoot: {
    type: Boolean,
    default: true
  }
})

const emit = defineEmits(['update:modelValue', 'change'])

const value = ref(props.modelValue)
const options = ref<TreeOption[]>([])

watch(() => props.modelValue, (val) => {
  value.value = val
})

watch(() => props.data, (val) => {
  const opts: TreeOption[] = []
  const traverse = (items: MenuTree[], level = 0) => {
    items.forEach(item => {
      opts.push({
        id: item.id,
        label: item.label,
        level
      })
      if (item.children?.length) {
        traverse(item.children, level + 1)
      }
    })
  }
  traverse(val)
  options.value = opts
}, { immediate: true })

const handleChange = (val: string | number) => {
  emit('update:modelValue', val)
  emit('change', val)
}
</script>

<style lang="scss" scoped>
.tree-select {
  width: 100%;
}
</style> 