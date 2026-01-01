package com.inventorymanagementsytem.demo.exceptions;

public class ProductAlreadyExistException extends IMSException {
    public ProductAlreadyExistException() {
        super("Product Have Already Been Added");
    }
}
