package com.brunojose.workshopmongo.services.exception;  // <-- pacote correto do curso

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}