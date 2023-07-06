package com.example.nottodolisttest.useList;

import com.example.nottodolisttest.useList.model.UseListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/use-list")
@RequiredArgsConstructor
public class UseListController {
    private final UseListService service;

    @PostMapping
    public int postUseList(@RequestBody UseListDto dto) {
        return service.insUseList(dto);
    }
}
