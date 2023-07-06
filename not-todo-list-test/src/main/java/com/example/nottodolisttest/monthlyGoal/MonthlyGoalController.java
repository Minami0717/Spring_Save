package com.example.nottodolisttest.monthlyGoal;

import com.example.nottodolisttest.monthlyGoal.model.SaveCostDataVo;
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

    //날짜 수정?
    @PutMapping
    public int putMonthlyGoal(@RequestBody MonthlyGoalUpdDto dto) {
        return service.updMonthlyGoal(dto);
    }

    @DeleteMapping
    public int delMonthlyGoal(@RequestParam int goalId) {
        return service.delMonthlyGoal(goalId);
    }

    @GetMapping
    @Operation(summary = "회원별 월간누적목표 조회")
    public List<MonthlyGoalDetailVo> getMonthlyGoalByMemberId(int memberId) {
        return service.selMonthlyGoalByMemberId(memberId);
    }

    @GetMapping("/save-data")
    @Operation(summary = "절약 비용 데이터 조회")
    public SaveCostDataVo getSaveData(MonthDto dto) {
        return service.selSaveCostData(dto);
    }
}
