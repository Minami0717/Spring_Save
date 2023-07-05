package com.example.nottodolisttest.todayNotTodo;

import com.example.nottodolisttest.monthlyGoal.model.MonthlyGoalVo;
import com.example.nottodolisttest.useList.model.UseListUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/today-not-todo")
@RequiredArgsConstructor
public class TodayNotTodoController {
    private final TodayNotTodoService service;

    @GetMapping
    public List<MonthlyGoalVo> getTodayNotTodo() {
        return service.selTodayGoal();
    }

    @PatchMapping
    public int patchTodayNotTodo(@RequestBody UseListUpdDto dto) {
        return service.updTodayNotTodo(dto);
    }
}
