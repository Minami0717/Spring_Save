package com.example.boardpractice.user;

import com.example.boardpractice.cmt.model.CmtEntity;
import com.example.boardpractice.user.model.*;
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
class UserMapperTest {
    @Autowired
    private UserMapper mapper;

    @Test
    @DisplayName("UserMapper - User 등록")
    void insUser() {
        //given
        UserInsDto dto = new UserInsDto();
        dto.setUid("id");
        dto.setAddr("ad");
        dto.setNm("nm");
        dto.setUpw("pw");
        dto.setGender(Gender.F);

        //when
        int result = mapper.insUser(dto);

        //then
        assertEquals(1, result);
    }

    @Test
    @DisplayName("UserMapper - User Id로 User 조회")
    void selUserByUid() {
        //given
        UserLoginDto dto = new UserLoginDto();
        dto.setUid("str");
        dto.setUpw("pw");

        //when
        UserVo user = mapper.selUserByUid(dto);

        //then
        assertEquals("woojin", user.getNm());
    }

    @Test
    @DisplayName("UserMapper - User 비밀번호 수정")
    void updUserPw() {
        //given
        UserUpdPwDto dto = new UserUpdPwDto();
        dto.setIuser(3);
        dto.setUpw("pw");

        //when
        int result = mapper.updUserPw(dto);

        //then
        assertEquals(1, result);
    }

//    @Test
//    @DisplayName("UserMapper - User 탈퇴")
//    void delUser() {
//        //given
//        UserDelDto dto = new UserDelDto();
//        dto.setIuser(2);
//        dto.setUpw("dod");
//
//        //when
//        int result = mapper.delUser(dto);
//
//        //then
//        assertEquals(1, result);
//    }

    @Test
    @DisplayName("UserMapper - User 사진 수정")
    void updUserPic() {
        //given
        UserUpdPicDto dto = new UserUpdPicDto();
        dto.setIuser(3);
        dto.setMainPic("pic.jpg");

        //when
        int result = mapper.updUserPic(dto);

        //then
        assertEquals(1, result);
    }

    @Test
    @DisplayName("UserMapper - User 확인")
    void checkIuser() {
        //given
        UserDelDto dto = new UserDelDto();
        dto.setIuser(2);
        dto.setUpw("dod");

        //when
        UserVo user = mapper.checkIuser(dto);

        //then
        assertEquals("gyujin", user.getNm());
    }
}