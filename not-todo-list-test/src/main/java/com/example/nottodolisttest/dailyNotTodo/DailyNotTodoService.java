package com.example.nottodolisttest.dailyNotTodo;

import com.example.nottodolisttest.monthlyGoal.MonthlyGoalMapper;
import com.example.nottodolisttest.useList.UseListMapper;
import com.example.nottodolisttest.useList.model.UseListDailyVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DailyNotTodoService {
    private final UseListMapper mapper;
    private final MonthlyGoalMapper goalMapper;

    public List<UseListDailyVo> selDailyUseList(String day) {
        List<UseListDailyVo> list = mapper.selDailyUseList(day);
        for (UseListDailyVo vo : list) {
            vo.setCostCategory(vo.getCostCategoryId() == 1 ? "돈" : "시간");
        }
        return list;
    }

//    public int updUseList(UseListUpdDto dto) {
//
//        goalMapper.updSaveCost(dto);
//        return 0;
//    }
}
