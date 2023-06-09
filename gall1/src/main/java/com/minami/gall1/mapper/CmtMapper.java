package com.minami.gall1.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CmtMapper {
    int selCmtNum(int postId);
}
