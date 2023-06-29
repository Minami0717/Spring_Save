package com.example.nottodolisttest.monthlyGoal;

import com.example.nottodolisttest.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonthlyGoalService {
    private final MonthlyGoalMapper mapper;

    public int insMonthlyGoal(MonthlyGoalInsDto dto) {
        NotTodoEntity entity = new NotTodoEntity();
        entity.setName(dto.getNotTodo());

        try {
            mapper.insNotTodo(entity);
        } catch (Exception e) {
            return 0;
        }

        MonthlyGoalEntity goalEntity = MonthlyGoalEntity.builder()
                .goalCost(dto.getGoalCost())
                .costCategory("돈".equals(dto.getCostCategory()) ? 1 : 2)
                .monthYear(dto.getMonthYear())
                .notTodoId(entity.getNotTodoId())
                .build();

        return mapper.insMonthlyGoal(goalEntity) > 0 ? goalEntity.getGoalId() : 0;
    }

    public int updMonthlyGoal(MonthlyGoalUpdDto dto) {
        String notTodo = mapper.selNotTodo(dto.getNotTodo());
        if (notTodo == null) {
            NotTodoEntity entity = new NotTodoEntity();
            entity.setName(dto.getNotTodo());
            mapper.insNotTodo(entity);
        }

        return mapper.updMonthlyGoal(dto);
    }

    public List<MonthlyGoalVo> selMonthlyGoal(String monthYear) {
        return mapper.selMonthlyGoal(monthYear);
    }
}
