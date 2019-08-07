<template>
    <div class="cmt-container">
        <h3>发表评论</h3>
        <hr>
        <textarea placeholder="最多输入120字" maxlength="120" v-model="msg"></textarea>
        <mt-button type="primary" size="large" @click="postComment">发表评论</mt-button>
        <div class="cmt-list">
            <div class="cmt-item" v-for="item in comments" :key="add_time">
                <div class="cmt-title">{{item.user}}&nbsp;&nbsp;{{item.add_time | dateFormat}}</div>
                <div class="cmt-body">{{item.body === 'undefined' ? '' : item.body}}</div>
            </div>
        </div>
        <mt-button type="danger" size="large" plain="plain" @click="getMore">加载更多</mt-button>
    </div>
</template>

<script>
    import { Toast } from 'mint-ui';
    export default {
        name: "comment",
        data(){
            return {
                pageIndex: 1,   //默认展示第一页评论内容
                comments:[],    //所有评论数据
                msg:'', //评论输入的内容
            }
        },
        created(){
            this.getComments();
        },
        methods:{
            getComments(){
                this.$http.get('getNewsInfo/comment/'+this.id+'&'+this.pageIndex).then(function(res){
                    if(res.body.status === '0'){
                        //this.comments = res.body.message;
                        //每点击加载更多时加载更多评论，不清空旧数据，而是与旧数据拼接
                        this.comments = this.comments.concat(res.body.message);
                    }
                },function () {
                    Toast('获取新闻评论失败');
                })
            },
            getMore(){  //加载更多评论
                this.pageIndex++;
                this.getComments();
                if(this.comments.length === 0){
                    Toast("该新闻暂时没有评论！");
                }
            },
            postComment(){
                //评论内容是否为空
                if (this.msg.trim().length === 0){
                    return Toast("内容不能为空");
                }
                //发表评论
                //参数一：请求的URL地址
                //参数二：提交给服务器的数据对象（content：this.msg）
                //参数三：定义提交时候的表单数据格式{ emulateJSON:true }
                this.$http.post('getNewsInfo/postComment/' + this.id,{body:this.msg.trim()}).then(function(res){
                    if(res.body.status === '0'){
                        //拼接一个评论对象
                        let cmt = { user:'匿名用户',add_time:Date.now(),body: this.msg.trim() };
                        this.comments.unshift(cmt);
                        this.msg = '';
                    }
                })
            }
        },
        props:["id"],
    }
</script>

<style scoped>
.cmt-container h3{
    font-size: 18px;
    margin-top: 25px;
}
.cmt-container textarea{
    font-size: 14px;
    height: 85px;
    margin: 0;
}
.cmt-list{
    margin: 5px 0;
}
    .cmt-list .cmt-item{
        font-size: 13px;
    }
    .cmt-list .cmt-title{
        line-height: 30px;
        background-color: #ccc;
    }
.cmt-list .cmt-body{
    line-height: 40px;
    text-indent: 2em;
}
</style>