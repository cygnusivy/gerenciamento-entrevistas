package com.squad2.accenture.model;

import lombok.*;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VGE_HABILIDADE")
public class VgeHabilidadesModel {

    @Id
    @Column(name = "ID_HABILIDADE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHabilidade;

    @Column(name = "NOME_HABILIDADE")
    private String nomeHabilidade;

    public Integer getIdHabilidade() {
        return idHabilidade;
    }

    public void setIdHabilidade(Integer idHabilidade) {
        this.idHabilidade = idHabilidade;
    }

    public String getNomeHabilidade() {
        return nomeHabilidade;
    }

    public void setNomeHabilidade(String nomeHabilidade) {
        this.nomeHabilidade = nomeHabilidade;
    }
}