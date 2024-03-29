package com.green.todotestapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.green.todotestapp.model.TodoInsDto;
import com.green.todotestapp.model.TodoRes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockPart;
import org.springframework.test.web.servlet.MockMvc;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@MockMvcConfig
@WebMvcTest(TodoController.class)
class TodoControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TodoService service;

    @Test
    @DisplayName("TODO - 등록")
    void postTodo() throws Exception {
        TodoInsDto dto = new TodoInsDto();
        dto.setItodo(3L);
        dto.setCtnt("테스트1");
        dto.setPic("test.jpg");

        TodoRes res = new TodoRes(dto);
        given(service.insTodo(any())).willReturn(res);

        String originalFileNm = "9084c915-39f8-410f-9934-22ac5b573426.png";
        String contentType = "png";
        String filePath = "D:/home/download/todo/18/" + originalFileNm;
        FileInputStream fileInputStream = new FileInputStream(filePath);

        MockMultipartFile pic = new MockMultipartFile("pic", originalFileNm, contentType, fileInputStream);

        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String resJson = om.writeValueAsString(res);

        mvc.perform(multipart("/api/todo")
                        .file(pic)
                        .part(new MockPart("ctnt", "test1".getBytes(StandardCharsets.UTF_8)))
                )
                .andExpect(status().isOk())
                .andExpect(content().string(resJson))
                .andDo(print());

        verify(service).insTodo(any());
    }
}