package com.xiong.controller;

import com.xiong.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CommentController {
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

}
