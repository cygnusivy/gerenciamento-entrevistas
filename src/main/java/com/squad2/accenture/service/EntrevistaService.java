package com.squad2.accenture.service;

import com.squad2.accenture.business.TgeEntrevistaBusiness;
import com.squad2.accenture.model.TgeEntrevistaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrevistaService {

    @Autowired
    TgeEntrevistaBusiness entrevistaBusiness;

    public void deletarEntrevista(Integer id){
        this.entrevistaBusiness.deletarEntrevista(id);
    }

    public void alterarEntrevista(Integer id, TgeEntrevistaModel entrevistaModel){
        this.entrevistaBusiness.atualizarEntrevista(id, entrevistaModel);
    }

    public List<TgeEntrevistaModel> tgeEntrevistaModelList(){
        return this.entrevistaBusiness.tgeEntrevistaModelList();
    }

    public TgeEntrevistaModel selecionarEntrevista(Integer id){
        return this.entrevistaBusiness.selecionarEntrevista(id);
    }

    public void salvarEntrevita(TgeEntrevistaModel tgeEntrevistaModel){
        this.entrevistaBusiness.salvarEntrevista(tgeEntrevistaModel);
    }
}