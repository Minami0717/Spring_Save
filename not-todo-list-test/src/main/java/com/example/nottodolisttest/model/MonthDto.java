package com.example.nottodolisttest.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthDto {
    private String startMonth;
    private String endMonth;
}
