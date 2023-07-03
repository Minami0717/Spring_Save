package com.example.nottodolisttest.main;

import com.example.nottodolisttest.main.model.MainPageDto;
import com.example.nottodolisttest.main.model.MainPageVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main")
@RequiredArgsConstructor
public class MainController {
    private final MainService service;

    @GetMapping
    public MainPageVo getMainData(MainPageDto dto) {
        return service.getMainData(dto);
    }
}
