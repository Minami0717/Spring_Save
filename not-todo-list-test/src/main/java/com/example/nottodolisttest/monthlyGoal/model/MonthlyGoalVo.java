package com.example.nottodolisttest.monthlyGoal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class MonthlyGoalVo {
    private final int goalId;
    private final String name;
    private final int goalCost;
    private int useCostSum;
    private final String monthYear;
}
