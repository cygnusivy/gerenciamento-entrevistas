package com.squad2.accenture.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TGE_VINCULO_HABILIDADE_VAGA")
public class TgeVinculoHabilidadeVagaModel {

    @Id
    @Column(name = "ID_VINCULO")
    private Integer idVinculo;

    @Column(name = "ID_HABILIDADE")
    @NotBlank(message = "Campo idHabilidade não pode ser nulo!")
    private Integer idHabilidade;

    @Column(name = "ID_VAGA")
    @NotBlank(message = "Campo idVaga não pode ser nulo!")
    private Integer idVaga;

    public Integer getIdVinculo() {
        return idVinculo;
    }

    public void setIdVinculo(Integer idVinculo) {
        this.idVinculo = idVinculo;
    }

    public Integer getIdHabilidade() {
        return idHabilidade;
    }

    public void setIdHabilidade(Integer idHabilidade) {
        this.idHabilidade = idHabilidade;
    }

    public Integer getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(Integer idVaga) {
        this.idVaga = idVaga;
    }
}
