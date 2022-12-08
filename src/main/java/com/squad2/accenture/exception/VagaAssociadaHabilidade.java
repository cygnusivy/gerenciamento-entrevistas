package com.squad2.accenture.exception;

public class VagaAssociadaHabilidade extends RuntimeException{

    public VagaAssociadaHabilidade(String nomeVaga){
        super("Vaga " + nomeVaga + " está associada a uma habilidade, não é possível deleta-lá.");
    }

}