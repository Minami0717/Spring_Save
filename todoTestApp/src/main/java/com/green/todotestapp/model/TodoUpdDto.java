package com.green.todotestapp.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoUpdDto {
    private Long itodo;
    private String ctnt;
    private String pic;
}
