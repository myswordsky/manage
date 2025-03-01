/// <reference types="vite/client" />

declare module '*.vue' {
  import type { DefineComponent } from 'vue'
  const component: DefineComponent<{}, {}, any>
  export default component
}

declare module '*.scss' {
  const classes: { [key: string]: string }
  export default classes
}

interface ImportMetaEnv {
  readonly VITE_BASE_API: string
  readonly VITE_UPLOAD_API: string
}

interface ImportMeta {
  readonly env: ImportMetaEnv
} 