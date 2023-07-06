package com.example.nottodolisttest.monthlyGoal.model;

import com.example.nottodolisttest.monthlyGoal.model.MaxSaveCostVo;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaveCostDataVo {
    private MaxSaveCostVo maxSaveMoney;
    private MaxSaveCostVo maxSaveTime;
    private Integer sumSaveMoney;
    private Integer sumSaveTime;
}
