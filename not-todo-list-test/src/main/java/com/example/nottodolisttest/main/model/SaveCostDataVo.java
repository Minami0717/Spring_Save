package com.example.nottodolisttest.main.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaveCostDataVo {
    private MaxSaveMoneyVo maxSaveMoney;
    private MaxSaveTimeVo maxSaveTime;
    private Integer sumSaveMoney;
    private Integer sumSaveTime;
}
