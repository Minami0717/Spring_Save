package com.example.nottodolisttest.calender.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CalenderVo {
    private String date;
    private List<String> notTodo;
}
