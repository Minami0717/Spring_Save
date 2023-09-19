package com.minami.gallproject.entity;

import com.minami.gallproject.config.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ColumnDefault;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class User extends BaseEntity {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private Long userId;

    @Column(nullable = false, length = 50)
    private String code;

    @Column(nullable = false)
    private String pw;

    @Column(nullable = false, length = 50)
    private String nick;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, columnDefinition = "tinyint unsigned")
    private int fixedYn;

    @Column(nullable = false, columnDefinition = "tinyint unsigned")
    @ColumnDefault("0")
    private int delYn;
}
