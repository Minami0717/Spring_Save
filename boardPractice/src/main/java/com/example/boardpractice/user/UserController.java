package com.example.boardpractice.user;

import com.example.boardpractice.user.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public int postUser(@RequestBody UserInsDto dto) {
        return service.insUser(dto);
    }

    @PostMapping("/login")
    public int postLoginUser(@RequestBody UserLoginDto dto) {
        return service.login(dto);
    }

    @PatchMapping("/pw")
    public int patchPw(@RequestBody UserUpdPwDto dto) {
        return service.updUserPw(dto);
    }

    @PatchMapping(value = "/pic", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public int patchPic(@RequestPart MultipartFile pic, @RequestParam int iuser) {
        UserUpdPicDto dto = new UserUpdPicDto();
        dto.setIuser(iuser);
        return service.updUserPic(pic, dto);
    }

    @DeleteMapping
    public int delUser(@RequestBody UserDelDto dto) throws Exception {
        return service.delUser(dto);
    }
}
