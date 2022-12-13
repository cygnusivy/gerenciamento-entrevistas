package com.squad2.accenture.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TratamentoExeception {
    private final Logger LOGGER = LoggerFactory.getLogger(TratamentoExeception.class);

    @ExceptionHandler
    public ResponseEntity tratarExcecao(RegistroJaExisteException e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        return response;
    }
    @ExceptionHandler
    public ResponseEntity tratarExcecao(RegistroNaoExisteException e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        return response;
    }

    @ExceptionHandler
    public ResponseEntity tratarExcecao(RestricaoDeIntegridadeException e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        return response;
    }
}