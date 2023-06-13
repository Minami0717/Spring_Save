package com.green.todoapp;

import com.green.todoapp.model.TodoInsDto;
import com.green.todoapp.model.TodoVo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
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

@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TodoService service;

    @Test
    @DisplayName("TODO - 등록")
    void postTodo() throws Exception {
        //given - 테스트 세팅
        given(service.insTodo(any(TodoInsDto.class))).willReturn(3);

        //when - 실제 실행
        String json = "{ \"ctnt\": \"work\" }";

        ResultActions ra = mvc.perform(post("/api/todo")
                    .content(json)
                    .contentType(MediaType.APPLICATION_JSON));

        //then - 검증
        ra.andExpect(status().isOk())
        .andExpect(content().string("3"))
        .andDo(print());

        verify(service).insTodo(any());
    }

    @Test
    @DisplayName("TODO - 조회")
    void getTodo() throws Exception {
        //given - 테스트 세팅
        List<TodoVo> mockList = new ArrayList<>();
        mockList.add(new TodoVo(1, "test", "2023-06-13", null, 1, "2023-05-05"));
        mockList.add(new TodoVo(2, "test2", "2023-06-15", "abc.jpg", 0, null));

        given(service.selTodo()).willReturn(mockList);

        //when - 실제 실행
        ResultActions ra = mvc.perform(get("/api/todo"));

        //then - 검증
        ra.andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(mockList.size())))
                .andExpect(jsonPath("$[*].itodo").exists())
                .andExpect(jsonPath("$[0].itodo").value(1))
                .andExpect(jsonPath("$[0].ctnt").value("test"))
                .andDo(print());

        verify(service).selTodo();
    }
}