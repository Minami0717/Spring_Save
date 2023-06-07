package com.minami.gall.entity;

import lombok.Data;

@Data
public class Post {
    private int idx;
    private String title;
    private String content;
    private String writer;
    private String date;
    private int hits;
    private int recommend;
    private int decommend;
    private String pw;
    private int replyNum;
    private int gall_idx;
    private String member_id;
}
