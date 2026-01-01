package com.inventorymanagementsytem.demo.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ViewAllProductResponse {
    private String productId;
    private String name;
    private BigDecimal price;
    private String description;
    private int quantity;
    private String time;
}
