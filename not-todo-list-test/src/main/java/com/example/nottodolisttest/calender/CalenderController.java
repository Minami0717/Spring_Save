package com.example.nottodolisttest.calender;

import com.example.nottodolisttest.useList.model.UseListDailyVo;
import com.example.nottodolisttest.useList.model.UseListMonthVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calender")
@RequiredArgsConstructor
public class CalenderController {
    private final CalenderService service;

    @GetMapping
    public List<UseListMonthVo> getMonthlyUseList(String yearMonth) {
        return service.selMonthlyUseList(yearMonth);
    }

    @GetMapping("/{date}")
    public List<UseListDailyVo> getDailyUseList(@PathVariable String date) {
        return service.selDailyUseList(date);
    }
}
