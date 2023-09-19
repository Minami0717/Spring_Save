package com.green.jpaexam.product.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProductSelAllParam {
    private String productName;
    private Integer price;
}
