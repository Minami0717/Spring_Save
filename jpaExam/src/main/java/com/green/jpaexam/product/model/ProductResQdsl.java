package com.green.jpaexam.product.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductResQdsl {
    private long number;
    private String name;
    private int price;
    private int stock;
    private String providerNm;
    private String categoryNm;
    private String description;
    private LocalDateTime createdAt;
    private long totalCnt;
}
