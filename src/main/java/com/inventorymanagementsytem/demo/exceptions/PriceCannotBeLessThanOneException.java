package com.inventorymanagementsytem.demo.exceptions;

public class PriceCannotBeLessThanOneException extends IMSException {
    public PriceCannotBeLessThanOneException() {
        super("Price cannot be less than one");
    }
}
