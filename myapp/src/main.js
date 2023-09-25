import { createApp } from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import '@/assets/global.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import axios from "axios";


const app = createApp(App)


app.use(router)
app.use(ElementPlus,{size:'medium'})

app.config.globalProperties.$axios = axios

app.mount('#app')
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}


