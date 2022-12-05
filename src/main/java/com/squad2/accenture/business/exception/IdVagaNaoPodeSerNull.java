package com.squad2.accenture.business.exception;

public class IdVagaNaoPodeSerNull extends RuntimeException{

    public IdVagaNaoPodeSerNull(){
        super("Campo idVaga não pode ser null!");
    }
}
