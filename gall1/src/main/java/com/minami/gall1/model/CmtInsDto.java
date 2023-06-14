package com.minami.gall1.model;

import lombok.Data;

@Data
public class CmtInsDto {
    private String content;
    private int postId;
    private String writer;
    private String pw;
    private int gallId;
}
