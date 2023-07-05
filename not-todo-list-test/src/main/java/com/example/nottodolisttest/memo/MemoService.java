package com.example.nottodolisttest.memo;

import com.example.nottodolisttest.member.MemberMapper;
import com.example.nottodolisttest.member.model.MemoUpdDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemberMapper mapper;

    public String selMemo(int memberId) {
        return mapper.selMemo(memberId);
    }

    public int updMemo(MemoUpdDto dto) {
        return mapper.updMemo(dto);
    }
}
