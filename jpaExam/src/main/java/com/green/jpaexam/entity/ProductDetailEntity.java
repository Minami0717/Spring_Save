package com.green.jpaexam.entity;

import com.green.jpaexam.config.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "t_product_detail")
@Data
@SuperBuilder
@NoArgsConstructor
public class ProductDetailEntity extends BaseEntity {
    @Id
    private Long productId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "product_id", columnDefinition = "bigint unsigned")
    private ProductEntity productEntity;

    private String description;
}
