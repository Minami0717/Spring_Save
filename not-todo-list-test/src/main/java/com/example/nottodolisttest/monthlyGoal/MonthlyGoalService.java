package com.example.nottodolisttest.monthlyGoal;

import com.example.nottodolisttest.monthlyGoal.model.SaveCostDataVo;
import com.example.nottodolisttest.monthlyGoal.model.*;
import com.example.nottodolisttest.monthlyGoal.model.NotTodoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MonthlyGoalService {
    private final MonthlyGoalMapper mapper;

    public int insMonthlyGoal(MonthlyGoalInsDto dto) {
        NotTodoEntity entity = new NotTodoEntity();
        entity.setName(dto.getNotTodo());
        mapper.insNotTodo(entity);

        String[] s = dto.getMonthYear().split("-");
        int inputYear = Integer.parseInt(s[0]);
        int inputMonth = Integer.parseInt(s[1]);

        LocalDate now = LocalDate.now();
        int startDay = now.getDayOfMonth();

        if (now.getMonthValue() != inputMonth || now.getYear() != inputYear) { startDay = 1; }

        MonthlyGoalEntity goalEntity = MonthlyGoalEntity.builder()
                .goalCost(dto.getGoalCost())
                .costCategory("돈".equals(dto.getCostCategory()) ? 1 : 2)
                .startDate(String.format("%s-%d", dto.getMonthYear(), startDay))
                .notTodoId(entity.getNotTodoId())
                .memberId(dto.getMemberId())
                .build();

        mapper.insMonthlyGoal(goalEntity);

        return goalEntity.getGoalId();
    }

    public int updMonthlyGoal(MonthlyGoalUpdDto dto) {
        NotTodoEntity entity = new NotTodoEntity();
        entity.setName(dto.getNotTodo());
        mapper.insNotTodo(entity);

        MonthlyGoalEntity goalEntity = MonthlyGoalEntity.builder()
                .goalCost(dto.getGoalCost())
                .costCategory("돈".equals(dto.getCostCategory()) ? 1 : 2)
                .notTodoId(entity.getNotTodoId())
                .goalId(dto.getGoalId())
                .build();

        return mapper.updMonthlyGoal(goalEntity);
    }

    public int delMonthlyGoal(int goalId) {
        return mapper.delMonthlyGoal(goalId);
    }

    public List<MonthlyGoalDetailVo> selMonthlyGoalByMemberId(int memberId) {
        List<MonthlyGoalDetailVo> list = mapper.selMonthlyGoalByMemberId(memberId);
        for (MonthlyGoalDetailVo vo : list) {
            vo.setCostCategory(vo.getCostCategoryId() == 1 ? "원" : "시간");
        }
        return list;
    }

    public SaveCostDataVo selSaveCostData(MonthDto dto) {
        return new SaveCostDataVo(
                mapper.selMaxSaveMoney(dto.getMemberId()),
                mapper.selMaxSaveTime(dto.getMemberId()),
                mapper.selSumSaveMoney(dto),
                mapper.selSumSaveTime(dto));
    }
}
