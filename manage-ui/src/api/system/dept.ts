import request from '@/utils/request'
import type { DeptQuery, DeptForm } from '@/types/api/dept'

// 查询部门列表
export function listDept(query?: DeptQuery) {
  return request({
    url: '/system/dept/list',
    method: 'get',
    params: query
  })
}

// 查询部门详细
export function getDept(deptId: number) {
  return request({
    url: `/system/dept/${deptId}`,
    method: 'get'
  })
}

// 查询部门下拉树结构
export function treeselect() {
  return request({
    url: '/system/dept/treeselect',
    method: 'get'
  })
}

// 新增部门
export function addDept(data: DeptForm) {
  return request({
    url: '/system/dept',
    method: 'post',
    data
  })
}

// 修改部门
export function updateDept(data: DeptForm) {
  return request({
    url: '/system/dept',
    method: 'put',
    data
  })
}

// 删除部门
export function delDept(deptId: number) {
  return request({
    url: `/system/dept/${deptId}`,
    method: 'delete'
  })
} 