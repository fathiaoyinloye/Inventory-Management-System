package com.inventorymanagementsytem.demo.exceptions;

public class NoProductException extends IMSException {
    public NoProductException() {
        super("No Product is Added");
    }
}
