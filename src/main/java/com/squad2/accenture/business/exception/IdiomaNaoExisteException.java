package com.squad2.accenture.business.exception;

public class IdiomaNaoExisteException extends RuntimeException{

    public IdiomaNaoExisteException(){
        super("Idioma não cadastrado, insira o idIdioma válido!");
    }
}