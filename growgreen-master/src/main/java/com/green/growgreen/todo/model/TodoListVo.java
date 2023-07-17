package com.green.growgreen.todo.model;

import lombok.Data;

@Data
public class TodoListVo {
    private int itodo;
    private String ctnt;
    private String deadlineDate;
    private String deadlineTime;
    private String nickNm;
    private String nm;
    private int finishYn;
    private String repeatDay;
}
