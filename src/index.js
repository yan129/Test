//入口文件
import Vue from 'vue';  //导入vue
import 'bootstrap/dist/css/bootstrap.css';  //导入bootstrap样式
import './lib/mui/css/mui.min.css'; //导入mui样式
import './lib/mui/css/icons-extra.css';
import VueRouter from 'vue-router'; //导入路由包
Vue.use(VueRouter); //安装路由
import router from './router.js';  //导入自己的router.js

// import axios from 'axios';  //导入axios
// Vue.use(axios); //安装axios
import VueResource from 'vue-resource';
Vue.use(VueResource);
// 配置全局的访问路径地址
Vue.http.options.root='http://localhost:8080';
//设置全局数据表单提交格式为json    application/x-www-form-urlencoded
Vue.http.options.emulateJSON=true;

//导入App.vue根组件
import app from './App.vue';

//定义全局的过滤器
//导入格式化时间的插件
import moment from 'moment';
Vue.filter('dateFormat',function (dataStr,pattern="YYYY-MM-DD HH:mm:ss") {
    return moment(dataStr).format(pattern);
})

//按需导入 Mint-UI 中的组件
import { Header,Swipe, SwipeItem,Button } from 'mint-ui';
Vue.component(Header.name,Header);
Vue.component(Swipe.name,Swipe);
Vue.component(SwipeItem.name,SwipeItem);
Vue.component(Button.name,Button);

var vm = new Vue({
    el: '#app',
    render: c => c(app),
    router  //挂在路由对象
})