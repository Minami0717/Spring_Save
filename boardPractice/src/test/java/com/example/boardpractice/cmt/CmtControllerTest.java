package com.example.boardpractice.cmt;

import com.example.boardpractice.board.BoardController;
import com.example.boardpractice.board.BoardService;
import com.example.boardpractice.board.model.BoardDelDto;
import com.example.boardpractice.board.model.BoardInsDto;
import com.example.boardpractice.board.model.BoardUpdDto;
import com.example.boardpractice.board.model.BoardVo;
import com.example.boardpractice.cmt.model.CmtInsDto;
import com.example.boardpractice.cmt.model.CmtRes;
import com.example.boardpractice.cmt.model.CmtUpdDto;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CmtController.class)
class CmtControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CmtService service;

    @Test
    @DisplayName("CmtController - 등록")
    void postCmt() throws Exception {
        //given - 테스트 세팅
        given(service.insCmt(any())).willReturn(1);

        //when - 실제 실행
        CmtInsDto dto = new CmtInsDto();
        dto.setCtnt("work");
        dto.setIuser(5);

        Gson gson = new Gson();
        String json = gson.toJson(dto);

        ResultActions ra = mvc.perform(post("/board/3/cmt")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));

        //then - 검증
        ra.andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());

        verify(service).insCmt(any());
    }

    @Test
    @DisplayName("CmtController - Cmt 수정")
    void putCmt() throws Exception {
        //given - 테스트 세팅
        given(service.updCmt(any())).willReturn(1);

        //when - 실제 실행
        CmtUpdDto dto = new CmtUpdDto();
        dto.setIuser(5);
        dto.setCtnt("update");

        Gson gson = new Gson();
        String json = gson.toJson(dto);

        ResultActions ra = mvc.perform(put("/board/cmt/8")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));

        //then - 검증
        ra.andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());

        verify(service).updCmt(any());
    }

    @Test
    @DisplayName("CmtController - Cmt 삭제")
    void delCmt() throws Exception {
        //given - 테스트 세팅
        given(service.delCmt(any())).willReturn(1);

        //when - 실제 실행
        ResultActions ra = mvc.perform(delete("/board/cmt/3")
                .param("iuser", "6"));

        //then - 검증
        ra.andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());

        verify(service).delCmt(any());
    }

    @Test
    @DisplayName("CmtController - Cmt 조회")
    void getCmt() throws Exception {
        //given - 테스트 세팅
        CmtRes res = CmtRes.builder()
                .row(5)
                .maxPage(3)
                .isMore(1)
                .list(new ArrayList<>())
                .build();

        given(service.selCmt(any())).willReturn(res);

        Gson gson = new Gson();
        String json = gson.toJson(res);

        //when - 실제 실행
        ResultActions ra = mvc.perform(get("/board/4/cmt")
                .param("page", "1")
                .param("row", "5"));

        //then - 검증
        ra.andExpect(status().isOk())
                .andExpect(content().json(json))
                .andDo(print());

        verify(service).selCmt(any());
    }
}