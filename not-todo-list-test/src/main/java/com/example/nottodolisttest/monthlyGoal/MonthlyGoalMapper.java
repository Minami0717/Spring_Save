package com.example.nottodolisttest.monthlyGoal;

import com.example.nottodolisttest.monthlyGoal.model.*;
import com.example.nottodolisttest.monthlyGoal.model.NotTodoEntity;
import com.example.nottodolisttest.useList.model.UseListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MonthlyGoalMapper {
    int insMonthlyGoal(MonthlyGoalEntity entity);
    int updMonthlyGoal(MonthlyGoalEntity entity);
    int insNotTodo(NotTodoEntity entity);
    List<MonthlyGoalVo> selTodayGoal();
    List<MonthlyGoalDetailVo> selMonthlyGoalByMemberId(int memberId);
    int delMonthlyGoal(int goalId);
    MaxSaveCostVo selMaxSaveMoney(int memberId);
    MaxSaveCostVo selMaxSaveTime(int memberId);
    Integer selSumSaveMoney(MonthDto dto);
    Integer selSumSaveTime(MonthDto dto);
    int updSaveCost(UseListDto dto);

}
