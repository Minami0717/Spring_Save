package com.green.todoapp;

import com.green.todoapp.model.TodoEntity;
import com.green.todoapp.model.TodoInsDto;
import com.green.todoapp.model.TodoVo;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import({TodoService.class})
class TodoServiceTest {

    @MockBean
    private TodoMapper mapper;

    @Autowired
    private TodoService service;

    @Test
    @DisplayName("TodoService - Todo 등록")
    void insTodo() {
        when(mapper.insTodo(any(TodoEntity.class))).thenReturn(1);

        TodoInsDto dto = new TodoInsDto();
        dto.setCtnt("내용 입력");
        int result = service.insTodo(dto);

        assertEquals(0, result);

        verify(mapper).insTodo(any(TodoEntity.class));
    }

    @Test
    @DisplayName("TodoService - Todo 조회")
    void selTodo() {
        //given
        List<TodoVo> mockList = new ArrayList<>();
        mockList.add(new TodoVo(1, "test", "2023-06-13", null, 1, "2023-05-05"));
        mockList.add(new TodoVo(2, "test2", "2023-06-15", "abc.jpg", 0, null));

        //when
        when(mapper.selTodo()).thenReturn(mockList);
        List<TodoVo> result = service.selTodo();

        //then
        assertEquals(mockList, result);
        verify(mapper).selTodo();
    }
}