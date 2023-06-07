package com.green.boardview.cmt;

import com.green.boardview.cmt.model.BoardCmtDto;
import com.green.boardview.cmt.model.BoardCmtInsDto;
import com.green.boardview.cmt.model.BoardCmtVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {
    private final CmtMapper mapper;

    @Autowired
    public CmtService(CmtMapper mapper) {
        this.mapper = mapper;
    }

    public int insCmt(BoardCmtInsDto dto) {
        return mapper.insCmt(dto);
    }

    public List<BoardCmtVo> selCmt(BoardCmtDto dto) {
        return mapper.selCmt(dto);
    }
    public int delCmt(BoardCmtDto dto) {
        return mapper.delCmt(dto);
    }
}
