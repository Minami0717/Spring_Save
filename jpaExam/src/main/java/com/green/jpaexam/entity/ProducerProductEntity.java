package com.green.jpaexam.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_producer_product")
@Data
public class ProducerProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, columnDefinition = "bigint unsigned")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    private ProducerEntity producerEntity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
}
