package com.example.boardpractice.board.model;

import com.example.boardpractice.cmt.model.CmtRes;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class BoardDetailRes {
    private BoardDetailVo board;
    private CmtRes cmt;
}
