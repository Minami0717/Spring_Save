package com.green.board7.cmt;

import com.green.board7.cmt.model.BoardCmtDelDto;
import com.green.board7.cmt.model.BoardCmtInsDto;
import com.green.board7.cmt.model.BoardCmtDto;
import com.green.board7.cmt.model.BoardCmtVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CmtMapper {
    int insCmt(BoardCmtInsDto dto);
    int delCmt(BoardCmtDelDto dto);
    List<BoardCmtVo> selCmt(BoardCmtDto dto);
}
