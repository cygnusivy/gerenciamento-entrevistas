package com.squad2.accenture.business;

import com.squad2.accenture.dto.TgeIdiomaDto;
import com.squad2.accenture.model.TgeIdiomaModel;
import com.squad2.accenture.repository.TgeIdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IdiomaBusiness {

    @Autowired
    private TgeIdiomaRepository tgeIdiomaRepository;

    public TgeIdiomaDto getIdioma(Integer idIdioma){
        TgeIdiomaModel tgeIdiomaModel = getIdiomaById(idIdioma);

        TgeIdiomaDto tgeIdiomaDto = new TgeIdiomaDto();
        tgeIdiomaDto.setIdIdioma(tgeIdiomaModel.getIdIdioma());
        tgeIdiomaDto.setIdioma(tgeIdiomaModel.getIdioma());

        return tgeIdiomaDto;
    }
    private TgeIdiomaModel getIdiomaById(Integer idIdioma){
        TgeIdiomaModel tgeIdiomaModel = tgeIdiomaRepository.findByIdIdioma(idIdioma);
        return tgeIdiomaModel;
    }

}