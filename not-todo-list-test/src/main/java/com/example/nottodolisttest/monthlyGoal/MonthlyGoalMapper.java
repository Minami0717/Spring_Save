package com.example.nottodolisttest.monthlyGoal;

import com.example.nottodolisttest.monthlyGoal.model.MonthDto;
import com.example.nottodolisttest.monthlyGoal.model.MonthlyGoalDetailVo;
import com.example.nottodolisttest.monthlyGoal.model.MonthlyGoalEntity;
import com.example.nottodolisttest.monthlyGoal.model.MonthlyGoalVo;
import com.example.nottodolisttest.main.model.MaxSaveMoneyVo;
import com.example.nottodolisttest.main.model.MaxSaveTimeVo;
import com.example.nottodolisttest.main.model.NotTodoEntity;
import com.example.nottodolisttest.useList.model.UseListUpdDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MonthlyGoalMapper {
    int insMonthlyGoal(MonthlyGoalEntity entity);
    int updMonthlyGoal(MonthlyGoalEntity entity);
    int insNotTodo(NotTodoEntity entity);
    List<MonthlyGoalVo> selTodayGoal();
    List<MonthlyGoalDetailVo> selMonthlyGoalAll();
    int delMonthlyGoal(int goalId);
    MaxSaveMoneyVo selMaxSaveMoney();
    MaxSaveTimeVo selMaxSaveTime();
    Integer selSumSaveMoney(MonthDto dto);
    Integer selSumSaveTime(MonthDto dto);
    int updSaveCost(UseListUpdDto dto);

}
