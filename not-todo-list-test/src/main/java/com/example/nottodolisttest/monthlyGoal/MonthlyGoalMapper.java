package com.example.nottodolisttest.monthlyGoal;

import com.example.nottodolisttest.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MonthlyGoalMapper {
    int insMonthlyGoal(MonthlyGoalEntity entity);
    int updMonthlyGoal(MonthlyGoalEntity entity);
    int insNotTodo(NotTodoEntity entity);
    List<MonthlyGoalVo> selMonthlyGoal(String monthYear);
    Integer selNotTodoId(String name);
    int delMonthlyGoal(int goalId);
    MaxSaveMoneyVo selMaxSaveMoney();
    MaxSaveTimeVo selMaxSaveTime();
    int selSumSaveMoney(MonthDto dto);
    int selSumSaveTime(MonthDto dto);
}
