package com.example.nottodolisttest.model;

import lombok.Data;

@Data
public class MonthlyGoalUpdDto {
    private String notTodo;
    private String costCategory;
    private int goalCost;
    private int goalId;
}
