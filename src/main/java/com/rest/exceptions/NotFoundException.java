package com.rest.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String Mensagem) {
        super(Mensagem);
    }
}
