import {createRouter, createWebHistory} from "vue-router";
import launch from "@/components/User/launch.vue";
import rules from "@/components/User/rules.vue";
import information from "@/components/User/information.vue";
import management from "@/components/Admin/management.vue";


const routes=[
    {
        path:"/login",
        name:"login",
        component:()=>import("../views/login.vue")//引入路由路径下的对应的组件
    },
    {
        path:"/register",
        name:"register",
        component:()=>import("../views/register.vue")//引入路由路径下的对应的组件
    },
    {
        path:"/user",
        name:"user",
        redirect:"/information",
        component:()=>import("../views/User/home_1.vue"),//引入路由路径下的对应的组件
        children:[
            {path:'/information',component:information},
            {path:'/rules',component:rules},
            {path:'/launch',component:launch},
        ]
    },
    {
        path:"/",
        name:"premise",
        component:()=>import("../views/premise.vue")//引入路由路径下的对应的组件
    },
    {
        path:"/admin",
        name:"register",
        redirect: '/management',
        component:()=>import("../views/Admin/home_2.vue"),//引入路由路径下的对应的组件
        children:[
            {path:'/management',component:management},
        ]
    },
]
//创建路由器实例
const router=createRouter({
    history:createWebHistory(),
    routes
})

export default router