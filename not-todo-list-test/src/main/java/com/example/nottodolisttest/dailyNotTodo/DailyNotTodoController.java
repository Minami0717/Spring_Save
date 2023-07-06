package com.example.nottodolisttest.dailyNotTodo;

import com.example.nottodolisttest.useList.model.UseListDailyVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/daily-not-todo")
@RequiredArgsConstructor
public class DailyNotTodoController {
    private final DailyNotTodoService service;

    @GetMapping
    public List<UseListDailyVo> getDailyNotTodo(String day) {
        return service.selDailyUseList(day);
    }

//    @PatchMapping
//    public int patchDailyUseList(@RequestBody UseListUpdDto dto) {
//        return service.updUseList(dto);
//    }
}
