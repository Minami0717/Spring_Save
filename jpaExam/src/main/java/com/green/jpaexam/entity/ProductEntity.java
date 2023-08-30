package com.green.jpaexam.entity;

import com.green.jpaexam.config.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.commons.lang3.builder.ToStringExclude;

@Data
@Table(name = "t_product")
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "bigint unsigned")
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private ProviderEntity providerEntity;

    @OneToOne(mappedBy = "productEntity", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private ProductDetailEntity productDetailEntity;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    public void setProductDetailEntity(ProductDetailEntity entity) {
        if (productDetailEntity != null) {
            productDetailEntity.setProductEntity(null);
        }
        productDetailEntity = entity;
        productDetailEntity.setProductEntity(this);
    }
}
