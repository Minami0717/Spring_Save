package com.example.nottodolisttest.monthlyGoal.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MonthlyGoalEntity {
    private int goalId;
    private int memberId;
    private int notTodoId;
    private int costCategory;
    private int goalCost;
    private String monthYear;
    private int saveCost;
}
