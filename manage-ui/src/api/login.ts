import request from '@/utils/request'

export interface LoginParams {
  username: string
  password: string
}

export function login(data: LoginParams) {
  return request({
    url: '/auth/login',
    method: 'post',
    data
  })
}

export function logout() {
  return request({
    url: '/auth/logout',
    method: 'post'
  })
}

export function getInfo() {
  return request({
    url: '/system/user/info',
    method: 'get'
  })
} 