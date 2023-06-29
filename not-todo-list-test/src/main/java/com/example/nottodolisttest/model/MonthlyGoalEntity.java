package com.example.nottodolisttest.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MonthlyGoalEntity {
    private int goalId;
    private int notTodoId;
    private int costCategory;
    private int goalCost;
    private String monthYear;
    private int saveCost;
}
