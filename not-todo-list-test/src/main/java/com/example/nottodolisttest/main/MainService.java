package com.example.nottodolisttest.main;

import com.example.nottodolisttest.member.MemberMapper;
import com.example.nottodolisttest.member.model.MemberEntity;
import com.example.nottodolisttest.member.model.MemberInsDto;
import com.example.nottodolisttest.member.model.MemoUpdDto;
import com.example.nottodolisttest.monthlyGoal.MonthlyGoalMapper;
import com.example.nottodolisttest.monthlyGoal.model.MonthlyGoalVo;
import com.example.nottodolisttest.useList.UseListMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MainService {
    private final MemberMapper memoMapper;
    private final MonthlyGoalMapper goalMapper;
    private final UseListMapper useListMapper;

    public int insMember(MemberInsDto dto) {
        MemberEntity entity = new MemberEntity();
        entity.setNickname(dto.getNickname());
        memoMapper.insMember(entity);

        return entity.getMemberId();
    }

    public String selMember(int memberId) {
        return memoMapper.selMember(memberId);
    }

    public String selMemo(int memberId) {
        return memoMapper.selMemo(memberId);
    }

    public int updMemo(MemoUpdDto dto) {
        return memoMapper.updMemo(dto);
    }

    public List<MonthlyGoalVo> selTodayGoal() {
        return goalMapper.selTodayGoal();
    }
}
