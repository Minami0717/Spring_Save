package com.example.boardpractice.board.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BoardSelDto {
    private int startIdx;
    private int page;
    private int row;
}
