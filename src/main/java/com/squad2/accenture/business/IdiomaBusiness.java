package com.squad2.accenture.business;

import com.squad2.accenture.exception.RegistroJaExisteException;
import com.squad2.accenture.dto.TgeIdiomaDto;
import com.squad2.accenture.exception.RegistroNaoExisteException;
import com.squad2.accenture.exception.RestricaoDeIntegridadeException;
import com.squad2.accenture.model.TgeIdiomaModel;
import com.squad2.accenture.repository.TgeIdiomaRepository;
import com.squad2.accenture.repository.TgeVagaRepository;
import com.squad2.accenture.repository.VgeIdiomaRepository;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @Autowired
    private VgeIdiomaRepository vgeIdiomaRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(IdiomaBusiness.class);

    public TgeIdiomaModel salvarIdioma(@NotNull TgeIdiomaModel idioma){
        LOGGER.info(String.format("Início do método salvarIdioma()"));
        if(!this.tgeIdiomaRepository.existsByIdioma(idioma.getIdioma())) {
            LOGGER.info(String.format("Idioma " + idioma.getIdioma() + " salvo com sucesso"));
            this.tgeIdiomaRepository.save(idioma);
            return idioma;
        }else{
            String concat = "Idioma " + this.tgeIdiomaRepository.findByIdioma(idioma.getIdioma()).getIdioma();
            throw new RegistroJaExisteException(concat);
        }
    }

    public TgeIdiomaDto selecionarIdioma(Integer idIdioma){
        LOGGER.info(String.format("Início do método getIdioma(). Verificando existencia do Idioma pelo ID: " + idIdioma));
        verificaExistenciaDeIdioma(idIdioma);

        TgeIdiomaModel tgeIdiomaModel = getIdiomaById(idIdioma);

        TgeIdiomaDto tgeIdiomaDto = new TgeIdiomaDto();
        tgeIdiomaDto.setIdIdioma(tgeIdiomaModel.getIdIdioma());
        tgeIdiomaDto.setIdioma(tgeIdiomaModel.getIdioma());

        return tgeIdiomaDto;
    }

    public List<TgeIdiomaDto> listarTodosIdiomas(){
        LOGGER.info(String.format("Início do método listarTodosIdiomas()"));
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
        LOGGER.info(String.format("Início do método deletarIdioma()" + idIdioma));
        verificaExistenciaDeIdioma(idIdioma);
        Boolean retorno = this.vgeIdiomaRepository.existsByIdIdioma(idIdioma);

        if (retorno){
            String concat = "Existem registros associados ao idioma " + this.tgeIdiomaRepository.findByIdIdioma(idIdioma).getIdioma() + ", não é possível deleta-lo;";
            throw new RestricaoDeIntegridadeException(concat);
        }else{
            LOGGER.info(String.format("Idioma deletado com sucesso!"));
            this.tgeIdiomaRepository.deleteById(idIdioma);
        }

    }

    public TgeIdiomaModel atualizarIdioma(Integer idIdioma, TgeIdiomaModel tgeIdiomaModel){
        LOGGER.info(String.format("Início do método atualizar idioma"));
        TgeIdiomaModel tgeIdiomaModel1 = this.getIdiomaById(idIdioma);
        tgeIdiomaModel1.setIdioma(tgeIdiomaModel.getIdioma());
        this.salvarIdioma(tgeIdiomaModel1);
        return tgeIdiomaModel1;
    }

    private void verificaExistenciaDeIdioma(Integer idIdioma){
        LOGGER.info(String.format("Verificando existencia do Idioma pelo ID: " + idIdioma));
        if (!(this.tgeIdiomaRepository.existsById(idIdioma))){
            String concat = "Idioma de ID: " + idIdioma + " não existe na base de dados. Insira um idIdioma diferente.";
            throw new RegistroNaoExisteException(concat);
        }
    }

    private TgeIdiomaModel getIdiomaById(Integer idIdioma){
        LOGGER.info(String.format("Selecionando Idioma pelo ID: " + idIdioma));
        TgeIdiomaModel tgeIdiomaModel = tgeIdiomaRepository.findByIdIdioma(idIdioma);
        return tgeIdiomaModel;
    }

    private List<TgeIdiomaModel> getTodosIdiomas(){
        return this.tgeIdiomaRepository.findAll();
    }

}