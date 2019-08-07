<template>
    <div class="newsinfo-container">
        <h3 class="title">{{NewsInfo.title}}</h3>
        <p class="subtitle">
            <span>发表时间：{{NewsInfo.add_time | dateFormat}}</span>
            <span>点击：{{NewsInfo.click}}次</span>
        </p>
        <hr>
<!--        新闻内容-->
        <div class="content" v-html="NewsInfo.content"></div>

<!--        子组件评论区-->
        <comment-box :id="this.id"></comment-box>
    </div>
</template>

<script>
    import { Toast } from 'mint-ui';
    import comment from '../subcomponents/comment.vue';

    export default {
        name: "NewsInfo",
        data(){
            return {
                id: this.$route.params.id,  //将URL地址中传递过来的ID值挂载到data上，方便调用
                NewsInfo:{},
            }
        },
        created(){
            this.getNewsInfo();
        },
        methods:{
            getNewsInfo(){
                this.$http.get("getNewsInfo/" +this.id).then(function (res) {
                    if (res.body.status = '0'){
                        this.NewsInfo = res.body.message;
                    }
                },function () {
                    Toast('获取新闻内容失败');
                })
            }
        },
        components:{    //注册子组件
            'comment-box': comment,
        }
    }
</script>

<style scoped>
.newsinfo-container{
    padding: 0 5px;
}
    .title{
        font-size: 16px;
        text-align: center;
        margin: 15px 0;
    }
    .subtitle{
        display: flex;
        justify-content: space-between;
        font-size: 12px;
        color: #226aff;
    }
    .content{

    }
</style>