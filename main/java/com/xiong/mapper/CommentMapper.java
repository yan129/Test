package com.xiong.mapper;

import com.xiong.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    //添加用户评论
    int addComment(Comment comment);
    //查找用户评论
    List<Comment> findComment(int id,int start,int page_size);
}
