package com.example.nottodolisttest.memo;

import com.example.nottodolisttest.member.model.MemoUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/memo")
@RequiredArgsConstructor
public class MemoController {
    private final MemoService service;

    @GetMapping
    public String getMemo(int memberId) {
        return service.selMemo(memberId);
    }

    @PatchMapping
    public int patchMemo(@RequestBody MemoUpdDto dto) {
        return service.updMemo(dto);
    }
}
