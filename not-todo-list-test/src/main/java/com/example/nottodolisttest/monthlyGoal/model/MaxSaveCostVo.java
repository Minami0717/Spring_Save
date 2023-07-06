package com.example.nottodolisttest.monthlyGoal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MaxSaveCostVo {
    private String yearMonth;
    private Integer maxSaveCost;
}
