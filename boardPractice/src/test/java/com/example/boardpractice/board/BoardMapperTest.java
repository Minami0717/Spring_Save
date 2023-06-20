package com.example.boardpractice.board;

import com.example.boardpractice.board.model.*;
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
class BoardMapperTest {

    @Autowired
    private BoardMapper mapper;

    @Test
    @DisplayName("BoardMapper - Board 등록")
    void insBoard() {
        //given
        BoardEntity entity = new BoardEntity();
        entity.setTitle("title");
        entity.setCtnt("test");
        entity.setIuser(5);

        //when
        int result = mapper.insBoard(entity);

        //then
        assertEquals(3, entity.getIboard());
        assertEquals(1, result);
    }

    @Test
    @DisplayName("BoardMapper - Board 조회")
    void selBoard() {
        //given
        BoardSelDto dto = BoardSelDto.builder()
                .startIdx(0)
                .row(30)
                .build();

        //when
        List<BoardVo> list = mapper.selBoard(dto);

        //then
        assertEquals(2, list.size());
        assertEquals("ㅎ", list.get(0).getTitle());
    }

    @Test
    @DisplayName("BoardMapper - Board 수 조회")
    void selBoardCount() {
        //when
        BoardCntVo vo = mapper.selBoardCount();

        //then
        assertEquals(2, vo.getCnt());
    }

    @Test
    void selBoardById() {
        //given
        BoardIdDto dto = new BoardIdDto();
        dto.setIboard(1);

        //when
        BoardDetailVo vo = mapper.selBoardById(dto);

        //then
        assertEquals("제목2", vo.getTitle());
    }

//    @Test
//    void delBoard() {
//        //given
//        BoardDelDto dto = new BoardDelDto();
//        dto.setIboard(2);
//        dto.setIuser(1);
//
//        //when
//        int result = mapper.delBoard(dto);
//
//        //then
//        assertEquals(1, result);
//    }

    @Test
    void updBoard() {
        //given
        BoardUpdDto dto = new BoardUpdDto();
        dto.setCtnt("updctnt");
        dto.setIboard(2);
        dto.setIuser(1);
        dto.setTitle("updtitle");

        //when
        int result = mapper.updBoard(dto);

        //then
        assertEquals(1, result);
    }

    @Test
    void selIboardByIuser() {
        //when
        List<Integer> list = mapper.selIboardByIuser(5);

        //then
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));
    }
}