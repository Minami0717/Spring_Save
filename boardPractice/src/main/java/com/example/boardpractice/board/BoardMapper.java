package com.example.boardpractice.board;

import com.example.boardpractice.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(BoardEntity dto);
    List<BoardVo> selBoard(BoardSelDto dto);
    BoardCntVo selBoardCount();
    BoardDetailVo selBoardById(BoardIdDto dto);
    int delBoard(BoardDelDto dto);
    int updBoard(BoardUpdDto dto);
    List<Integer> selIboardByIuser(int iuser);
}
