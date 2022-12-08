package com.squad2.accenture.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "VGE_IDIOMA")
public class VgeIdiomaModel {

    @Id
    @Column(name = "ID_IDIOMA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIdioma;

    @Column(name = "NOME_IDIOMA")
    @NotBlank(message = "Campo idioma não pode ser nulo")
    private String idioma;

}