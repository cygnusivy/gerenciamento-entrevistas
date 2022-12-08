package com.squad2.accenture.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TGE_CANDIDATO")
public class TgeCandidatoModel {

    @Id
    @Column
    private String cpf;
}
