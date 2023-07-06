package com.example.nottodolisttest.useList;

import com.example.nottodolisttest.useList.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UseListMapper {
    int insUseList(UseListDto dto);
    int updUseList(UseListDto dto);
    List<UseListMonthVo> selMonthlyUseList(String yearMonth);
    List<UseListDailyVo> selDailyUseList(String day);
}
