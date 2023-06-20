package com.example.boardpractice.cmt.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@EqualsAndHashCode
public class CmtRes {
    private int isMore;
    private int maxPage;
    private int row;
    private List<CmtVo> list;
}
