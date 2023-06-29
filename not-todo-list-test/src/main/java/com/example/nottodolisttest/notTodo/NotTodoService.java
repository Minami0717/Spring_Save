package com.example.nottodolisttest.notTodo;

import com.example.nottodolisttest.memo.MemoMapper;
import com.example.nottodolisttest.model.MainPageDto;
import com.example.nottodolisttest.model.MainPageVo;
import com.example.nottodolisttest.monthlyGoal.MonthlyGoalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotTodoService {
    private final MemoMapper memoMapper;
    private final MonthlyGoalMapper goalMapper;

    public MainPageVo getMainData(MainPageDto dto) {
        return MainPageVo.builder()
                .memo(memoMapper.selMemo())
                .goalList(goalMapper.selMonthlyGoal(dto.getMonthYear()))
                .build();
    }
}
