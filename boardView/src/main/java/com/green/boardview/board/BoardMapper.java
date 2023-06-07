package com.green.boardview.board;

import com.green.boardview.board.model.BoardEntity;
import com.green.boardview.cmt.model.BoardCmtDto;
import com.green.boardview.cmt.model.BoardCmtVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int writeBoard(BoardEntity entity);
    List<BoardEntity> selBoardAll();
    BoardEntity selBoardById(BoardEntity entity);
    int modBoard(BoardEntity entity);
    int delBoard(BoardEntity entity);
}
