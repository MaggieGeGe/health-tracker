import { createApp } from 'vue'
import App from './App.vue'
import './registerServiceWorker'
import router from './router'

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import '@/assets/global.css'


const app = createApp(App)


app.use(router)
app.use(ElementPlus)

app.mount('#app')
