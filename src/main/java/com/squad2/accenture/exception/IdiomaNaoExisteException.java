package com.squad2.accenture.exception;

public class IdiomaNaoExisteException extends RuntimeException{

    public IdiomaNaoExisteException(Integer idIdioma){
        super("Idioma de ID: " + idIdioma + " não cadastrado, insira o idIdioma válido!");
    }
}