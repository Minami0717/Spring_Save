package com.example.nottodolisttest.member;

import com.example.nottodolisttest.member.model.MemberEntity;
import com.example.nottodolisttest.member.model.MemberInsDto;
import com.example.nottodolisttest.member.model.MemoUpdDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    String selMemo(int memberId);
    int updMemo(MemoUpdDto dto);
    int insMember(MemberEntity entity);
    String selMember(int memberId);
}
