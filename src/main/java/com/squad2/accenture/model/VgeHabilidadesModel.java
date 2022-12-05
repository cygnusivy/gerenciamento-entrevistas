package com.squad2.accenture.model;

import lombok.*;

import javax.persistence.*;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "VGE_HABILIDADE")
public class VgeHabilidadesModel {

    @Id
    @Column(name = "ID_HABILIDADE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHabilidade;

    @Column(name = "NOME_HABILIDADE")
    private String nomeHabilidade;

}