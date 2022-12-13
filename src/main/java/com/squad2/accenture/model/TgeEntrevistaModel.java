package com.squad2.accenture.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TGE_ENTREVISTA")
public class TgeEntrevistaModel {

    @Id
    @Column(name = "ID_ENTREVISTA")
    private Integer idEntrevista;

    @Column(name = "DATA_ENTREVISTA")
    private LocalDate dataEntrevista;

    @Column(name = "CANDIDATO_CPF")
    private String candidatoCpf;

    @Column(name = "DESCR_HABILIDADES_TECNICAS")
    private String descHabilidadesTecnicas;

    @Column(name = "DESCR_HABILIDADES_INTERPESSOAL")
    private String descHabilidadesInterpessoais;

    @Column(name = "COD_STATUS")
    private String codStatus;

    public Integer getIdEntrevista() {
        return idEntrevista;
    }

    public void setIdEntrevista(Integer idEntrevista) {
        this.idEntrevista = idEntrevista;
    }

    public LocalDate getDataEntrevista() {
        return dataEntrevista;
    }

    public void setDataEntrevista(LocalDate dataEntrevista) {
        this.dataEntrevista = dataEntrevista;
    }

    public String getCandidatoCpf() {
        return candidatoCpf;
    }

    public void setCandidatoCpf(String candidatoCpf) {
        this.candidatoCpf = candidatoCpf;
    }

    public String getDescHabilidadesTecnicas() {
        return descHabilidadesTecnicas;
    }

    public void setDescHabilidadesTecnicas(String descHabilidadesTecnicas) {
        this.descHabilidadesTecnicas = descHabilidadesTecnicas;
    }

    public String getDescHabilidadesInterpessoais() {
        return descHabilidadesInterpessoais;
    }

    public void setDescHabilidadesInterpessoais(String descHabilidadesInterpessoais) {
        this.descHabilidadesInterpessoais = descHabilidadesInterpessoais;
    }

    public String getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(String codStatus) {
        this.codStatus = codStatus;
    }
}