<template>
    <div>
<!--        轮播图区域-->
        <mt-swipe :auto="4000">
            <mt-swipe-item v-for="item in Lunbotu" :key="item.url">
                <a :href="item.url"><img :src="item.img" alt=""></a>
            </mt-swipe-item>
        </mt-swipe>
<!--        九宫格-->
        <ul class="mui-table-view mui-grid-view mui-grid-9">
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
                <router-link to="/home/newslist">
                <span class="mui-icon mui-icon-home"></span>
                <div class="mui-media-body">新闻资讯</div></router-link></li>
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><a href="#">
                <span class="mui-icon mui-icon-email"><span class="mui-badge">5</span></span>
                <div class="mui-media-body">图片分享</div></a></li>
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><a href="#">
                <span class="mui-icon mui-icon-chatbubble"></span>
                <div class="mui-media-body">商品购买</div></a></li>
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><a href="#">
                <span class="mui-icon mui-icon-location"></span>
                <div class="mui-media-body">留言反馈</div></a></li>
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><a href="#">
                <span class="mui-icon mui-icon-search"></span>
                <div class="mui-media-body">食品专区</div></a></li>
            <li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3"><a href="#">
                <span class="mui-icon mui-icon-phone"></span>
                <div class="mui-media-body">联系我们</div></a></li>
        </ul>


    </div>
</template>

<script>
    import { Toast } from 'mint-ui';
    export default {
        name: "HomeContainer",
        data(){
            return {
                Lunbotu:[],
            }
        },
        created(){
            this.getLunbotu();
        },
        methods: {
            getLunbotu(){
                this.$http.get('swipe').then(function (res) {
                    this.Lunbotu = res.body;
                },function () {
                    Toast('请求处理失败');
                })
            }
        },
    }
</script>

<style scoped>
.mint-swipe{
    height: 200px;
}
.mint-swipe img{
    width: 100%;
    height: 100%;
}
.mui-grid-view.mui-grid-9{
    background-color: #fff;
    border: none;
}
.mui-grid-view.mui-grid-9 .mui-table-view-cell{
    border: 0;
}
.mui-col-sm-3{
    width: 33.33%;
}
</style>