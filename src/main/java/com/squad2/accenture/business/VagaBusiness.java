package com.squad2.accenture.business;

import com.squad2.accenture.exception.VagaAssociadaHabilidade;
import com.squad2.accenture.exception.VagaNaoExisteException;
import com.squad2.accenture.dto.TgeHabilidadesDto;
import com.squad2.accenture.dto.VgeInformacoesVagaDto;
import com.squad2.accenture.model.TgeIdiomaModel;
import com.squad2.accenture.model.VgeHabilidadesModel;
import com.squad2.accenture.model.VgeInformacoesVagaModel;
import com.squad2.accenture.repository.VgeInformacoesVagaRepository;
import com.squad2.accenture.repository.VgeHabilidadeRepository;
import com.squad2.accenture.repository.TgeVagaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VagaBusiness {

    @Autowired
    VgeInformacoesVagaRepository vgeInformacoesVagaRepository;

    @Autowired
    VgeHabilidadeRepository vgeHabilidadeRepository;

    @Autowired
    TgeVagaRepository vagaRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(VagaBusiness.class);
    public VgeInformacoesVagaDto getVagas(Integer idVaga){

        validaExistenciaDaVaga(idVaga);

        LOGGER.info("Início do método getVagas para vaga de ID  ID: {}", idVaga);
        VgeInformacoesVagaModel vgeInformacoesVagaModel = getVagasByIdVaga(idVaga);

        List<VgeHabilidadesModel> vgeHabilidadesModelList = getListHabilidade(idVaga);

        VgeInformacoesVagaDto response = new VgeInformacoesVagaDto();

        response.setIdVaga(vgeInformacoesVagaModel.getIdVaga());
        response.setNomeVaga(vgeInformacoesVagaModel.getNomeVaga());
        response.setTempoAlocacao(vgeInformacoesVagaModel.getTempoAlocacao());
        response.setDescricao(vgeInformacoesVagaModel.getDescricao());
        response.setLocalidade(vgeInformacoesVagaModel.getLocalidade());
        response.setNomeIdioma(vgeInformacoesVagaModel.getNomeIdioma());
        response.setTgeHabilidadesDtolList(getListHabilidadeResponse(vgeHabilidadesModelList));

        return response;

    }

    public List<VgeInformacoesVagaDto> listarTodasVagas(){

        List<VgeInformacoesVagaModel> vgeInformacoesVagaModel = getTodasVagas();

        List<VgeInformacoesVagaDto> response = new ArrayList<>();

        for(VgeInformacoesVagaModel x : vgeInformacoesVagaModel){

            VgeInformacoesVagaDto vgeInformacoesVagaDto = new VgeInformacoesVagaDto();
            List<VgeHabilidadesModel> vgeHabilidadesModelList = getListHabilidade(x.getIdVaga());
            List<TgeHabilidadesDto> tgeHabilidadesDtos = getListHabilidadeResponse(vgeHabilidadesModelList);

            vgeInformacoesVagaDto.setIdVaga(x.getIdVaga());
            vgeInformacoesVagaDto.setNomeVaga(x.getNomeVaga());
            vgeInformacoesVagaDto.setDescricao(x.getDescricao());
            vgeInformacoesVagaDto.setLocalidade(x.getLocalidade());
            vgeInformacoesVagaDto.setTempoAlocacao(x.getTempoAlocacao());
            vgeInformacoesVagaDto.setNomeIdioma(x.getNomeIdioma());
            vgeInformacoesVagaDto.setTgeHabilidadesDtolList(tgeHabilidadesDtos);

            response.add(vgeInformacoesVagaDto);
        }

        return response;

    }

    public void deletarVaga(Integer idVaga){

        validaExistenciaDaVaga(idVaga);

        LOGGER.info("Início do método deletar Vaga.");

        Integer retorno = this.vgeHabilidadeRepository.verificaVagaAssociada(idVaga);

        if (retorno > 0){
            throw new VagaAssociadaHabilidade();
        }else{
            this.vagaRepository.deleteById(idVaga);
        }
    }

    private List<VgeInformacoesVagaModel> getTodasVagas(){
        return this.vgeInformacoesVagaRepository.findAll();
    }
    private List<TgeHabilidadesDto> getListHabilidadeResponse(List<VgeHabilidadesModel> habilidades){
        LOGGER.info("Montando lista de habilidades.");
        List<TgeHabilidadesDto> response = new ArrayList<>();

        if (!habilidades.isEmpty()) {
            for (VgeHabilidadesModel habilidade : habilidades){
                TgeHabilidadesDto tgeHabilidadesDto1 = new TgeHabilidadesDto();
                tgeHabilidadesDto1.setIdHabilidade(habilidade.getIdHabilidade());
                tgeHabilidadesDto1.setNomeHabilidade(habilidade.getNomeHabilidade());

                response.add(tgeHabilidadesDto1);
            }
        }else{
            response = new ArrayList<>();
        }

        return response;
    }
    private VgeInformacoesVagaModel getVagasByIdVaga(Integer idvaga){
        VgeInformacoesVagaModel vgeInformacoesVagaModel = vgeInformacoesVagaRepository.findByIdVaga(idvaga);
        return vgeInformacoesVagaModel;
    }

    private List<VgeHabilidadesModel> getListHabilidade(Integer idVaga){
        LOGGER.info("Buscando lista de habilidades pelo  ID: {} da vaga", idVaga);
        return vgeHabilidadeRepository.findByIdVaga(idVaga);
    }

    private void validaExistenciaDaVaga(Integer idVaga){

        if(!(this.vagaRepository.existsById(idVaga))){
            throw new VagaNaoExisteException();
        }
    }

}