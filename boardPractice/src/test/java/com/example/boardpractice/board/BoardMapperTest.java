package com.example.boardpractice.board;

import com.example.boardpractice.board.model.BoardEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

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
    void selBoard() {
    }

    @Test
    void selBoardCount() {
    }

    @Test
    void selBoardById() {
    }

    @Test
    void delBoard() {
    }

    @Test
    void updBoard() {
    }

    @Test
    void selIboardByIuser() {
    }
}