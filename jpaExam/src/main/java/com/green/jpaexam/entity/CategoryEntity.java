package com.green.jpaexam.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "t_category")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, columnDefinition = "bigint unsigned")
    private Long id;

    @Column(unique = true)
    private String code;

    private String name;

    @OneToMany(mappedBy = "categoryEntity")
    private List<ProductEntity> productEntityList;
}
