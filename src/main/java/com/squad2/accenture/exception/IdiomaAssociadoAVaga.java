package com.squad2.accenture.exception;

public class IdiomaAssociadoAVaga extends RuntimeException{

    public IdiomaAssociadoAVaga(){
        super("Idioma já está associado a uma vaga, não é possível deletar!");
    }
}