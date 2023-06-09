package com.minami.gall1.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostVo {
    private int id;
    private String title;
    private String writer;
    private LocalDateTime createdAt;
    private int hits;
    private int recoNum;
    private int cmtNum;

    public PostVo(int id, String title, String writer, LocalDateTime createdAt, int hits, int recoNum) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.createdAt = createdAt;
        this.hits = hits;
        this.recoNum = recoNum;
    }

    public void setCmtNum(int cmtNum) {
        this.cmtNum = cmtNum;
    }
}
