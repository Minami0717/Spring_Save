package com.example.boardpractice.board;

import com.example.boardpractice.board.model.*;
import com.example.boardpractice.cmt.CmtMapper;
import com.example.boardpractice.cmt.CmtService;
import com.example.boardpractice.cmt.model.CmtDelDto;
import com.example.boardpractice.cmt.model.CmtRes;
import com.example.boardpractice.cmt.model.CmtSelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
    private final BoardMapper mapper;
    private final CmtService cmtService;

    @Autowired
    public BoardService(BoardMapper mapper, CmtService cmtService) {
        this.mapper = mapper;
        this.cmtService = cmtService;
    }

    public int insBoard(BoardInsDto dto) {
        BoardEntity entity = new BoardEntity();
        entity.setTitle(dto.getTitle());
        entity.setCtnt(dto.getCtnt());
        entity.setIuser(dto.getIuser());
        int result = mapper.insBoard(entity);

        if (result == 1) {
            return entity.getIboard();
        }
        return result;
    }

    public List<BoardVo> selBoard(BoardSelDto dto) {
        dto.setStartIdx((dto.getPage() - 1) * dto.getRow());
        return mapper.selBoard(dto);
    }

    public int getMaxpage(BoardRowDto dto) {
        BoardCntVo vo = mapper.selBoardCount();

        int cnt = vo.getCnt();
        int row = dto.getRow();
        int maxPage = cnt / row;

        if (cnt % row != 0) {
            return maxPage + 1;
        }

        return maxPage;
    }

    public BoardDetailRes selBoardById(BoardIdDto dto) {
        BoardDetailVo board = mapper.selBoardById(dto);

        CmtSelDto cmtDto = new CmtSelDto();
        cmtDto.setRow(5);
        cmtDto.setPage(1);
        cmtDto.setIboard(dto.getIboard());

        CmtRes cmt = cmtService.selCmt(cmtDto);

        return BoardDetailRes.builder()
                .board(board)
                .cmt(cmt)
                .build();
    }

    @Transactional(rollbackFor = Exception.class)
    public int delBoard(BoardDelDto dto) throws Exception {
        CmtDelDto cmtDto = new CmtDelDto();
        cmtDto.setIboard(dto.getIboard());
        cmtService.delCmt(cmtDto);

        int result = mapper.delBoard(dto);
        if (result == 0) {
            throw new Exception("삭제 권한 없음");
        }

        return result;
    }

    public int updBoard(BoardUpdDto dto) {
        return mapper.updBoard(dto);
    }

    public List<Integer> selIboardByIuser(int iuser) {
        return mapper.selIboardByIuser(iuser);
    }
}
