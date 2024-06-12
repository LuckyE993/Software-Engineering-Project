
import { createApp } from 'vue';//引入vue中的依赖的creatApp
import App from './App.vue';
import router from './router';

// 引入element-plus
import ElementPlus from 'element-plus';
import 'element-plus/dist/index.css';
createApp(App).use(ElementPlus);
// 注册所有图标
import * as ElementPlusIconsVue from '@element-plus/icons-vue';
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    createApp(App).component(key, component);
}

//自定义样式的快捷方式
import "@/styles/index.scss";

//createApp创建应用实例
createApp(App)
    .use(router)
    .mount('#app');//”给相框挂照片“

//可以理解为全局插件接口，App。vue下的所有关联文件都可以使用这些功能