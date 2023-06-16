package com.example.boardpractice.board;

import com.example.boardpractice.board.model.*;
import com.example.boardpractice.cmt.CmtService;
import com.example.boardpractice.cmt.model.CmtRes;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import({BoardService.class})
class BoardServiceTest {

    @MockBean
    private BoardMapper mapper;
    @MockBean
    private CmtService cmtService;

    @Autowired
    private BoardService service;

    @Test
    @DisplayName("BoardService - Board 등록")
    void insBoard() {
        //given
        BoardInsDto dto = new BoardInsDto();
        dto.setIuser(1);
        dto.setTitle("title");
        dto.setCtnt("content");

        //when
        when(mapper.insBoard(any())).thenReturn(1);
        int result = service.insBoard(dto);

        //then
        assertEquals(0, result);

        verify(mapper).insBoard(any());
    }

    @Test
    @DisplayName("BoardService - Board 조회")
    void selBoard() {
        //given
        List<BoardVo> mockList = new ArrayList<>();
        mockList.add(new BoardVo(1,"title","writer","2022", "a.jpg"));
        mockList.add(new BoardVo(2,"title2","write2r","20222", "a2.jpg"));

        BoardSelDto dto = BoardSelDto.builder()
                .row(40)
                .page(1)
                .build();

        //when
        when(mapper.selBoard(any())).thenReturn(mockList);
        List<BoardVo> result = service.selBoard(dto);

        //then
        assertEquals(mockList, result);

        verify(mapper).selBoard(any());
    }

    @Test
    @DisplayName("BoardService - Board 최대 페이지 조회")
    void getMaxpage() {
        //given
        BoardCntVo vo = new BoardCntVo(100);

        BoardRowDto dto = new BoardRowDto();
        dto.setRow(30);

        //when
        when(mapper.selBoardCount()).thenReturn(vo);
        int result = service.getMaxpage(dto);

        //then
        assertEquals((int)Math.ceil((double) vo.getCnt()/dto.getRow()), result);

        verify(mapper).selBoardCount();
    }

    @Test
    @DisplayName("BoardService - id 값으로 Board 조회")
    void selBoardById() {
        //given
        BoardDetailVo vo = new BoardDetailVo(
                1,"title","ctnt", "writer","2022",null);

        CmtRes cmt = CmtRes.builder()
                .maxPage(3)
                .isMore(1)
                .row(5)
                .list(new ArrayList<>())
                .build();

        BoardDetailRes res = BoardDetailRes.builder()
                .board(vo)
                .cmt(cmt)
                .build();

        BoardIdDto idDto = new BoardIdDto();
        idDto.setIboard(1);

        //when
        when(mapper.selBoardById(any())).thenReturn(vo);
        when(cmtService.selCmt(any())).thenReturn(cmt);
        BoardDetailRes result = service.selBoardById(idDto);

        //then
        assertEquals(res, result);

        verify(mapper).selBoardById(any());
    }

    @Test
    @DisplayName("BoardService - Board 삭제")
    void delBoard() throws Exception {
        //given
        int expectedResult = 1;
        BoardDelDto dto = new BoardDelDto();
        dto.setIuser(1);
        dto.setIboard(4);

        //when
        when(mapper.delBoard(any())).thenReturn(expectedResult);
        int result = service.delBoard(dto);

        //then
        assertEquals(expectedResult, result);

        verify(mapper).delBoard(any());
    }

    @Test
    @DisplayName("BoardService - Board 수정")
    void updBoard() {
        //given
        int expectedResult = 1;
        BoardUpdDto dto = new BoardUpdDto();
        dto.setIuser(1);
        dto.setIboard(4);
        dto.setTitle("title");
        dto.setCtnt("ctnt");

        //when
        when(mapper.updBoard(any())).thenReturn(expectedResult);
        int result = service.updBoard(dto);

        //then
        assertEquals(expectedResult, result);

        verify(mapper).updBoard(any());
    }

    @Test
    @DisplayName("BoardService - iuser 값으로 iboard 조회")
    void selIboardByIuser() {
        //given
        List<Integer> mockList = new ArrayList<>();
        mockList.add(7);
        mockList.add(8);

        //when
        when(mapper.selIboardByIuser(anyInt())).thenReturn(mockList);
        List<Integer> result = service.selIboardByIuser(anyInt());

        //then
        assertEquals(mockList, result);

        verify(mapper).selIboardByIuser(anyInt());
    }
}