package com.minami.gall1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class GallVo {
    private int id;
    private String name;
    private String category;
    private String typeId;
    private String intro;
    private String admin;
    private String subAdmin;
    private LocalDate createdAt;
    private String image;
}
