package com.example.testproject.model;

import lombok.Data;

@Data
public class HabitInsDto {
    private String name;
    private int monthCost;
    private int dayTime;
    private int categoryId;
}
