<template>
    <div>
        <ul class="mui-table-view">
            <li class="mui-table-view-cell mui-media" v-for="item in NewsList" :key="item.id">
                <router-link :to="'/home/newsinfo/' + item.id">
                    <img class="mui-media-object mui-pull-left" :src="item.img_url">
                    <div class="mui-media-body">
                        <h1>{{ item.title }}</h1>
                        <p class="mui-ellipsis">
                            <span>发表时间：{{ item.add_time | dateFormat }}</span>
                            <span>点击：{{ item.click }}次</span>
                        </p>
                    </div>
                </router-link>
            </li>
        </ul>

    </div>
</template>

<script>
    import { Toast } from 'mint-ui';
    export default {
        name: "NewsList",
        data(){
            return{
                NewsList:[], //新闻列表
            }
        },
        created() {
            this.getNewsList();
        },
        methods:{
            getNewsList(){
                this.$http.get("newlist").then(function(res){
                    //console.log(res.body.status);
                    if (res.body.status === '0') {
                        this.NewsList = res.body.message;
                        //console.log(this.NewsList);
                    }
                },function () {
                    Toast('获取新闻列表失败');
                })
            }
        },
    }
</script>

<style scoped>
    .mui-table-view a:hover{
        text-decoration: none;
    }
.mui-table-view li h1{
    font-size: 14px;
}
.mui-table-view li .mui-ellipsis{
    font-size: 12px;
    color: #226aff;
    /*时间和点击左右对齐*/
    display: flex;
    justify-content: space-between;
}
</style>