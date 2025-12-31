package com.inventorymanagementsytem.demo.data.repositories;

import com.inventorymanagementsytem.demo.data.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
