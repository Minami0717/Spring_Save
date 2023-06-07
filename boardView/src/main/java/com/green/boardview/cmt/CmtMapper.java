package com.green.boardview.cmt;

import com.green.boardview.cmt.model.BoardCmtDto;
import com.green.boardview.cmt.model.BoardCmtInsDto;
import com.green.boardview.cmt.model.BoardCmtVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int insCmt(BoardCmtInsDto dto);
    List<BoardCmtVo> selCmt(BoardCmtDto dto);
    int delCmt(BoardCmtDto dto);
}
