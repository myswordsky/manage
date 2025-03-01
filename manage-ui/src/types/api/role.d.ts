export interface RoleQuery {
  pageNum: number
  pageSize: number
  roleName?: string
  roleKey?: string
  status?: string
}

export interface RoleForm {
  roleId?: number
  roleName: string
  roleKey: string
  roleSort: number
  status: string
  menuIds?: number[]
  remark?: string
}

export interface RoleInfo {
  roleId: number
  roleName: string
  roleKey: string
  roleSort: number
  status: string
  createTime: string
  remark?: string
}

export interface RoleListResult {
  total: number
  rows: RoleInfo[]
} 