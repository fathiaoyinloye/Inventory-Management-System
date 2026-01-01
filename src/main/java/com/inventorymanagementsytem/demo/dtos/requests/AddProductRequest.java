package com.inventorymanagementsytem.demo.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@AllArgsConstructor
public class AddProductRequest {
    private String name;
    private BigDecimal price;
    private String description;
    private int quantity;

    public BigDecimal getPrice(){
        return price.setScale(2, RoundingMode.HALF_UP);
    }

}

