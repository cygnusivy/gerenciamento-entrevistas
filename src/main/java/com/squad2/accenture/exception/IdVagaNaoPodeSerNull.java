package com.squad2.accenture.exception;

public class IdVagaNaoPodeSerNull extends RuntimeException{

    public IdVagaNaoPodeSerNull(){
        super("Campo idVaga não pode ser null!");
    }
}
