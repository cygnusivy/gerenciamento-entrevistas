package com.squad2.accenture.business;

import com.squad2.accenture.exception.IdiomaAssociadoAVaga;
import com.squad2.accenture.exception.IdiomaNaoExisteException;
import com.squad2.accenture.exception.RegistroExisteException;
import com.squad2.accenture.dto.TgeIdiomaDto;
import com.squad2.accenture.model.TgeIdiomaModel;
import com.squad2.accenture.repository.TgeIdiomaRepository;
import com.squad2.accenture.repository.TgeVagaRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IdiomaBusiness {

    @Autowired
    private TgeIdiomaRepository tgeIdiomaRepository;

    @Autowired
    private TgeVagaRepository tgeVagaRepository;

    public TgeIdiomaModel salvarIdioma(@NotNull TgeIdiomaModel idioma){
        if(!this.tgeIdiomaRepository.existsByIdioma(idioma.getIdioma()) || !this.tgeIdiomaRepository.existsById(idioma.getIdIdioma())) {
            this.tgeIdiomaRepository.save(idioma);
            return idioma;
        }else{
            throw new RegistroExisteException();
        }
    }

    public TgeIdiomaDto getIdioma(Integer idIdioma){
        verificaExistenciaDeIdioma(idIdioma);

        TgeIdiomaModel tgeIdiomaModel = getIdiomaById(idIdioma);

        TgeIdiomaDto tgeIdiomaDto = new TgeIdiomaDto();
        tgeIdiomaDto.setIdIdioma(tgeIdiomaModel.getIdIdioma());
        tgeIdiomaDto.setIdioma(tgeIdiomaModel.getIdioma());

        return tgeIdiomaDto;
    }

    public List<TgeIdiomaDto> listarTodosIdiomas(){
        List<TgeIdiomaModel> tgeIdiomaModel = getTodosIdiomas();
        List<TgeIdiomaDto> response = new ArrayList<>();

        for(TgeIdiomaModel x : tgeIdiomaModel){
            TgeIdiomaDto tgeIdiomaDto = new TgeIdiomaDto();
            tgeIdiomaDto.setIdIdioma(x.getIdIdioma());
            tgeIdiomaDto.setIdioma(x.getIdioma());

            response.add(tgeIdiomaDto);
        }

        return response;
    }

    public void deletaridioma(Integer idIdioma){
        verificaExistenciaDeIdioma(idIdioma);
        Integer retorno = this.tgeVagaRepository.veriricaExistenciaIdioma(idIdioma);

        if (retorno > 0){
            throw new IdiomaAssociadoAVaga();
        }else{
            this.tgeIdiomaRepository.deleteById(idIdioma);
        }

    }


    public TgeIdiomaModel atualizarIdioma(Integer idIdioma, TgeIdiomaModel tgeIdiomaModel){
        TgeIdiomaModel tgeIdiomaModel1 = this.getIdiomaById(idIdioma);
        tgeIdiomaModel1.setIdioma(tgeIdiomaModel.getIdioma());
        this.salvarIdioma(tgeIdiomaModel1);
        return tgeIdiomaModel1;
    }
    private void verificaExistenciaDeIdioma(Integer idIdioma){
        if (!(this.tgeIdiomaRepository.existsById(idIdioma))){
            throw new IdiomaNaoExisteException();
        }
    }
    private TgeIdiomaModel getIdiomaById(Integer idIdioma){
        TgeIdiomaModel tgeIdiomaModel = tgeIdiomaRepository.findByIdIdioma(idIdioma);
        return tgeIdiomaModel;
    }

    private List<TgeIdiomaModel> getTodosIdiomas(){
        return this.tgeIdiomaRepository.findAll();
    }

}