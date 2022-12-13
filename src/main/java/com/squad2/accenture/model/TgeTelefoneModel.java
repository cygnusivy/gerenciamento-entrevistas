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
@Table(name = "TGE_TELEFONE")
public class TgeTelefoneModel {

    @Id
    @Column(name = "ID_TELEFONE")
    private Integer idTelefone;

    @Column(name = "CANDIDATO_CPF")
    @NotBlank(message = "Campo candidatoCpf não pode ser nulo")
    private String candidatoCpf;

    @Column
    @NotBlank(message = "Campo numero não pode ser nulo")
    private String numero;

    public Integer getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(Integer idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getCandidatoCpf() {
        return candidatoCpf;
    }

    public void setCandidatoCpf(String candidatoCpf) {
        this.candidatoCpf = candidatoCpf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
