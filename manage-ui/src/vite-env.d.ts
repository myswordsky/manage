/// <reference types="vite/client" />

declare module 'vue' {
  export interface GlobalComponents {
    ElButton: typeof import('element-plus')['ElButton']
    ElForm: typeof import('element-plus')['ElForm']
    ElFormItem: typeof import('element-plus')['ElFormItem']
    ElInput: typeof import('element-plus')['ElInput']
    ElSelect: typeof import('element-plus')['ElSelect']
    ElOption: typeof import('element-plus')['ElOption']
    ElTable: typeof import('element-plus')['ElTable']
    ElTableColumn: typeof import('element-plus')['ElTableColumn']
    ElTag: typeof import('element-plus')['ElTag']
    ElDialog: typeof import('element-plus')['ElDialog']
    ElInputNumber: typeof import('element-plus')['ElInputNumber']
    ElRadioGroup: typeof import('element-plus')['ElRadioGroup']
    ElRadio: typeof import('element-plus')['ElRadio']
    ElIcon: typeof import('element-plus')['ElIcon']
  }
}

export {} 