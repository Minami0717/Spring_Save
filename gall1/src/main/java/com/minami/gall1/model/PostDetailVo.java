package com.minami.gall1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class PostDetailVo {
    private final int id;
    private final int gallId;
    private final String title;
    private final String content;
    private final String writer;
    private final String createdAt;
    private final int hits;
    private final int recoNum;
    private final int decoNum;
    private final String pw;
    private int cmtNum;
    private List<CmtVo> cmt;

    public void setCmtNum(int cmtNum) {
        this.cmtNum = cmtNum;
    }

    public void setCmt(List<CmtVo> cmt) {
        this.cmt = cmt;
    }
}
