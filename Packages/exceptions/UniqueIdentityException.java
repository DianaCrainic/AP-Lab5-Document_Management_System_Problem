package com.exceptions;

public class UniqueIdentityException extends RuntimeException{
    public UniqueIdentityException(String text){
        super(text);
    }
}
