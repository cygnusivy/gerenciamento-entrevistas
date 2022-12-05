package com.squad2.accenture.business.exception;

public class VagaAssociadaHabilidade extends RuntimeException{

    public VagaAssociadaHabilidade(){
        super("Vaga está associada a uma habilidade, não é possível deletar.");
    }

}