package com.green.todotestapp;

import com.green.todotestapp.model.TodoRes;
import com.green.todotestapp.utils.MyFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockPart;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MvcResult;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
public class TodoIntegrationTest extends IntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Value("${file.dir}")
    private String fileDir;

    @Test
    @Rollback(value = false)
    public void postTodo() throws Exception {
        String originalFileNm = "9084c915-39f8-410f-9934-22ac5b573426.png";
        String contentType = "png";
        String filePath = "D:/home/download/todo/18/" + originalFileNm;
        FileInputStream fileInputStream = new FileInputStream(filePath);

        MockMultipartFile pic = new MockMultipartFile("pic", originalFileNm, contentType, fileInputStream);

        MvcResult mr = mvc.perform(multipart("/api/todo")
                        .file(pic)
                        .part(new MockPart("ctnt", "test1".getBytes(StandardCharsets.UTF_8)))
                )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String content = mr.getResponse().getContentAsString();
        TodoRes todoRes = om.readValue(content, TodoRes.class);
        log.info("todoRes : {}", todoRes);

        String dicPath = MyFileUtils.getAbsolutePath(fileDir + "/todo/" + todoRes.getItodo());
        File dicFile = new File(dicPath);
        assertTrue(dicFile.exists(), "1번 폴더가 없음");

        File picFile = new File(dicPath, todoRes.getPic());
        assertTrue(picFile.exists(), "1번 이미지가 없음");
        assertEquals("test1", todoRes.getCtnt());


        MvcResult mr2 = mvc.perform(multipart("/api/todo")
                        .file(pic)
                        .part(new MockPart("ctnt", "test2".getBytes(StandardCharsets.UTF_8)))
                )
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        String content2 = mr2.getResponse().getContentAsString();
        TodoRes todoRes2 = om.readValue(content2, TodoRes.class);
        log.info("todoRes2 : {}", todoRes2);

        String dicPath2 = MyFileUtils.getAbsolutePath(fileDir + "/todo/" + todoRes2.getItodo());
        File dicFile2 = new File(dicPath2);
        assertTrue(dicFile2.exists(), "2번 폴더가 없음");

        File picFile2 = new File(dicPath2, todoRes2.getPic());
        assertTrue(picFile2.exists(), "2번 이미지가 없음");
        assertEquals("test2", todoRes2.getCtnt());
    }
}
