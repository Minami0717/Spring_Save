package com.example.testproject.habit;

import com.example.testproject.model.HabitInsDto;
import com.example.testproject.model.HabitVo;
import com.example.testproject.model.UseDto;
import com.example.testproject.model.UseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {
    private final HabitMapper mapper;

    @Autowired
    public HabitService(HabitMapper mapper) {
        this.mapper = mapper;
    }

    public int insHabit(HabitInsDto dto) {
        return mapper.insHabit(dto);
    }

    public List<HabitVo> selHabit() {
        return mapper.selHabit();
    }

    public int insUseList(UseDto dto) {
        return mapper.insUseList(dto);
    }

    public List<UseVo> selUseList() {
        return mapper.selUseList();
    }
}
