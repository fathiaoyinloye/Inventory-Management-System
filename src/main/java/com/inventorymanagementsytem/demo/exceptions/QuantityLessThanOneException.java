package com.inventorymanagementsytem.demo.exceptions;

public class QuantityLessThanOneException extends RuntimeException {
    public QuantityLessThanOneException() {
        super("Quantity Cannot Be Less Than One");
    }
}
