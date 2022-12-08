package com.squad2.accenture.exception;

public class IdiomaAssociadoAVaga extends RuntimeException{

    public IdiomaAssociadoAVaga(String nomeIdioma){
        super("Idioma " + nomeIdioma + " já está associado a uma vaga, não é possível deletar!");
    }
}