package com.example.nottodolisttest.monthlyGoal;

import com.example.nottodolisttest.main.model.SaveCostDataVo;
import com.example.nottodolisttest.monthlyGoal.model.MonthDto;
import com.example.nottodolisttest.monthlyGoal.model.MonthlyGoalInsDto;
import com.example.nottodolisttest.monthlyGoal.model.MonthlyGoalUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/monthly-goal")
@RequiredArgsConstructor
public class MonthlyGoalController {
    private final MonthlyGoalService service;

    @PostMapping
    public int postMonthlyGoal(@RequestBody MonthlyGoalInsDto dto) {
        return service.insMonthlyGoal(dto);
    }

    @PutMapping
    public int putMonthlyGoal(@RequestBody MonthlyGoalUpdDto dto) {
        return service.updMonthlyGoal(dto);
    }
    @GetMapping("/save-data")
    public SaveCostDataVo getData(@RequestParam(defaultValue = "2023-07") String startMonth,
                                  @RequestParam(defaultValue = "2023-07") String endMonth) {
        MonthDto dto = new MonthDto(startMonth, endMonth);
        return service.selSaveCostData(dto);
    }
    @DeleteMapping
    public int delMonthlyGoal(@RequestParam int goalId) {
        return service.delMonthlyGoal(goalId);
    }


}
