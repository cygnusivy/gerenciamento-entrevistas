package com.squad2.accenture.controller;

import com.squad2.accenture.dto.VgeInformacoesVagaDto;
import com.squad2.accenture.service.VagaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping
    public List<VgeInformacoesVagaDto> listarTodasVagas(){
        return this.vagaService.getTodasVagas();
    }

    @DeleteMapping("/{idVaga}")
    public ResponseEntity deletarVaga(@PathVariable("idVaga") Integer idVaga){
        this.vagaService.deletarVagaById(idVaga);
        ResponseEntity response = new ResponseEntity("Vaga deletada com sucesso", HttpStatus.OK);
        return response;
    }
}