package com.squad2.accenture.service;

import com.squad2.accenture.business.VagaBusiness;
import com.squad2.accenture.dto.VgeInformacoesVagaDto;
import com.squad2.accenture.model.TgeVagaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {

    @Autowired
    VagaBusiness vagaBusiness;

    public void salvarVaga(TgeVagaModel tgeVagaModel){
        this.vagaBusiness.salvarVaga(tgeVagaModel);
    }
    public VgeInformacoesVagaDto getVaga(Integer idVaga){
        return vagaBusiness.selecionarVaga(idVaga);
    }

    public List<VgeInformacoesVagaDto> getTodasVagas(){
        return vagaBusiness.listarTodasVagas();
    }

    public void deletarVagaById(Integer idVaga){
        this.vagaBusiness.deletarVaga(idVaga);
    }

    public void alterarVaga(Integer id, TgeVagaModel tgeVagaModel){
        this.vagaBusiness.atualizarVaga(id, tgeVagaModel);
    }
}