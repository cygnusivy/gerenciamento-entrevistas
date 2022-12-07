package com.squad2.accenture.service;

import com.squad2.accenture.business.IdiomaBusiness;
import com.squad2.accenture.dto.TgeIdiomaDto;
import com.squad2.accenture.model.TgeIdiomaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomaService {

    @Autowired
    IdiomaBusiness idiomaBusiness;

    public void salvarIdioma(TgeIdiomaModel idioma){
        this.idiomaBusiness.salvarIdioma(idioma);
    }
    public TgeIdiomaDto getIdioma(Integer idIdioma){
        return idiomaBusiness.getIdioma(idIdioma);
    }
    public List<TgeIdiomaDto> listarTodosIdiomas(){
        return this.idiomaBusiness.listarTodosIdiomas();
    }

    public void deletarIdioma(Integer idIdioma){
        this.idiomaBusiness.deletaridioma(idIdioma);
    }

    public void alterarIdioma(Integer idIdioma, TgeIdiomaModel tgeIdiomaModel){
        this.idiomaBusiness.atualizarIdioma(idIdioma, tgeIdiomaModel);
    }

}