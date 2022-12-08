package com.squad2.accenture.exception;

public class RegistroExisteException extends RuntimeException{
    public RegistroExisteException(String nomeRegistro){
        super(nomeRegistro + " já consta na base de dados. Insira um idioma diferente.");
    }
}
