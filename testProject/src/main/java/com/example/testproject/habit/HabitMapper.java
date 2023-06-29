package com.example.testproject.habit;

import com.example.testproject.model.HabitInsDto;
import com.example.testproject.model.HabitVo;
import com.example.testproject.model.UseDto;
import com.example.testproject.model.UseVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HabitMapper {
    int insHabit(HabitInsDto dto);
    List<HabitVo> selHabit();
    int insUseList(UseDto dto);
    List<UseVo> selUseList();
}
