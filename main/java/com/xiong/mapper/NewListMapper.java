package com.xiong.mapper;

import com.xiong.model.NewList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewListMapper {
    int updateClick(int id);
    NewList findNewInfo(int id);
    List<NewList> findAllNewList();
}
