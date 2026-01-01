package com.inventorymanagementsytem.demo.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class AddProductResponse {

    private String name;
    private BigDecimal price;
    private int quantity;
    private String productId;
    private String time;

}
