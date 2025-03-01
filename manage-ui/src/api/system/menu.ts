import request from '@/utils/request'
import type { MenuQuery, MenuForm } from '@/types/api/menu'

// 查询菜单列表
export function listMenu(query?: MenuQuery) {
  return request({
    url: '/system/menu/list',
    method: 'get',
    params: query
  })
}

// 查询菜单详细
export function getMenu(menuId: number) {
  return request({
    url: `/system/menu/${menuId}`,
    method: 'get'
  })
}

// 查询菜单下拉树结构
export function treeselect() {
  return request({
    url: '/system/menu/treeselect',
    method: 'get'
  })
}

// 新增菜单
export function addMenu(data: MenuForm) {
  return request({
    url: '/system/menu',
    method: 'post',
    data
  })
}

// 修改菜单
export function updateMenu(data: MenuForm) {
  return request({
    url: '/system/menu',
    method: 'put',
    data
  })
}

// 删除菜单
export function delMenu(menuId: number) {
  return request({
    url: `/system/menu/${menuId}`,
    method: 'delete'
  })
} 