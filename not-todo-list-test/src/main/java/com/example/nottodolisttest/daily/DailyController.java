package com.example.nottodolisttest.daily;

import com.example.nottodolisttest.useList.UseListService;
import com.example.nottodolisttest.useList.model.UseListDailyVo;
import com.example.nottodolisttest.useList.model.UseListUpdByGoalIdDto;
import com.example.nottodolisttest.useList.model.UseListUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/daily")
@RequiredArgsConstructor
public class DailyController {
    private final UseListService service;

    @GetMapping
    public List<UseListDailyVo> getDailyUseList(String day) {
        return service.selUseListByDay(day);
    }

//    @PatchMapping
//    public int patchDailyUseList(@RequestBody UseListUpdDto dto) {
//        return service.updUseList(dto);
//    }
}
