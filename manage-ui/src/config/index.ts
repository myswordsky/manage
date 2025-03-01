interface Config {
  title: string
  baseApi: string
  uploadApi: string
}

const config: Config = {
  title: '后台管理系统',
  baseApi: import.meta.env.VITE_BASE_API || '/api',
  uploadApi: import.meta.env.VITE_UPLOAD_API || '/api/upload'
}

export default config 