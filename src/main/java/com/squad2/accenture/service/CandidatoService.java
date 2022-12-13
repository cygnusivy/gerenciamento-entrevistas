package com.squad2.accenture.service;

import com.squad2.accenture.business.TgeCandidatoBusiness;
import com.squad2.accenture.model.TgeCandidatoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoService {

    @Autowired
    TgeCandidatoBusiness tgeCandidatoBusiness;

    public TgeCandidatoModel selecionarCandidato(String cpf){
        return this.tgeCandidatoBusiness.selecionarCandidato(cpf);
    }

    public void salvarCandidato(TgeCandidatoModel candidatoModel){
        this.tgeCandidatoBusiness.salvarCandidato(candidatoModel);
    }

    public List<TgeCandidatoModel> listarTodosCandidato(){
        return this.tgeCandidatoBusiness.listarCandidatos();
    }

    public void deletarCandidato(String cpf){
        this.tgeCandidatoBusiness.deletarCandidato(cpf);
    }

    public void atualizarCandidato(String cpf, TgeCandidatoModel tgeCandidatoModel){
        this.tgeCandidatoBusiness.atualizarCandidato(cpf, tgeCandidatoModel);
    }
}