package com.example.nottodolisttest.todayNotTodo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/today-not-todo")
@RequiredArgsConstructor
public class TodayNotTodoController {
    private final TodayNotTodoService service;

//    @GetMapping
//    public List<MonthlyGoalVo> getTodayNotTodo() {
//        return service.selTodayGoal();
//    }
//
//    @PatchMapping
//    public int patchTodayNotTodo(@RequestBody UseListUpdDto dto) {
//        return service.updTodayNotTodo(dto);
//    }
}
