package com.example.nottodolisttest.main;

import com.example.nottodolisttest.member.model.MemberInsDto;
import com.example.nottodolisttest.member.model.MemoUpdDto;
import com.example.nottodolisttest.monthlyGoal.model.MonthlyGoalVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "메인 페이지")
public class MainController {
    private final MainService service;

    @PostMapping("/member")
    @Operation(summary = "회원 등록(이미 존재하는 회원일 경우 id값 리턴)")
    public int postMember(@RequestBody MemberInsDto dto) {
        return service.insMember(dto);
    }

    @GetMapping("/member")
    @Operation(summary = "회원 닉네임 조회")
    public String getMember(int memberId) {
        return service.selMember(memberId);
    }

    @GetMapping("/memo")
    @Operation(summary = "한줄 메모 조회")
    public String getMemo(int memberId) {
        return service.selMemo(memberId);
    }

    @PatchMapping("/memo")
    @Operation(summary = "한줄 메모 수정")
    public int patchMemo(@RequestBody MemoUpdDto dto) {
        return service.updMemo(dto);
    }

    @GetMapping("/today-not-todo")
    public List<MonthlyGoalVo> getTodayNotTodo() {
        return service.selTodayGoal();
    }

//    @PatchMapping("/today-not-todo")
//    public int patchTodayNotTodo(@RequestBody UseListUpdDto dto) {
//        return service.updTodayNotTodo(dto);
//    }
}
