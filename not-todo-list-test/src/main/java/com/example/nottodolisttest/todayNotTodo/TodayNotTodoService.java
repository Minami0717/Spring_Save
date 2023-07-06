package com.example.nottodolisttest.todayNotTodo;

import com.example.nottodolisttest.monthlyGoal.MonthlyGoalMapper;
import com.example.nottodolisttest.monthlyGoal.model.MonthlyGoalVo;
import com.example.nottodolisttest.useList.UseListMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodayNotTodoService {
    private final MonthlyGoalMapper monthlyGoalMapper;
    private final UseListMapper useListMapper;

    public List<MonthlyGoalVo> selTodayGoal() {
        return monthlyGoalMapper.selTodayGoal();
    }
}
