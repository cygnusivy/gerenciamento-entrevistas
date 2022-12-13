package com.squad2.accenture.controller;

import com.squad2.accenture.model.TgeEntrevistaModel;
import com.squad2.accenture.service.EntrevistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entrevista")
public class EntrevistaController {

    @Autowired
    EntrevistaService entrevistaService;

    @PostMapping
    public ResponseEntity salvarEntrevista(@Valid @RequestBody TgeEntrevistaModel TgeEntrevistaModel){
        this.entrevistaService.salvarEntrevita(TgeEntrevistaModel);
        ResponseEntity response = new ResponseEntity("Entrevista inserido com sucesso!", HttpStatus.OK);
        return response;
    }

    @GetMapping("/{idEntrevista}")
    public ResponseEntity selecionarEntrevista(@PathVariable("idEntrevista") Integer id){
        TgeEntrevistaModel TgeEntrevistaModel = this.entrevistaService.selecionarEntrevista(id);
        ResponseEntity response = new ResponseEntity(TgeEntrevistaModel, HttpStatus.OK);
        return response;
    }

    @GetMapping
    public List<TgeEntrevistaModel> listarTodasEntrevistas(){
        return this.entrevistaService.tgeEntrevistaModelList();
    }

    @DeleteMapping("/{idEntrevista}")
    public ResponseEntity deletarEntrevista(@PathVariable("idEntrevista") Integer id){
        this.entrevistaService.deletarEntrevista(id);
        ResponseEntity response = new ResponseEntity("Entrevista deletada com sucesso!", HttpStatus.OK);
        return response;
    }

    @PutMapping("/{idEntrevista}")
    public ResponseEntity alterarEntrevitsa(@PathVariable("idEntrevista") Integer idEntrevista, @RequestBody TgeEntrevistaModel TgeEntrevistaModel) {
        this.entrevistaService.alterarEntrevista(idEntrevista, TgeEntrevistaModel);
        ResponseEntity response = new ResponseEntity("Entrevista atualizada com sucesso!", HttpStatus.OK);
        return response;
    }
}