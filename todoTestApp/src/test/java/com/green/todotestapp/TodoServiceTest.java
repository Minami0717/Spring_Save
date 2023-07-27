package com.green.todotestapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.green.todotestapp.configure.LocalDateTimeSerializer;
import com.green.todotestapp.model.TodoInsDto;
import com.green.todotestapp.model.TodoInsParam;
import com.green.todotestapp.model.TodoRes;
import com.green.todotestapp.model.TodoVo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import({TodoServiceImpl.class})
@TestPropertySource(properties = "file.dir=/home/download")
class TodoServiceTest {

    @MockBean
    private TodoMapper mapper;

    @Autowired
    private TodoService service;

    @Test
    void insTodo() throws Exception {
        String originalFileNm = "9084c915-39f8-410f-9934-22ac5b573426.png";
        String contentType = "png";
        String filePath = "D:/home/download/todo/18/" + originalFileNm;
        FileInputStream fileInputStream = new FileInputStream(filePath);
        MultipartFile pic = new MockMultipartFile("pic", originalFileNm, contentType, fileInputStream);

        TodoInsParam p1 = new TodoInsParam();
        p1.setCtnt("test1");
        p1.setPic(pic);

        when(mapper.insTodo(any())).thenReturn(1);

        TodoRes r1 = service.insTodo(p1);

        assertEquals(p1.getCtnt(), r1.getCtnt());

        verify(mapper).insTodo(any());
    }

    @Test
    void insTodo2() {
//        final Long VAL = 4L;
//        when(mapper.insTodo(any())).thenReturn(0);
//
//        //TodoInsDto p1 = new TodoInsDto();
//        p1.setItodo(VAL);
//
//        Long r1 = service.insTodo(p1);
//        assertEquals(0L, r1);
//
//        verify(mapper).insTodo(any());
    }

    @Test
    @DisplayName("Todo 리스트")
    void selTodo() {
        List<TodoVo> mockList = new ArrayList<>();
        mockList.add(TodoVo.builder()
                .ctnt("ctnt1")
                .pic(null)
                .finishYn(0)
                .build());
        mockList.add(TodoVo.builder()
                .ctnt("ctnt2")
                .pic("test.jpg")
                .finishYn(1)
                .build());

        when(mapper.selTodo()).thenReturn(mockList);
        List<TodoVo> result = service.selTodo();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer());
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        String resultJson = gson.toJson(result);
        String mockJson = gson.toJson(mockList);

        assertEquals(resultJson, mockJson);

        verify(mapper).selTodo();
    }

    @Test
    void updTodo() {
    }
}