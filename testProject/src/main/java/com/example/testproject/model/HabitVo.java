package com.example.testproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class HabitVo {
    private int habitId;
    private String name;
    private int monthCost;
    private int dayTime;
    private LocalDateTime inputTime;
}
