package com.xiong.mapper;

import com.xiong.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> findComment(int id,int start,int page_size);
}
