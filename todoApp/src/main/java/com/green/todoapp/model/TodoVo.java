package com.green.todoapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoVo {
    private int itodo;
    private String ctnt;
    private String createdAt;
    private int delYn;
    private String pic;
}
