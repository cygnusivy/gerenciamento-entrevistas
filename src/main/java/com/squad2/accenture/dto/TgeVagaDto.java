package com.squad2.accenture.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TgeVagaDto {

    private Integer idVaga;

    private String nomeVaga;

    private LocalDate tempoAlocacao;

    private Integer idIdioma;

    private String localidade;

    private String descricao;

    private List<TgeHabilidadesDto> tgeHabilidadesDtolList;

}