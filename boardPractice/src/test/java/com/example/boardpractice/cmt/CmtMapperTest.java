package com.example.boardpractice.cmt;

import com.example.boardpractice.board.BoardMapper;
import com.example.boardpractice.board.model.BoardEntity;
import com.example.boardpractice.cmt.model.CmtDelDto;
import com.example.boardpractice.cmt.model.CmtEntity;
import com.example.boardpractice.cmt.model.CmtSelDto;
import com.example.boardpractice.cmt.model.CmtVo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CmtMapperTest {
    @Autowired
    private CmtMapper mapper;

    @Test
    @DisplayName("CmtMapper - Cmt 등록")
    void insCmt() {
        //given
        CmtEntity entity = new CmtEntity();
        entity.setIboard(2);
        entity.setCtnt("test");
        entity.setIuser(5);

        //when
        int result = mapper.insCmt(entity);

        //then
        assertEquals(7, entity.getIboardCmt());
        assertEquals(1, result);
    }

    @Test
    @DisplayName("CmtMapper - Cmt 수정")
    void updCmt() {
        //given
        CmtEntity entity = new CmtEntity();
        entity.setIboardCmt(2);
        entity.setCtnt("test");
        entity.setIuser(2);

        //when
        int result = mapper.updCmt(entity);

        //then
        assertEquals(1, result);
    }

    @Test
    @DisplayName("CmtMapper - Cmt 삭제")
    void delCmt() {
        //given
        CmtDelDto dto = new CmtDelDto();
        dto.setIboardCmt(2);
        dto.setIuser(2);

        //when
        int result = mapper.delCmt(dto);

        //then
        assertEquals(1, result);
    }

    @Test
    @DisplayName("CmtMapper - Cmt 조회")
    void selCmt() {
        //given
        CmtSelDto dto = new CmtSelDto();
        dto.setIboard(2);
        dto.setStartIdx(0);
        dto.setRow(5);

        //when
        List<CmtVo> result = mapper.selCmt(dto);

        //then
        assertEquals(3, result.size());
        assertEquals("댓글수정", result.get(1).getCtnt());
    }

    @Test
    @DisplayName("CmtMapper - Cmt Count 조회")
    void selCmtCount() {
        //when
        int result = mapper.selCmtCount(1);

        //then
        assertEquals(3, result);
    }
}