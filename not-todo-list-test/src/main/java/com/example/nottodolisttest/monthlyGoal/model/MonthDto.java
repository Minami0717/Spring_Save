package com.example.nottodolisttest.monthlyGoal.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthDto {
    private int memberId;
    private String startMonth;
    private String endMonth;
}
