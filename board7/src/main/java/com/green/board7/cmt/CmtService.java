package com.green.board7.cmt;

import com.green.board7.cmt.model.BoardCmtDelDto;
import com.green.board7.cmt.model.BoardCmtInsDto;
import com.green.board7.cmt.model.BoardCmtDto;
import com.green.board7.cmt.model.BoardCmtVo;
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

    public int delCmt(BoardCmtDelDto dto) {
        return mapper.delCmt(dto);
    }

    public List<BoardCmtVo> selCmt(BoardCmtDto dto) {
        return mapper.selCmt(dto);
    }
}
