package com.squad2.accenture.business;

import com.squad2.accenture.dto.TgeHabilidadesDto;
import com.squad2.accenture.dto.VgeInformacoesVagaDto;
import com.squad2.accenture.model.TgeHabilidadesModel;
import com.squad2.accenture.model.VgeInformacoesVagaModel;
import com.squad2.accenture.repository.VgeInformacoesVagaRepository;
import com.squad2.accenture.repository.VgeHabilidadeRepository;
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

    private final Logger LOGGER = LoggerFactory.getLogger(VagaBusiness.class);
    public VgeInformacoesVagaDto getVagas(Integer idVaga){
        LOGGER.info("Início do método getVagas para vaga de ID  ID: {}", idVaga);
        VgeInformacoesVagaModel vgeInformacoesVagaModel = getVagasByIdVaga(idVaga);

        List<TgeHabilidadesModel> tgeHabilidadesModelList = getListHabilidade(idVaga);

        VgeInformacoesVagaDto response = new VgeInformacoesVagaDto();

        response.setIdVaga(vgeInformacoesVagaModel.getIdVaga());
        response.setNomeVaga(vgeInformacoesVagaModel.getNomeVaga());
        response.setTempoAlocacao(vgeInformacoesVagaModel.getTempoAlocacao());
        response.setDescricao(vgeInformacoesVagaModel.getDescricao());
        response.setLocalidade(vgeInformacoesVagaModel.getLocalidade());
        response.setTgeHabilidadesDtolList(getListHabilidadeResponse(tgeHabilidadesModelList));

        return response;

    }

    private List<TgeHabilidadesDto> getListHabilidadeResponse(List<TgeHabilidadesModel> habilidades){
        LOGGER.info("Montando lista de habilidades.");
        List<TgeHabilidadesDto> response = new ArrayList<>();

        if (!habilidades.isEmpty()) {
            for (TgeHabilidadesModel habilidade : habilidades){
                TgeHabilidadesDto tgeHabilidadesDto1 = new TgeHabilidadesDto();
                tgeHabilidadesDto1.setIdHabilidade(habilidade.getIdHabilidade());
                tgeHabilidadesDto1.setIdVaga(habilidade.getIdVaga());
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

    private List<TgeHabilidadesModel> getListHabilidade(Integer idVaga){
        LOGGER.info("Buscando lista de habilidades pelo  ID: {} da vaga", idVaga);
        return vgeHabilidadeRepository.findByIdVaga(idVaga);
    }

}