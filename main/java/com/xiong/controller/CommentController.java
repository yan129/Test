package com.xiong.controller;

import com.xiong.model.Comment;
import com.xiong.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class CommentController {
    //加载更多评论数据
    private int start;
    private int page_size = 2;
    @Autowired
    CommentService commentService;
    @GetMapping("/getNewsInfo/comment/{id}&{size}")
    public Map<String,Object> findComment(@PathVariable(value = "id") int id,@PathVariable(value = "size") int current){
        start = (current - 1)*2;
        Map<String,Object> map = new HashMap<>();
        map.put("status","0");
        map.put("message",commentService.findComment(id,start,page_size));
        return map;
    }

    //处理评论数据
    @RequestMapping(value = "/getNewsInfo/postComment/{id}",method = RequestMethod.POST)
    public Map<String,Object> addComment(@PathVariable("id") int id,@RequestParam("body") String body){
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Comment comment = new Comment();
        comment.setUser("匿名用户");
        comment.setNewlist_id(id);
        comment.setAdd_time(ft.format(new Date()));
        comment.setBody(body);
        int add = commentService.addComment(comment);   //成功返回 1
        if (add == 1){
            Map<String,Object> map = new HashMap<>();
            map.put("status","0");
            return map;
        }else{
            return null;
        }
    }

}
