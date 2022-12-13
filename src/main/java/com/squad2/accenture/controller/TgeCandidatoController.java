package com.squad2.accenture.controller;

import com.squad2.accenture.model.TgeCandidatoModel;
import com.squad2.accenture.service.CandidatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/candidato")
public class TgeCandidatoController {

    private final CandidatoService candidatoService;

    public TgeCandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    @PostMapping
    public ResponseEntity salvarCandidato(@Valid @RequestBody TgeCandidatoModel candidatoModel){
        this.candidatoService.salvarCandidato(candidatoModel);
        ResponseEntity response = new ResponseEntity("Candidato salvo com sucesso!", HttpStatus.OK);
        return response;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity selecionarCandidato(@PathVariable("cpf") String cpf){
        TgeCandidatoModel tgeCandidatoModel = this.candidatoService.selecionarCandidato(cpf);
        ResponseEntity response = new ResponseEntity(tgeCandidatoModel, HttpStatus.OK);
        return response;
    }

    @GetMapping
    public List<TgeCandidatoModel> listarTodos(){
        return this.candidatoService.listarTodosCandidato();
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity deletarCandidato(@PathVariable("cpf") String cpf){
        this.candidatoService.deletarCandidato(cpf);
        ResponseEntity response = new ResponseEntity("Candidato salvo com sucesso!", HttpStatus.OK);
        return response;
    }

    @PutMapping("/{cpf}")
    public ResponseEntity alteraCandidato(@PathVariable("cpf") String cpf, TgeCandidatoModel tgeCandidatoModel){
        this.candidatoService.atualizarCandidato(cpf, tgeCandidatoModel);
        ResponseEntity response = new ResponseEntity("Candidato atualizado com sucesso", HttpStatus.OK);
        return response;
    }
}
