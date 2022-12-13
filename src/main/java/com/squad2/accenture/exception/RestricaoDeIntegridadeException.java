package com.squad2.accenture.exception;

import java.sql.SQLIntegrityConstraintViolationException;

public class RestricaoDeIntegridadeException extends RuntimeException {
    public RestricaoDeIntegridadeException(String registro){
        super(registro);
    }
}