package com.example.boardpractice.board;

import com.example.boardpractice.board.model.*;
import com.example.boardpractice.cmt.model.CmtRes;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(BoardController.class)
class BoardControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private BoardService service;

    @Test
    @DisplayName("BoardController - 등록")
    void postBoard() throws Exception {
        //given - 테스트 세팅
        given(service.insBoard(any())).willReturn(1);

        //when - 실제 실행
        BoardInsDto dto = new BoardInsDto();
        dto.setTitle("title");
        dto.setCtnt("work");
        dto.setIuser(5);

        Gson gson = new Gson();
        String json = gson.toJson(dto);

        ResultActions ra = mvc.perform(post("/board")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));

        //then - 검증
        ra.andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());

        verify(service).insBoard(any());
    }

    @Test
    @DisplayName("BoardController - 조회")
    void getBoard() throws Exception {
        //given - 테스트 세팅
        List<BoardVo> mockList = new ArrayList<>();
        mockList.add(new BoardVo(1,"title","writer","2022", "a.jpg"));
        mockList.add(new BoardVo(2,"title2","write2r","20222", "a2.jpg"));
        given(service.selBoard(any())).willReturn(mockList);

        Gson gson = new Gson();
        String json = gson.toJson(mockList);

        //when - 실제 실행
        ResultActions ra = mvc.perform(get("/board?page=1&row=40"));

        //then - 검증
        ra.andExpect(status().isOk())
                .andExpect(content().json(json))
                .andDo(print());

        verify(service).selBoard(any());
    }

    @Test
    @DisplayName("BoardController - 최대 페이지값 조회")
    void getMaxpage() throws Exception {
        //given - 테스트 세팅
        given(service.getMaxpage(any())).willReturn(10);

        //when - 실제 실행
        ResultActions ra = mvc.perform(get("/board/maxpage?row=20"));

        //then - 검증
        ra.andExpect(status().isOk())
                .andExpect(content().string("10"))
                .andDo(print());

        verify(service).getMaxpage(any());
    }

    @Test
    @DisplayName("BoardController - Board 상세 정보 조회")
    void getBoardById() throws Exception {
        //given - 테스트 세팅
        BoardDetailVo vo = new BoardDetailVo(1,"title", "ctnt","writer","2022", "a.jpg");
        BoardDetailRes res = BoardDetailRes.builder()
                .board(vo)
                .cmt(CmtRes.builder()
                        .isMore(1)
                        .row(5)
                        .maxPage(5)
                        .list(new ArrayList<>())
                        .build())
                .build();

        Gson gson = new Gson();
        String json = gson.toJson(res);

        given(service.selBoardById(any())).willReturn(res);

        //when - 실제 실행
        ResultActions ra = mvc.perform(get("/board/1"));

        //then - 검증
        ra.andExpect(status().isOk())
                .andExpect(content().json(json))
                .andDo(print());

        verify(service).selBoardById(any());
    }

    @Test
    @DisplayName("BoardController - Board 삭제")
    void delBoard() throws Exception {
        //given - 테스트 세팅
        given(service.delBoard(any())).willReturn(1);

        //when - 실제 실행
        BoardDelDto dto = new BoardDelDto();
        dto.setIuser(5);
        dto.setIboard(6);

        Gson gson = new Gson();
        String json = gson.toJson(dto);

        ResultActions ra = mvc.perform(delete("/board")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));

        //then - 검증
        ra.andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());

        verify(service).delBoard(any());
    }

    @Test
    @DisplayName("BoardController - Board 수정")
    void putBoard() throws Exception {
        //given - 테스트 세팅
        given(service.updBoard(any())).willReturn(1);

        //when - 실제 실행
        BoardUpdDto dto = new BoardUpdDto();
        dto.setIuser(5);
        dto.setIboard(6);
        dto.setCtnt("update");
        dto.setTitle("title");

        Gson gson = new Gson();
        String json = gson.toJson(dto);

        ResultActions ra = mvc.perform(put("/board")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));

        //then - 검증
        ra.andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());

        verify(service).updBoard(any());
    }
}