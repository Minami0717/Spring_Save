package com.example.boardpractice.cmt;

import com.example.boardpractice.board.BoardMapper;
import com.example.boardpractice.board.model.BoardInsDto;
import com.example.boardpractice.cmt.model.*;
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
@Import({CmtService.class})
class CmtServiceTest {
    @MockBean
    private CmtMapper mapper;

    @Autowired
    private CmtService service;

    @Test
    @DisplayName("CmtService - Cmt 등록")
    void insCmt() {
        //when
        when(mapper.insCmt(any())).thenReturn(1);
        int result = service.insCmt(new CmtEntity());

        //then
        assertEquals(0, result);

        verify(mapper).insCmt(any());
    }

    @Test
    @DisplayName("CmtService - Cmt 수정")
    void updCmt() {
        //when
        when(mapper.updCmt(any())).thenReturn(1);
        int result = service.updCmt(new CmtEntity());

        //then
        assertEquals(1, result);

        verify(mapper).updCmt(any());
    }

    @Test
    @DisplayName("CmtService - Cmt 삭제")
    void delCmt() {
        //when
        when(mapper.delCmt(any())).thenReturn(1);
        int result = service.delCmt(new CmtDelDto());

        //then
        assertEquals(1, result);

        verify(mapper).delCmt(any());
    }

    @Test
    @DisplayName("CmtService - Cmt 조회")
    void selCmt() {
        //given
        List<CmtVo> mockList = new ArrayList<>();
        mockList.add(new CmtVo(1,2,3,"cmt","writer",null,"2022"));
        mockList.add(new CmtVo(2,22,33,"cmt1","writer1",null,"2023"));

        CmtRes mockRes = CmtRes.builder()
                .list(mockList)
                .maxPage(3)
                .isMore(1)
                .row(5)
                .build();

        CmtSelDto dto = new CmtSelDto();
        dto.setPage(1);
        dto.setRow(5);

        //when
        when(mapper.selCmt(any())).thenReturn(mockList);
        when(mapper.selCmtCount(anyInt())).thenReturn(15);
        CmtRes result = service.selCmt(dto);

        //then
        assertEquals(mockRes, result);

        verify(mapper).selCmt(any());
    }
}