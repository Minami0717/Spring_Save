package com.example.nottodolisttest.calender;

import com.example.nottodolisttest.useList.UseListMapper;
import com.example.nottodolisttest.useList.model.UseListDailyVo;
import com.example.nottodolisttest.useList.model.UseListMonthVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalenderService {
    private final UseListMapper mapper;

    public List<UseListMonthVo> selMonthlyUseList(String yearMonth) {
        return mapper.selMonthlyUseList(yearMonth);
    }

    public List<UseListDailyVo> selDailyUseList(String date) {
        List<UseListDailyVo> list = mapper.selDailyUseList(date);
        for (UseListDailyVo vo : list) {
            vo.setCostCategory(vo.getCostCategoryId() == 1 ? "돈" : "시간");
        }
        return list;
    }
}
