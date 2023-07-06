package com.example.nottodolisttest.monthlyGoal.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class MonthlyGoalDetailVo {
    private final int goalId;
    private final String startDate;
    private final String notTodo;
    private final int costCategoryId;
    private final String goalCost;
    private String costCategory;

    public void setCostCategory(String costCategory) {
        this.costCategory = costCategory;
    }
}
