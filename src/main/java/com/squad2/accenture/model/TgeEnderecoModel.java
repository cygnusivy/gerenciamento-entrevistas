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
@Table(name = "TGE_ENDERECO")
public class TgeEnderecoModel {

    @Id
    @Column(name = "ID_ENDERECO")
    private Integer idEndereco;

    @Column(name = "CANDIDATO_CPF")
    @NotBlank(message = "Campo candidatoCpf não pode ser nulo!")
    private String candidatoCpf;

    @Column
    @NotBlank(message = "Campo uf não pode ser nulo!")
    private String uf;

    @Column
    @NotBlank(message = "Campo cidade não pode ser nulo!")
    private String cidade;

    @Column
    @NotBlank(message = "Campo pais não pode ser nulo!")
    private String pais;

    @Column
    @NotBlank(message = "Campo bairro não pode ser nulo!")
    private String bairro;

    @Column
    @NotBlank(message = "Campo rua não pode ser nulo!")
    private String rua;

    @Column
    @NotBlank(message = "Campo numero não pode ser nulo!")
    private Integer numero;

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCandidatoCpf() {
        return candidatoCpf;
    }

    public void setCandidatoCpf(String candidatoCpf) {
        this.candidatoCpf = candidatoCpf;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}