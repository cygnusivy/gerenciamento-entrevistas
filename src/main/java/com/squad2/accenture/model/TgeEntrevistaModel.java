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
@Getter
@Setter
@Entity
@Table(name = "TGE_ENTREVISTA")
public class TgeEntrevistaModel {

    @Id
    @Column(name = "ID_ENTREVISTA")
    private String idEntrevista;


}