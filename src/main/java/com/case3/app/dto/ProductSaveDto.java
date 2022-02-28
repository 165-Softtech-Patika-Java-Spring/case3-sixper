package com.case3.app.dto;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;


@Data
public class ProductSaveDto {

    private String name;
    private BigDecimal price;

}
