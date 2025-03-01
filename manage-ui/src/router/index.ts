import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'

const routes: RouteRecordRaw[] = [
  {
    path: '/login',
    component: () => import('@/views/login/index.vue')
  },
  {
    path: '/',
    component: () => import('@/layout/index.vue'),
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: () => import('@/views/dashboard/index.vue'),
        name: 'Dashboard',
        meta: { title: '首页', icon: 'House' }
      },
      {
        path: 'system',
        name: 'System',
        redirect: '/system/user',
        meta: { title: '系统管理', icon: 'Setting' },
        children: [
          {
            path: 'user',
            component: () => import('@/views/system/user/index.vue'),
            name: 'User',
            meta: { title: '用户管理' }
          },
          {
            path: 'role',
            component: () => import('@/views/system/role/index.vue'),
            name: 'Role',
            meta: { title: '角色管理' }
          },
          {
            path: 'menu',
            component: () => import('@/views/system/menu/index.vue'),
            name: 'Menu',
            meta: { title: '菜单管理' }
          },
          {
            path: 'dept',
            component: () => import('@/views/system/dept/index.vue'),
            name: 'Dept',
            meta: { title: '部门管理' }
          }
        ]
      }
    ]
  },
  {
    path: '/404',
    component: () => import('@/views/error-page/404.vue')
  },
  {
    path: '/:pathMatch(.*)*',
    redirect: '/404'
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

// 路由守卫
router.beforeEach((to, from, next) => {
  // 如果访问登录页，直接放行
  if (to.path === '/login') {
    next()
    return
  }
  
  // 这里可以添加登录验证逻辑
  const token = localStorage.getItem('token')
  if (!token && to.path !== '/login') {
    next('/login')
    return
  }
  
  next()
})

export default router 