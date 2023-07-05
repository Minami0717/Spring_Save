package com.example.nottodolisttest.useList.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UseListDailyVo {
    private final int useListId;
    private final int goalId;
    private final String notTodo;
    private final int costCategoryId;
    private final int useCost;
    private String costCategory;

    public void setCostCategory(String costCategory) {
        this.costCategory = costCategory;
    }
}
