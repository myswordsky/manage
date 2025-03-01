import { defineStore } from 'pinia'
import { login, logout, getInfo } from '@/api/login'
import { getToken, setToken, removeToken } from '@/utils/auth'

export const useUserStore = defineStore('user', {
  state: () => ({
    token: getToken(),
    name: '',
    avatar: '',
    roles: []
  }),
  actions: {
    // 登录
    async login(userInfo: { username: string; password: string }) {
      const { username, password } = userInfo
      const res = await login({ username: username.trim(), password })
      const { token } = res.data
      setToken(token)
      this.token = token
    },
    // 获取用户信息
    async getInfo() {
      const res = await getInfo()
      const { roles, name, avatar } = res.data
      this.roles = roles
      this.name = name
      this.avatar = avatar
    },
    // 退出登录
    async logout() {
      await logout()
      this.token = ''
      this.roles = []
      removeToken()
    }
  }
}) 