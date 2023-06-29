package com.example.nottodolisttest.monthlyGoal;

import com.example.nottodolisttest.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MonthlyGoalMapper {
    int insMonthlyGoal(MonthlyGoalEntity entity);
    int updMonthlyGoal(MonthlyGoalUpdDto dto);
    int insNotTodo(NotTodoEntity entity);
    List<MonthlyGoalVo> selMonthlyGoal(String monthYear);
    String selNotTodo(String name);
}
