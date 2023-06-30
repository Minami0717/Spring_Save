package com.example.nottodolisttest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SaveStatsVo {
    private String maxMoneyMonth;
    private int maxSaveMoney;
    private String maxTimeMonth;
    private int maxSaveTime;
    private int sumSaveMoney;
    private int sumSaveTime;
}
