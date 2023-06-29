package com.example.nottodolisttest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MainPageVo {
    private String memo;
    private List<MonthlyGoalVo> goalList;
}
