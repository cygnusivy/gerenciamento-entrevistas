package com.squad2.accenture.exception;

public class RegistroExisteException extends RuntimeException{
    public RegistroExisteException(){
        super("Registro já consta na base de dados. Insira um idioma diferente.");
    }
}
