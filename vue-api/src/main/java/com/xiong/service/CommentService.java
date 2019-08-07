package com.xiong.service;

import com.xiong.mapper.CommentMapper;
import com.xiong.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;
    public List<Comment> findComment(int id,int start,int page_size){
        return commentMapper.findComment(id,start,page_size);
    }
}
