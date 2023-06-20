package com.example.boardpractice.user;

import com.example.boardpractice.board.BoardService;
import com.example.boardpractice.cmt.CmtService;
import com.example.boardpractice.cmt.model.CmtEntity;
import com.example.boardpractice.user.model.*;
import com.example.boardpractice.utils.CommonUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import({UserService.class})
class UserServiceTest {
    @MockBean
    private UserMapper mapper;
    @MockBean
    private CommonUtils utils;
    @MockBean
    private BoardService boardService;
    @MockBean
    private CmtService cmtService;

    @Autowired
    private UserService service;


    @Test
    @DisplayName("UserService - User 등록")
    void insUser() {
        //when
        when(mapper.insUser(any())).thenReturn(1);
        when(utils.encodeSha256(any())).thenReturn("pw");
        int result = service.insUser(new UserInsDto());

        //then
        assertEquals(1, result);

        verify(mapper).insUser(any());
    }

    @Test
    @DisplayName("UserService - User 로그인")
    void login() {
        //when
        when(mapper.selUserByUid(any())).thenReturn(new UserVo(1,"id","w","nm",'g',"ad",
                "mp","30","33"));
        when(utils.encodeSha256(any())).thenReturn("pw");
        int result = service.login(new UserLoginDto());

        //then
        assertEquals(3, result);

        verify(mapper).selUserByUid(any());
    }

    @Test
    @DisplayName("UserService - User 비밀번호 수정")
    void updUserPw() {
        //when
        when(mapper.updUserPw(any())).thenReturn(1);
        int result = service.updUserPw(new UserUpdPwDto());

        //then
        assertEquals(1, result);

        verify(mapper).updUserPw(any());
    }

    @Test
    @DisplayName("UserService - User 탈퇴")
    void delUser() throws Exception {
        //when
        when(mapper.delUser(any())).thenReturn(1);
        when(mapper.checkIuser(any())).thenReturn(new UserVo(1,"id","w","nm",'g',"ad",
                "mp","30","33"));

        int result = service.delUser(new UserDelDto());

        //then
        assertEquals(1, result);

        verify(mapper).delUser(any());
    }

    @Test
    @DisplayName("UserService - User 사진 수정")
    void updUserPic() throws IOException {
        //given
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

        //when
        when(mapper.updUserPic(any())).thenReturn(1);
        int result = service.updUserPic(pic, new UserUpdPicDto());

        //then
        assertEquals(1, result);

        verify(mapper).updUserPic(any());
    }
}