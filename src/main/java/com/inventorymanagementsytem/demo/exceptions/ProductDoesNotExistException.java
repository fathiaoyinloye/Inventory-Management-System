package com.inventorymanagementsytem.demo.exceptions;

public class ProductDoesNotExistException extends IMSException {
    public ProductDoesNotExistException() {
        super("Product Does Not Exist Exception");
    }
}
