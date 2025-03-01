import request from '@/utils/request'

// 查询用户列表
export function listUser(query: any) {
  return request({
    url: '/system/user/list',
    method: 'get',
    params: query
  })
}

// 查询用户详细
export function getUser(userId: number) {
  return request({
    url: `/system/user/${userId}`,
    method: 'get'
  })
}

// 新增用户
export function addUser(data: any) {
  return request({
    url: '/system/user',
    method: 'post',
    data
  })
}

// 修改用户
export function updateUser(data: any) {
  return request({
    url: '/system/user',
    method: 'put',
    data
  })
}

// 删除用户
export function delUser(userId: number) {
  return request({
    url: `/system/user/${userId}`,
    method: 'delete'
  })
}

// 修改用户状态
export function changeUserStatus(userId: number, status: string) {
  return request({
    url: `/system/user/${userId}/status/${status}`,
    method: 'put'
  })
} 