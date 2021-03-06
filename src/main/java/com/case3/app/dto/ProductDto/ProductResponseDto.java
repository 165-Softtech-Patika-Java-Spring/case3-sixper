package com.case3.app.dto.ProductDto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponseDto {

    private Long id;
    private String name;
    private BigDecimal price;
}
