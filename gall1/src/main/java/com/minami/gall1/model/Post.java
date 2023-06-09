package com.minami.gall1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Post {
    @Id
    private int id;
    private String title;
    private String content;
    private String writer;
    private String createdAt;
    private int hits;
    private int recoNum;
    private int decoNum;
    private String pw;
    private int gallId;
}
