package com.minami.gall1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cmt {
    @Id
    private int id;
    private String content;
    private int postId;
    private String writer;
    private String createdAt;
}
