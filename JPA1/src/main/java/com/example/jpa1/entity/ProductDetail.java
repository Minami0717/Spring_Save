package com.example.jpa1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetail {
    @Id //PK
    @Column(name = "product_number", updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_number", updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private ProductEntity productEntity;

    @Column(length = 500)
    private String description;
}
