package com.example.jpa1.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "provider")
@Data
public class ProviderEntity extends BaseEntity {
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)//auto_increment
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private Long id;

    private String name;
}
