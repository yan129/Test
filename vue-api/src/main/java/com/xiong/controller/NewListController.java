package com.xiong.controller;

import com.xiong.service.CommentService;
import com.xiong.service.NewListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回新闻标题json
 */
@RestController
public class NewListController {
    @Autowired
    NewListService newListService;
    @GetMapping("/getNewsInfo/{id}")
    public Map<String,Object> getNewInfo(@PathVariable(value = "id") int id){
        newListService.updateClick(id);
        Map<String,Object> map = new HashMap<>();
        map.put("status","0");
        map.put("message",newListService.findNewInfo(id));
        return map;
    }

    @GetMapping("/newlist")
    public Map<String,Object> getNewList() {
        Map<String,Object> map = new HashMap<>();
        map.put("status","0");
        map.put("message",newListService.findAllNewList());
        return map;
    }
}
