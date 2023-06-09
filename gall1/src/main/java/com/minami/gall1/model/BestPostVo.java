package com.minami.gall1.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class BestPostVo {
    private int id;
    private int gallId;
    private String title;
    private String gallName;
    private LocalDateTime createdAt;
    private int cmtNum;

    public BestPostVo(int id, int gallId, String title, String gallName, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.gallName = gallName;
        this.createdAt = createdAt;
        this.gallId = gallId;
    }

    public void setCmtNum(int cmtNum) {
        this.cmtNum = cmtNum;
    }
}
