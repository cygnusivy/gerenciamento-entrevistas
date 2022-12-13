package com.squad2.accenture.exception;

public class RegistroNaoExisteException extends RuntimeException{
    public RegistroNaoExisteException(String nomeRegistro){
        super(nomeRegistro);
    }
}
