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
    int selNotTodoId(String name);
}
