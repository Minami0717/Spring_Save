package com.example.boardpractice.user;

import com.example.boardpractice.user.model.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insUser(UserInsDto dto);
    UserVo selUserByUid(UserLoginDto dto);
    int updUserPw(UserUpdPwDto dto);
    int delUser(UserDelDto dto);
    int updUserPic(UserUpdPicDto dto);
    UserVo checkIuser(UserDelDto dto);
}
