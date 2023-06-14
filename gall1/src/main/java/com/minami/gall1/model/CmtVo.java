package com.minami.gall1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class CmtVo {
    private int id;
    private String content;
    private int postId;
    private String writer;
    private LocalDateTime createdAt;
}
