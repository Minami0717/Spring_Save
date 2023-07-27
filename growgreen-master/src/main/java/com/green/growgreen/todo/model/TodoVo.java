package com.green.growgreen.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class TodoVo {
    private int itodo;
    private String ctnt;
    private String deadlineDate;
    private String deadlineTime;
    private String nickNm;
    private String nm;
    private int finishYn;
}
