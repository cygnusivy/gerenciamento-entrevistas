package com.squad2.accenture.business.advice;

import com.squad2.accenture.business.exception.IdiomaAssociadoAVaga;
import com.squad2.accenture.business.exception.IdiomaNaoExisteException;
import com.squad2.accenture.business.exception.VagaAssociadaHabilidade;
import com.squad2.accenture.business.exception.VagaNaoExisteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IidomaAdvice {
    private final Logger LOGGER = LoggerFactory.getLogger(IidomaAdvice.class);

    @ExceptionHandler
    public ResponseEntity tratarExcecao(IdiomaNaoExisteException e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        return response;
    }

    @ExceptionHandler
    public ResponseEntity tratarExcecao(IdiomaAssociadoAVaga e){
        ResponseEntity response = new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        return response;
    }
}