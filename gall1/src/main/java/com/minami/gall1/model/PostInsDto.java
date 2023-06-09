package com.minami.gall1.model;

import lombok.Data;

@Data
public class PostInsDto {
    private int gallId;
    private String title;
    private String content;
    private String writer;
    private String pw;
}
