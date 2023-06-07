package com.minami.gall1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Post {
    @Id
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
    private int gallIdx;
    private String memberId;
}
