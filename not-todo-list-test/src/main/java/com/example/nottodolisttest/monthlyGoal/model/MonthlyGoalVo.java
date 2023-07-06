package com.example.nottodolisttest.monthlyGoal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class MonthlyGoalVo {
    private int useListId;
    private int goalId;
    private String notTodo;
    private String goalCost;
    private String useCostSum;
    private String monthYear;
}
