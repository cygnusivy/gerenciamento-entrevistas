package com.squad2.accenture.business.advice;

import com.squad2.accenture.business.exception.IdVagaNaoPodeSerNull;
import com.squad2.accenture.business.exception.VagaAssociadaHabilidade;
import com.squad2.accenture.business.exception.VagaNaoExisteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VagaAdvice {
    private final Logger LOGGER = LoggerFactory.getLogger(VagaAdvice.class);

    @ExceptionHandler
    public ResponseEntity tratarExcecao(VagaAssociadaHabilidade e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        return response;
    }

    @ExceptionHandler
    public ResponseEntity tratarExcecao(VagaNaoExisteException e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        return response;
    }

    @ExceptionHandler
    public ResponseEntity tratarExcecao(IdVagaNaoPodeSerNull e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        return response;
    }
}