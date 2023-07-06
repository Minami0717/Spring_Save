package com.example.nottodolisttest.useList;

import com.example.nottodolisttest.monthlyGoal.MonthlyGoalMapper;
import com.example.nottodolisttest.useList.model.UseListDailyVo;
import com.example.nottodolisttest.useList.model.UseListDto;
import com.example.nottodolisttest.useList.model.UseListMonthVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UseListService {
    private final UseListMapper mapper;
    private final MonthlyGoalMapper goalMapper;

    public int insUseList(UseListDto dto) {
        mapper.insUseList(dto);
        return goalMapper.updSaveCost(dto);
    }

    public int updUseList(UseListDto dto) {
        return mapper.updUseList(dto);
    }

    public List<UseListMonthVo> selMonthlyUseList(String yearMonth) {
        return mapper.selMonthlyUseList(yearMonth);
    }

    public List<UseListDailyVo> selDailyUseList(String day) {
        return mapper.selDailyUseList(day);
    }
}
