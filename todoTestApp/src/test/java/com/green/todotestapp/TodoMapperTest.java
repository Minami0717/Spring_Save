package com.green.todotestapp;

import com.green.todotestapp.model.TodoInsDto;
import com.green.todotestapp.model.TodoUpdDto;
import com.green.todotestapp.model.TodoVo;
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
class TodoMapperTest {

    @Autowired
    private TodoMapper mapper;

    @Test
    void insTodo() {
//        TodoInsDto p1 = new TodoInsDto();
//        p1.setCtnt("test1");
//        p1.setPic("main.jpg");
//
//        int r1 = mapper.insTodo(p1);
//        assertEquals(1, r1);
//        assertEquals(3, p1.getItodo());
//
//        TodoInsDto p2 = new TodoInsDto();
//        p2.setCtnt("test2");
//
//        int r2 = mapper.insTodo(p2);
//        assertEquals(1, r2);
//        assertEquals(4, p2.getItodo());
//
//        List<TodoVo> list = mapper.selTodo();
//        assertEquals(4, list.size());
//
//        TodoVo item3 = list.get(2);
//        assertEquals(p1.getCtnt(), item3.getCtnt());
//        assertEquals(p1.getPic(), item3.getPic());
//
//        TodoVo item4 = list.get(3);
//        assertEquals(p2.getCtnt(), item4.getCtnt());
//        assertEquals(p2.getPic(), item4.getPic());
    }

    @Test
    void selTodo() {
        List<TodoVo> list = mapper.selTodo();
        assertEquals(2, list.size());

        TodoVo item1 = list.get(0);
        assertEquals(1, item1.getItodo());
        assertEquals("string", item1.getCtnt());
        assertEquals("2023-06-13T16:50:38", item1.getCreatedAt().toString());

        TodoVo item2 = list.get(1);
        assertEquals(2, item2.getItodo());
        assertEquals("string1", item2.getCtnt());
        assertEquals("2023-06-13T16:50:39", item2.getCreatedAt().toString());
    }

    @Test
    void updTodo() {
        TodoUpdDto dto1 = TodoUpdDto.builder()
                .itodo(1L)
                .ctnt("update")
                .pic("pic.jpg")
                .build();

        TodoUpdDto dto2 = TodoUpdDto.builder()
                .itodo(2L)
                .ctnt("update1")
                .build();

        int result1 = mapper.updTodo(dto1);
        assertEquals(1, result1);

        int result2 = mapper.updTodo(dto2);
        assertEquals(1, result2);

        List<TodoVo> list = mapper.selTodo();

        TodoVo item0 = list.get(0);
        assertEquals(dto1.getCtnt(), item0.getCtnt());
        assertEquals(dto1.getPic(), item0.getPic());

        TodoVo item1 = list.get(1);
        assertEquals(dto2.getCtnt(), item1.getCtnt());
        assertEquals(dto2.getPic(), item1.getPic());
    }
}