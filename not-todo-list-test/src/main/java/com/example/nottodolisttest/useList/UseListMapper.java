package com.example.nottodolisttest.useList;

import com.example.nottodolisttest.useList.model.UseListDailyVo;
import com.example.nottodolisttest.useList.model.UseListInsDto;
import com.example.nottodolisttest.useList.model.UseListUpdByGoalIdDto;
import com.example.nottodolisttest.useList.model.UseListMonthVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UseListMapper {
    int insUseList(List<UseListInsDto> dto);
    int updUseList(UseListUpdByGoalIdDto dto);
    List<UseListMonthVo> selUseListByMonth(String yearMonth);
    List<UseListDailyVo> selUseListByDay(String day);
}
