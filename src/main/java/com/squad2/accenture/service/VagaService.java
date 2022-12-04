package com.squad2.accenture.service;

import com.squad2.accenture.business.VagaBusiness;
import com.squad2.accenture.dto.VgeInformacoesVagaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VagaService {

    @Autowired
    VagaBusiness vagaBusiness;

    public VgeInformacoesVagaDto getVaga(Integer idVaga){
        return vagaBusiness.getVagas(idVaga);
    }
}
