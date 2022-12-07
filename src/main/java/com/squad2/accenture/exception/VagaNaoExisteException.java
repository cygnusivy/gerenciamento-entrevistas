package com.squad2.accenture.exception;

public class VagaNaoExisteException extends RuntimeException{

    public VagaNaoExisteException(){
        super("Vaga não cadastrada, insira um idVaga válido.");
    }
}