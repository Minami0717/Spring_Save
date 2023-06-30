package com.example.nottodolisttest.useList;

import com.example.nottodolisttest.model.UseListInsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/use-list")
@RequiredArgsConstructor
public class UseListController {
    private final UseListService service;

//    @PostMapping
//    public int postUseList(@RequestBody List<UseListInsDto> dto) {
//        return service.insUseList(dto);
//    }
}
