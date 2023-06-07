package com.green.boardview.board;

import com.green.boardview.board.model.BoardEntity;
import com.green.boardview.cmt.model.BoardCmtDto;
import com.green.boardview.cmt.model.BoardCmtVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;

    @Autowired
    public BoardService(BoardMapper mapper) {
        this.mapper = mapper;
    }

    public int writeBoard(BoardEntity entity) {
        return mapper.writeBoard(entity);
    }

    public List<BoardEntity> selBoardAll() {
        return mapper.selBoardAll();
    }

    public BoardEntity selBoardById(BoardEntity entity) {
        return mapper.selBoardById(entity);
    }

    public int modBoard(BoardEntity entity) {
        return mapper.modBoard(entity);
    }

    public int delBoard(BoardEntity entity) {
        return mapper.delBoard(entity);
    }
}
