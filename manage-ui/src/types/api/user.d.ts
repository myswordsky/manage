export interface UserQuery {
  pageNum: number
  pageSize: number
  userName?: string
  phonenumber?: string
  status?: string
}

export interface UserForm {
  userId?: number
  userName: string
  nickName: string
  phonenumber: string
  email: string
  status: string
}

export interface UserInfo {
  userId: number
  userName: string
  nickName: string
  deptName: string
  phonenumber: string
  status: string
  createTime: string
}

export interface UserListResult {
  total: number
  rows: UserInfo[]
} 