package com.green.jpaexam.product.model;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class ProductRes {
    private Long number;
    private String name;
    private int price;
    private int stock;
    private String providerNm;
    private String categoryNm;
    private String description;
    private LocalDateTime createdAt;

    @QueryProjection
    public ProductRes(Long number, String name, int price, int stock, String providerNm, String categoryNm, String description, LocalDateTime createdAt) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.providerNm = providerNm;
        this.categoryNm = categoryNm;
        this.description = description;
        this.createdAt = createdAt;
    }
}
