package com.inventorymanagementsytem.demo.exceptions;

public class EmptyInputException extends IMSException {
    public EmptyInputException() {
        super("Input Cannot Be Empty");
    }
}
