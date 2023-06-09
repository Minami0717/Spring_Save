package com.minami.gall1.model;

import lombok.Data;

@Data
public class PostSelDto {
    private int gallId;
    private int page;
    private int listNum;
    private int startIdx;
}
