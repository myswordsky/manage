export interface DeptQuery {
  deptName?: string
  status?: string
}

export interface DeptForm {
  deptId?: number
  parentId: number
  deptName: string
  orderNum: number
  leader?: string
  phone?: string
  email?: string
  status: string
}

export interface DeptInfo {
  deptId: number
  parentId: number
  deptName: string
  orderNum: number
  leader: string
  phone: string
  email: string
  status: string
  children?: DeptInfo[]
  createTime: string
}

export interface DeptTree {
  id: number
  label: string
  children?: DeptTree[]
} 