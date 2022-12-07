package com.squad2.accenture.controller;

import com.squad2.accenture.dto.TgeIdiomaDto;
import com.squad2.accenture.model.TgeIdiomaModel;
import com.squad2.accenture.service.IdiomaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/idioma")
public class IdiomaController {

    private final IdiomaService idiomaService;


    public IdiomaController(IdiomaService idiomaService) {
        this.idiomaService = idiomaService;
    }

    @PostMapping
    public ResponseEntity salvarIdioma(@Valid @RequestBody TgeIdiomaModel idiomaModel){
        this.idiomaService.salvarIdioma(idiomaModel);
        ResponseEntity response = new ResponseEntity("Idioma inserido com sucesso!", HttpStatus.OK);
        return response;
    }

    @GetMapping("/{idIdioma}")
    public ResponseEntity selecionarIdiomaById(@PathVariable("idIdioma") Integer idIdioma){
        TgeIdiomaDto tgeIdiomaDto = this.idiomaService.getIdioma(idIdioma);
        ResponseEntity response = new ResponseEntity(tgeIdiomaDto, HttpStatus.OK);
        return response;
    }

    @GetMapping
    public List<TgeIdiomaDto> listarTodosIdiomas(Integer idIdioma){
        return this.idiomaService.listarTodosIdiomas();
    }

    @DeleteMapping("/{idIdioma}")
    ResponseEntity deletarIdioma(@PathVariable("idIdioma") Integer idIdioma){
        this.idiomaService.deletarIdioma(idIdioma);
        ResponseEntity response = new ResponseEntity("Idioma deletado com sucesso!", HttpStatus.OK);
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarIdioma(@PathVariable("id") Integer idIdioma, @RequestBody TgeIdiomaModel tgeIdiomaModel) {
        this.idiomaService.alterarIdioma(idIdioma, tgeIdiomaModel);
        ResponseEntity response = new ResponseEntity("Idioma atualizado com sucesso!", HttpStatus.OK);
        return response;
    }
}