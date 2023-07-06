package com.example.nottodolisttest.monthlyGoal;

import com.example.nottodolisttest.main.model.SaveCostDataVo;
import com.example.nottodolisttest.monthlyGoal.model.MonthDto;
import com.example.nottodolisttest.monthlyGoal.model.MonthlyGoalDetailVo;
import com.example.nottodolisttest.monthlyGoal.model.MonthlyGoalInsDto;
import com.example.nottodolisttest.monthlyGoal.model.MonthlyGoalUpdDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping
    public int delMonthlyGoal(@RequestParam int goalId) {
        return service.delMonthlyGoal(goalId);
    }

    @GetMapping
    @Operation(summary = "누적목표 조회")
    public List<MonthlyGoalDetailVo> getMonthlyGoal() {
        return service.selMonthlyGoalAll();
    }


}
