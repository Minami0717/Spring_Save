package com.example.nottodolisttest.useList;

import com.example.nottodolisttest.monthlyGoal.MonthlyGoalMapper;
import com.example.nottodolisttest.useList.model.UseListUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UseListService {
    private final UseListMapper mapper;
    private final MonthlyGoalMapper goalMapper;

    public int updUseList(UseListUpdDto dto) {
        goalMapper.updSaveCost(dto);
        return mapper.updUseList(dto);
    }
}
