import 'vue-router'

declare module 'vue-router' {
  interface RouteMeta {
    title?: string
    icon?: string
    roles?: string[]
    activeMenu?: string
    hidden?: boolean
  }
} 