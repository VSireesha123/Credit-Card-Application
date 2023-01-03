package com.crecard.execption;


public class CustomerUserIdNotFoundException extends RuntimeException{
    public CustomerUserIdNotFoundException(String message) {
        super(message);
    }

}