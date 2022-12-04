package com.squad2.accenture.controller;

import com.squad2.accenture.dto.TgeIdiomaDto;
import com.squad2.accenture.service.IdiomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/idioma")
public class IdiomaController {

    private final IdiomaService idiomaService;


    public IdiomaController(IdiomaService idiomaService) {
        this.idiomaService = idiomaService;
    }

    @GetMapping("/{idIdioma}")
    public ResponseEntity selecionarIdiomaById(@PathVariable("idIdioma") Integer idIdioma){
        TgeIdiomaDto tgeIdiomaDto = this.idiomaService.getIdioma(idIdioma);
        ResponseEntity response = new ResponseEntity(tgeIdiomaDto, HttpStatus.OK);
        return response;
    }

}