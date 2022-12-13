package com.squad2.accenture.exception;

public class RegistroJaExisteException extends RuntimeException{
    public RegistroJaExisteException(String nomeRegistro){
        super(nomeRegistro + " já consta na base de dados. Insira um registro diferente.");
    }
}
