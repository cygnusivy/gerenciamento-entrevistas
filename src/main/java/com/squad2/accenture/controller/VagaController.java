package com.squad2.accenture.controller;

import com.squad2.accenture.dto.VgeInformacoesVagaDto;
import com.squad2.accenture.service.VagaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/vaga")
public class VagaController {

   private final VagaService vagaService;

    public VagaController(VagaService vagaService) {
        this.vagaService = vagaService;
    }

    @GetMapping("/{idVagas}")
    public ResponseEntity selecionarVagaById(@PathVariable("idVagas") Integer idVagas) {
        VgeInformacoesVagaDto vgeInformacoesVagaDto = this.vagaService.getVaga(idVagas);
        ResponseEntity response = new ResponseEntity(vgeInformacoesVagaDto, HttpStatus.OK);
        return response;
    }
}
