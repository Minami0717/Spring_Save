package com.minami.gall1.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PageVo {
    private int nowPage;
    private int maxPage;
    private int postCount;
    private int listNum;
}
