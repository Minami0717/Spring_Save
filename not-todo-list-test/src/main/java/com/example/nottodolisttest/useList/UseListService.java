package com.example.nottodolisttest.useList;

import com.example.nottodolisttest.monthlyGoal.MonthlyGoalMapper;
import com.example.nottodolisttest.useList.model.UseListDailyVo;
import com.example.nottodolisttest.useList.model.UseListUpdByGoalIdDto;
import com.example.nottodolisttest.useList.model.UseListMonthVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UseListService {
    private final UseListMapper mapper;
    private final MonthlyGoalMapper goalMapper;

    public int updUseListByGoalId(UseListUpdByGoalIdDto dto) {
        goalMapper.updSaveCost(dto);
        return mapper.updUseList(dto);
    }

    public List<UseListMonthVo> selUseListByMonth(String yearMonth) {
        return mapper.selUseListByMonth(yearMonth);
    }

    public List<UseListDailyVo> selUseListByDay(String day) {
        List<UseListDailyVo> list = mapper.selUseListByDay(day);
        for (UseListDailyVo vo : list) {
            vo.setCostCategory(vo.getCostCategoryId() == 1 ? "돈" : "시간");
        }
        return list;
    }
}
