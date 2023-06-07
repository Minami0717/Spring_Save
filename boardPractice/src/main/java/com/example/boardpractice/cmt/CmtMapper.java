package com.example.boardpractice.cmt;

import com.example.boardpractice.cmt.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int insCmt(CmtEntity entity);
    int updCmt(CmtEntity entity);
    int delCmt(CmtDelDto dto);
    List<CmtVo> selCmt(CmtSelDto dto);
    int selCmtCount(int iboard);
}
