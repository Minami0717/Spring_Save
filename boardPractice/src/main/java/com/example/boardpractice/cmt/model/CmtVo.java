package com.example.boardpractice.cmt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CmtVo {
    private int iboardCmt;
    private int iboard;
    private int iuser;
    private String ctnt;
    private String writer;
    private String writerMainPic;
    private String createdAt;
}
