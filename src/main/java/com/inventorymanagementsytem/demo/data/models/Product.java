package com.inventorymanagementsytem.demo.data.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long Id;
    private int count;
    private String productId;
    private String name;
    private BigDecimal price;
    private String description;
    private int quantity;
    private String time;


    public BigDecimal getPrice(){
        return price.setScale(2, RoundingMode.HALF_UP);
    }

    public void setProductId(){
        productId = "ID" + (getCount() + 1) ;
        count++;
    }



}