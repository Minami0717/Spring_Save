package com.example.boardpractice.user;

import com.example.boardpractice.cmt.model.CmtInsDto;
import com.example.boardpractice.user.model.*;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;

    @Test
    @DisplayName("UserController - 등록")
    void postUser() throws Exception {
        //given - 테스트 세팅
        given(service.insUser(any())).willReturn(1);

        //when - 실제 실행
        UserInsDto dto = new UserInsDto();
        dto.setUpw("11");
        dto.setNm("name");
        dto.setAddr("addr");
        dto.setGender(Gender.F);
        dto.setUid("id");

        Gson gson = new Gson();
        String json = gson.toJson(dto);

        ResultActions ra = mvc.perform(post("/user")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));

        //then - 검증
        ra.andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());

        verify(service).insUser(any());
    }

    @Test
    @DisplayName("UserController - 로그인")
    void postLoginUser() throws Exception {
        //given - 테스트 세팅
        given(service.login(any())).willReturn(1);

        //when - 실제 실행
        UserLoginDto dto = new UserLoginDto();
        dto.setUpw("3");
        dto.setUid("id");

        Gson gson = new Gson();
        String json = gson.toJson(dto);

        ResultActions ra = mvc.perform(post("/user/login")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));

        //then - 검증
        ra.andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());

        verify(service).login(any());
    }

    @Test
    @DisplayName("UserController - 비밀번호 수정")
    void patchPw() throws Exception {
        //given - 테스트 세팅
        given(service.updUserPw(any())).willReturn(1);

        //when - 실제 실행
        UserUpdPwDto dto = new UserUpdPwDto();
        dto.setUpw("3");
        dto.setIuser(4);

        Gson gson = new Gson();
        String json = gson.toJson(dto);

        ResultActions ra = mvc.perform(patch("/user/pw")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));

        //then - 검증
        ra.andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());

        verify(service).updUserPw(any());
    }

    @Test
    @DisplayName("UserController - 사진 수정")
    void patchPic() throws Exception {
        //given - 테스트 세팅
        given(service.updUserPic(any(), any())).willReturn(1);

        final String fileName = "testImage1"; //파일명
        final String contentType = "png"; //파일타입
        final String filePath = "src/main/resources/testImage/"+fileName+"."+contentType; //파일경로
        FileInputStream fileInputStream = new FileInputStream(filePath);

        //Mock파일생성
        MockMultipartFile pic = new MockMultipartFile(
                "pic", //name
                fileName + "." + contentType, //originalFilename
                contentType,
                fileInputStream
        );

        //when - 실제 실행
        ResultActions ra = mvc.perform(multipart(HttpMethod.PATCH,"/user/pic")
                        .file(pic)
                        .param("iuser", "3"));

        //then - 검증
        ra.andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());

        verify(service).updUserPic(any(), any());
    }

    @Test
    @DisplayName("UserController - 회원 탈퇴")
    void delUser() throws Exception {
        //given - 테스트 세팅
        given(service.delUser(any())).willReturn(1);

        UserDelDto dto = new UserDelDto();
        dto.setUpw("3");
        dto.setIuser(4);

        Gson gson = new Gson();
        String json = gson.toJson(dto);

        //when - 실제 실행
        ResultActions ra = mvc.perform(delete("/user")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));

        //then - 검증
        ra.andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());

        verify(service).delUser(any());
    }
}