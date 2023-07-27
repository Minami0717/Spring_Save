package com.green.todotestapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
public class TodoRes {
    private Long itodo;
    private String ctnt;
    private String pic;
    private LocalDateTime createdAt;
    private int finishYn;

    public TodoRes(TodoInsDto dto) {
        itodo = dto.getItodo();
        ctnt = dto.getCtnt();
        pic = dto.getPic();
        createdAt = LocalDateTime.now();
    }
}
