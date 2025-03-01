export interface UserState {
  token: string | null
  name: string
  avatar: string
  roles: string[]
}

export interface LoginParams {
  username: string
  password: string
} 