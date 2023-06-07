package com.example.boardpractice.board.model;

import com.example.boardpractice.cmt.model.CmtVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Builder
public class BoardDetailVo {
    private int iboard;
    private String title;
    private String ctnt;
    private String writer;
    private String createdAt;
    private String writerMainPic;
}
