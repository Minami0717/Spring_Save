package com.green.todoapp;

import com.green.todoapp.model.TodoEntity;
import com.green.todoapp.model.TodoUpdDto;
import com.green.todoapp.model.TodoVo;
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
class TodoMapperTest {

    @Autowired
    private TodoMapper mapper;

    @Test
    @DisplayName("TodoMapper - Todo 등록")
    void insTodo() {
        //given
        TodoEntity entity = new TodoEntity();
        entity.setCtnt("test");

        int result = mapper.insTodo(entity);

        assertEquals(9, entity.getItodo());
        assertEquals(1, result);
    }

    @Test
    @DisplayName("TodoMapper - Todo 조회")
    void selTodo() {
        List<TodoVo> list = mapper.selTodo();

        assertEquals(7, list.size());

        TodoVo vo = list.get(0);
        assertEquals(2, vo.getItodo());
        assertEquals("string", vo.getCtnt());
    }

    @Test
    @DisplayName("TodoMapper - Todo 완료 처리 토글")
    void updTodo() {
        TodoEntity entity = new TodoEntity();
        entity.setItodo(1);

        int result = mapper.updTodo(entity);

        assertEquals(1, result);
    }

    @Test
    @DisplayName("TodoMapper - Todo 삭제")
    void delTodo() {
        int result = mapper.delTodo(3);

        assertEquals(1, result);
    }
}