package com.example.nottodolisttest.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MainPageVo {
    private String memo;
    private List<MonthlyGoalVo> goalList;
    private SaveStatsVo saveStats;
}
