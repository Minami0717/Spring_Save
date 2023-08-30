package com.green.jpaexam.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.green.jpaexam.config.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_provider")
@Data
@ToString(callSuper = true)
@SuperBuilder
@NoArgsConstructor
public class ProviderEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint unsigned", updatable = false)
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "providerEntity", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private List<ProductEntity> productEntityList = new ArrayList<>();
}
