package com.green.jpaexam.product.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    @Schema(description = "상품 이름", example = "상품")
    private String name;
    private int price;
    private int stock;
    private String description;
    private Long categoryId;
    private Long providerId;
}
