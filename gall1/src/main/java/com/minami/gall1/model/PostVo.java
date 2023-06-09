package com.minami.gall1.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class PostVo {
    private final int id;
    private final String title;
    private final String writer;
    private final LocalDateTime createdAt;
    private final int hits;
    private final int recoNum;
    private int cmtNum;

    public void setCmtNum(int cmtNum) {
        this.cmtNum = cmtNum;
    }
}
