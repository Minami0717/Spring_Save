package com.example.nottodolisttest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MonthlyGoalVo {
    private int goalId;
    private String name;
    private int goalCost;
    private String monthYear;
}
