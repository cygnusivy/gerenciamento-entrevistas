package com.squad2.accenture.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TGE_VAGA")
public class TgeVagaModel {

    @Id
    @Column(name = "ID_VAGA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVaga;

    @Column(name = "NOME_VAGA")
    @NotBlank(message = "Nome da vaga não informado")
    private String nomeVaga;

    @Column(name = "TEMP_ALOCACAO")
    @NotNull(message = "Tempo de alocação não informado")
    private LocalDate tempoAlocacao;

    @Column
    @NotBlank(message = "Localidade não informada")
    private String localidade;

    @Column
    @NotBlank(message = "Descrição não informada")
    private String descricao;

    public Integer getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(Integer idVaga) {
        this.idVaga = idVaga;
    }

    public String getNomeVaga() {
        return nomeVaga;
    }

    public void setNomeVaga(String nomeVaga) {
        this.nomeVaga = nomeVaga;
    }

    public LocalDate getTempoAlocacao() {
        return tempoAlocacao;
    }

    public void setTempoAlocacao(LocalDate tempoAlocacao) {
        this.tempoAlocacao = tempoAlocacao;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}