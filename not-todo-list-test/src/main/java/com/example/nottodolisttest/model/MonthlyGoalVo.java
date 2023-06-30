package com.example.nottodolisttest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class MonthlyGoalVo {
    private final int goalId;
    private final String name;
    private final int goalCost;
    private int sumCost;
    private final String monthYear;
}
