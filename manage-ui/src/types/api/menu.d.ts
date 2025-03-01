export interface MenuQuery {
  menuName?: string
  status?: string
}

export interface MenuForm {
  menuId?: number
  menuName: string
  parentId?: number
  orderNum: number
  path: string
  component?: string
  query?: string
  isFrame: string
  isCache: string
  menuType: string
  visible: string
  status: string
  perms?: string
  icon?: string
  remark?: string
}

export interface MenuItem {
  menuId: number
  menuName: string
  parentId: number
  orderNum: number
  path: string
  component: string
  query: string
  isFrame: string
  isCache: string
  menuType: string
  visible: string
  status: string
  perms: string
  icon: string
  children?: MenuItem[]
  createTime: string
}

export interface MenuTree {
  id: number
  label: string
  children?: MenuTree[]
} 