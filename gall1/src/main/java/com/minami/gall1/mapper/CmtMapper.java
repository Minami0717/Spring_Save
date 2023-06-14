package com.minami.gall1.mapper;

import com.minami.gall1.model.CmtInsDto;
import com.minami.gall1.model.CmtVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int selCmtNum(int postId);
    List<CmtVo> selCmtByPostId(int postId);
    int insCmt(CmtInsDto dto);
}
