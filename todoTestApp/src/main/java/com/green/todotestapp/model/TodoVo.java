package com.green.todotestapp.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TodoVo {
    private Long itodo;
    private String ctnt;
    private LocalDateTime createdAt;
    private String pic;
    private int finishYn;
    private LocalDateTime finishedAt;
}
