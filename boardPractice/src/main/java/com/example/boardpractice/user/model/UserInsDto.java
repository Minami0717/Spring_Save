package com.example.boardpractice.user.model;

import lombok.Data;

@Data
public class UserInsDto {
    private String uid;
    private String upw;
    private String nm;
    private String addr;
    private Gender gender;
}