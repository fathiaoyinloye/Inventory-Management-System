package com.inventorymanagementsytem.demo.controllers;


import com.inventorymanagementsytem.demo.dtos.requests.AddProductRequest;
import com.inventorymanagementsytem.demo.dtos.requests.DeleteProductRequest;
import com.inventorymanagementsytem.demo.dtos.requests.ViewSingleProductRequest;
import com.inventorymanagementsytem.demo.exceptions.*;
import com.inventorymanagementsytem.demo.services.interfaces.ProductAdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/productAdmin")
@AllArgsConstructor
public class ProductAdminController {
    private final ProductAdminService productAdminService;

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody AddProductRequest request) {
        try {
            return ResponseEntity.status(CREATED).body(productAdminService.addProduct(request));
        } catch (ProductAlreadyExistException e) {
            return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());
        } catch (PriceCannotBeLessThanOneException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (QuantityLessThanOneException e) {
            return ResponseEntity.status(NOT_ACCEPTABLE).body(e.getMessage());

        } catch (EmptyInputException e) {
            return ResponseEntity.status(NO_CONTENT).body(e.getMessage());

        }

    }

    @GetMapping("/viewAllProducts")
    public ResponseEntity<?> viewAllProducts() {
        try {
            return ResponseEntity.status(OK).body(productAdminService.viewAllProducts());
        } catch (NoProductException e) {
            return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());

        }
    }

    @GetMapping("/viewSingleProduct")
    public ResponseEntity<?> viewSingleProduct(@RequestBody ViewSingleProductRequest request) {
        try {
            return ResponseEntity.status(OK).body(productAdminService.viewSingleProduct(request));
        } catch (ProductDoesNotExistException e) {
            return ResponseEntity.status(BAD_REQUEST).body(e.getMessage());

        }
    }

    @DeleteMapping ("/deleteAProduct")
    public void deleteAProduct(@RequestBody DeleteProductRequest deleteProductRequest) {
        productAdminService.deleteAProduct(deleteProductRequest);
    }


    }
