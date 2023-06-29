package com.example.testproject.habit;

import com.example.testproject.model.HabitInsDto;
import com.example.testproject.model.HabitVo;
import com.example.testproject.model.UseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/habit")
public class HabitController {
    private final HabitService service;

    @Autowired
    public HabitController(HabitService service) {
        this.service = service;
    }

    @PostMapping
    public String postHabit(HabitInsDto dto) {
        service.insHabit(dto);
        return "redirect:/habit";
    }

    @GetMapping
    public String getHabit(Model model) {
        model.addAttribute("habitList", service.selHabit());
        model.addAttribute("useList", service.selUseList());
        return "test";
    }

    @PostMapping("/use")
    public String postUse(UseDto dto) {
        service.insUseList(dto);
        return "redirect:/habit";
    }
}
