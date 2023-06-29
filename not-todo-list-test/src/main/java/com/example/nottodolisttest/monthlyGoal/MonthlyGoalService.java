package com.example.nottodolisttest.monthlyGoal;

import com.example.nottodolisttest.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonthlyGoalService {
    private final MonthlyGoalMapper mapper;

    public int insMonthlyGoal(MonthlyGoalInsDto dto) {
        int notTodoId = mapper.selNotTodoId(dto.getNotTodo());
        if (notTodoId == 0) {
            NotTodoEntity entity = new NotTodoEntity();
            entity.setName(dto.getNotTodo());
            mapper.insNotTodo(entity);
        }

        int costCategory = 1;
        int goalCost = dto.getGoalCost();

        if ("시간".equals(dto.getCostCategory())) {
            String[] s = dto.getMonthYear().split("-");
            Calendar c = Calendar.getInstance();
            c.set(Integer.parseInt(s[0]), Integer.parseInt(s[1]) - 1, 1);
            int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);

            costCategory = 2;
            goalCost = goalCost * lastDay;
        }

        MonthlyGoalEntity goalEntity = MonthlyGoalEntity.builder()
                .goalCost(goalCost)
                .costCategory(costCategory)
                .monthYear(dto.getMonthYear())
                .notTodoId(notTodoId)
                .build();

        return mapper.insMonthlyGoal(goalEntity) > 0 ? goalEntity.getGoalId() : 0;
    }

    public int updMonthlyGoal(MonthlyGoalUpdDto dto) {
        int notTodoId = mapper.selNotTodoId(dto.getNotTodo());
        if (notTodoId == 0) {
            NotTodoEntity entity = new NotTodoEntity();
            entity.setName(dto.getNotTodo());
            mapper.insNotTodo(entity);
        }

        MonthlyGoalEntity goalEntity = MonthlyGoalEntity.builder()
                .goalCost(dto.getGoalCost())
                .costCategory("돈".equals(dto.getCostCategory()) ? 1 : 2)
                .notTodoId(notTodoId)
                .goalId(dto.getGoalId())
                .build();

        return mapper.updMonthlyGoal(goalEntity);
    }

    public List<MonthlyGoalVo> selMonthlyGoal(String monthYear) {
        return mapper.selMonthlyGoal(monthYear);
    }
}
