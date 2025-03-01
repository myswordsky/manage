import request from '@/utils/request'
import type { RoleQuery, RoleForm } from '@/types/api/role'

// 查询角色列表
export function listRole(query: RoleQuery) {
  return request({
    url: '/system/role/list',
    method: 'get',
    params: query
  })
}

// 查询角色详细
export function getRole(roleId: number) {
  return request({
    url: `/system/role/${roleId}`,
    method: 'get'
  })
}

// 新增角色
export function addRole(data: RoleForm) {
  return request({
    url: '/system/role',
    method: 'post',
    data
  })
}

// 修改角色
export function updateRole(data: RoleForm) {
  return request({
    url: '/system/role',
    method: 'put',
    data
  })
}

// 删除角色
export function delRole(roleId: number) {
  return request({
    url: `/system/role/${roleId}`,
    method: 'delete'
  })
}

// 修改角色状态
export function changeRoleStatus(roleId: number, status: string) {
  return request({
    url: `/system/role/${roleId}/status/${status}`,
    method: 'put'
  })
}

// 查询角色已授权菜单
export function getRoleMenus(roleId: number) {
  return request({
    url: `/system/role/${roleId}/menus`,
    method: 'get'
  })
}

// 保存角色菜单授权
export function updateRoleMenus(roleId: number, menuIds: number[]) {
  return request({
    url: `/system/role/${roleId}/menus`,
    method: 'put',
    data: { menuIds }
  })
} 