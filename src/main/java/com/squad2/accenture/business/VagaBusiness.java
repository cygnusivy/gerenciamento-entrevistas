package com.squad2.accenture.business;

import com.squad2.accenture.dto.TgeIdiomaDto;
import com.squad2.accenture.exception.RegistroExisteException;
import com.squad2.accenture.exception.VagaAssociadaHabilidade;
import com.squad2.accenture.exception.VagaNaoExisteException;
import com.squad2.accenture.dto.TgeHabilidadesDto;
import com.squad2.accenture.dto.VgeInformacoesVagaDto;
import com.squad2.accenture.model.TgeVagaModel;
import com.squad2.accenture.model.VgeHabilidadesModel;
import com.squad2.accenture.model.VgeIdiomaModel;
import com.squad2.accenture.model.VgeInformacoesVagaModel;
import com.squad2.accenture.repository.VgeIdiomaRepository;
import com.squad2.accenture.repository.VgeInformacoesVagaRepository;
import com.squad2.accenture.repository.VgeHabilidadeRepository;
import com.squad2.accenture.repository.TgeVagaRepository;
import org.jetbrains.annotations.NotNull;
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

    @Autowired
    VgeIdiomaRepository vgeIdiomaRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(VagaBusiness.class);
    public TgeVagaModel salvarVaga(@NotNull TgeVagaModel vagaModel){
        LOGGER.info(String.format("Início do método salvarVaga()"));
        vagaModel.setIdVaga(0);
        if (!this.vagaRepository.existsByNomeVaga(vagaModel.getNomeVaga())){
            LOGGER.info(String.format("Vaga " + vagaModel.getNomeVaga() + " salva com sucesso"));
            this.vagaRepository.save(vagaModel);
            return vagaModel;
        }else{
            String concat = "Vaga " + this.vagaRepository.findByNomeVaga(vagaModel.getNomeVaga()).getNomeVaga();
            throw new RegistroExisteException(concat);
        }
    }

    public VgeInformacoesVagaDto selecionarVaga(Integer idVaga){
        LOGGER.info("Início do método getVagas para vaga de ID  ID: {}", idVaga);
        validaExistenciaDaVaga(idVaga);


        VgeInformacoesVagaModel vgeInformacoesVagaModel = selecionarVagaPeloId(idVaga);

        List<VgeHabilidadesModel> vgeHabilidadesModelList = getListHabilidade(idVaga);

        List<VgeIdiomaModel> vgeIdiomaModelList = vgeIdiomaModelList(idVaga);

        VgeInformacoesVagaDto response = new VgeInformacoesVagaDto();

        response.setIdVaga(vgeInformacoesVagaModel.getIdVaga());
        response.setNomeVaga(vgeInformacoesVagaModel.getNomeVaga());
        response.setTempoAlocacao(vgeInformacoesVagaModel.getTempoAlocacao());
        response.setDescricao(vgeInformacoesVagaModel.getDescricao());
        response.setLocalidade(vgeInformacoesVagaModel.getLocalidade());
        response.setTgeIdiomaDtoList(tgeIdiomaDtoList(vgeIdiomaModelList));
        response.setTgeHabilidadesDtolList(getListHabilidadeResponse(vgeHabilidadesModelList));

        return response;

    }

    public List<VgeInformacoesVagaDto> listarTodasVagas(){
        LOGGER.info("Início do método listarTodasAsVagas");
        List<VgeInformacoesVagaModel> vgeInformacoesVagaModel = getTodasVagas();

        List<VgeInformacoesVagaDto> response = new ArrayList<>();

        for(VgeInformacoesVagaModel x : vgeInformacoesVagaModel){

            VgeInformacoesVagaDto vgeInformacoesVagaDto = new VgeInformacoesVagaDto();
            List<VgeHabilidadesModel> vgeHabilidadesModelList = getListHabilidade(x.getIdVaga());
            List<TgeHabilidadesDto> tgeHabilidadesDtos = getListHabilidadeResponse(vgeHabilidadesModelList);
            List<VgeIdiomaModel> vgeIdiomaModelList = vgeIdiomaModelList(x.getIdVaga());
            List<TgeIdiomaDto> tgeIdiomaDtos = tgeIdiomaDtoList(vgeIdiomaModelList);

            vgeInformacoesVagaDto.setIdVaga(x.getIdVaga());
            vgeInformacoesVagaDto.setNomeVaga(x.getNomeVaga());
            vgeInformacoesVagaDto.setDescricao(x.getDescricao());
            vgeInformacoesVagaDto.setLocalidade(x.getLocalidade());
            vgeInformacoesVagaDto.setTempoAlocacao(x.getTempoAlocacao());
            vgeInformacoesVagaDto.setTgeIdiomaDtoList(tgeIdiomaDtos);
            vgeInformacoesVagaDto.setTgeHabilidadesDtolList(tgeHabilidadesDtos);

            response.add(vgeInformacoesVagaDto);
        }

        return response;

    }

    public void deletarVaga(Integer idVaga){
        LOGGER.info("Início do método deletarVaga().");
        validaExistenciaDaVaga(idVaga);

        Integer retorno = this.vgeHabilidadeRepository.verificaVagaAssociada(idVaga);

        if (retorno > 0){
            throw new VagaAssociadaHabilidade(this.vagaRepository.findById(idVaga).get().getNomeVaga());
        }else{
            LOGGER.info("Vaga deletada com sucesso.");
            this.vagaRepository.deleteById(idVaga);
        }
    }

    private List<VgeInformacoesVagaModel> getTodasVagas(){
        LOGGER.info("Selecionando todas as vagas.");
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
    private List<TgeIdiomaDto> tgeIdiomaDtoList(List<VgeIdiomaModel> idiomas){
        LOGGER.info("Montando lista de idiomas.");
        List<TgeIdiomaDto> response = new ArrayList<>();

        if (!idiomas.isEmpty()) {
            for (VgeIdiomaModel idioma : idiomas){
                TgeIdiomaDto tgeIdiomaDto = new TgeIdiomaDto();
                tgeIdiomaDto.setIdIdioma(idioma.getIdIdioma());
                tgeIdiomaDto.setIdioma(idioma.getIdioma());

                response.add(tgeIdiomaDto);
            }
        }else{
            response = new ArrayList<>();
        }

        return response;
    }
    private VgeInformacoesVagaModel selecionarVagaPeloId(Integer idvaga){
        LOGGER.info("Inicío do método selecionarVagaPeloId()");
        VgeInformacoesVagaModel vgeInformacoesVagaModel = vgeInformacoesVagaRepository.findByIdVaga(idvaga);
        return vgeInformacoesVagaModel;
    }

    private List<VgeHabilidadesModel> getListHabilidade(Integer idVaga){
        LOGGER.info("Buscando lista de habilidades pelo  ID: {} da vaga", idVaga);
        return vgeHabilidadeRepository.findByIdVaga(idVaga);
    }

    private List<VgeIdiomaModel> vgeIdiomaModelList(Integer idVaga){
        LOGGER.info("Buscando lista de idiomas pelo  ID: {} da vaga", idVaga);
        return vgeIdiomaRepository.findByIdVaga(idVaga);
    }

    private void validaExistenciaDaVaga(Integer idVaga){
        LOGGER.info("Início do método validaExistenciaDaVaga().");
        if(!(this.vagaRepository.existsById(idVaga))){
            throw new VagaNaoExisteException();
        }
    }

}