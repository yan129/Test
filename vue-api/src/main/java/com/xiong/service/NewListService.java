package com.xiong.service;

import com.xiong.mapper.NewListMapper;
import com.xiong.model.NewList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewListService {
    @Autowired
    NewListMapper newListMapper;
    public int updateClick(int id){
        return newListMapper.updateClick(id);
    }
    //查找一条新闻信息内容
    public NewList findNewInfo(int id){
        return newListMapper.findNewInfo(id);
    }
    //查找全部新闻列表
    public List<NewList> findAllNewList(){
        return newListMapper.findAllNewList();
    }
}
