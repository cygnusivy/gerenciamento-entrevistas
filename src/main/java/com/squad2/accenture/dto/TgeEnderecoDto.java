package com.squad2.accenture.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TgeEnderecoDto {

    private Integer idEndereco;

    private String candidatoCpf;

    private String uf;

    private String cidade;

    private String pais;

    private String bairro;

    private String rua;

    private Integer numero;
}