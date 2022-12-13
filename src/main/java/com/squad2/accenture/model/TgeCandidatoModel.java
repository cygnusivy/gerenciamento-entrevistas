package com.squad2.accenture.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TGE_CANDIDATO")
public class TgeCandidatoModel {

    @Id
    @Column
    @NotBlank(message = "O campo de cpf não pode ser vazio")
    private String cpf;

    @Column
    @NotBlank(message = "O campo nome não pode ser vazio")
    private String nome;

    @Column(name = "DESCRICAO_TECNICA")
    private String descricaoTecnica;

    @Column
    @NotBlank(message = "O campo de email naõ pode ser vazio")
    private String email;

    @Column(name = "PRETENCAO_SALARIO")
    private BigDecimal pretencaoSalario;

    @Column(name = "NOTA_INGLES")
    private BigDecimal notaIngles;

    @Column(name = "NOTA_LOGICA")
    private BigDecimal notaLogica;

    @Column(name = "NOTA_SQL")
    private BigDecimal notaSql;

    @Column(name = "ID_SENIORIDADE")
    private Integer idSenioridade;

    @Column(name = "COD_STATUS")
    private String codStatus;

    @Column(name = "VAGAS_ID_VAGA")
    private Integer vagasIdVaga;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoTecnica() {
        return descricaoTecnica;
    }

    public void setDescricaoTecnica(String descricaoTecnica) {
        this.descricaoTecnica = descricaoTecnica;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getPretencaoSalario() {
        return pretencaoSalario;
    }

    public void setPretencaoSalario(BigDecimal pretencaoSalario) {
        this.pretencaoSalario = pretencaoSalario;
    }

    public BigDecimal getNotaIngles() {
        return notaIngles;
    }

    public void setNotaIngles(BigDecimal notaIngles) {
        this.notaIngles = notaIngles;
    }

    public BigDecimal getNotaLogica() {
        return notaLogica;
    }

    public void setNotaLogica(BigDecimal notaLogica) {
        this.notaLogica = notaLogica;
    }

    public BigDecimal getNotaSql() {
        return notaSql;
    }

    public void setNotaSql(BigDecimal notaSql) {
        this.notaSql = notaSql;
    }

    public Integer getIdSenioridade() {
        return idSenioridade;
    }

    public void setIdSenioridade(Integer idSenioridade) {
        this.idSenioridade = idSenioridade;
    }

    public String getCodStatus() {
        return codStatus;
    }

    public void setCodStatus(String codStatus) {
        this.codStatus = codStatus;
    }

    public Integer getVagasIdVaga() {
        return vagasIdVaga;
    }

    public void setVagasIdVaga(Integer vagasIdVaga) {
        this.vagasIdVaga = vagasIdVaga;
    }
}