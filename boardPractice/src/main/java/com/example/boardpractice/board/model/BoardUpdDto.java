package com.example.boardpractice.board.model;

import lombok.Data;

@Data
public class BoardUpdDto {
    private int iboard;
    private String title;
    private String ctnt;
    private int iuser;
}
