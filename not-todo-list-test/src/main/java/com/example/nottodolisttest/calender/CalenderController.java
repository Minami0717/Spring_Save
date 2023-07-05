package com.example.nottodolisttest.calender;

import com.example.nottodolisttest.useList.model.UseListMonthVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/calender")
@RequiredArgsConstructor
public class CalenderController {
    private final CalenderService service;

    @GetMapping
    public List<UseListMonthVo> getCalender(String yearMonth) {
        return service.selMonthlyUseList(yearMonth);
    }
}
