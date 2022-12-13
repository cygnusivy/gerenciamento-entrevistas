package com.squad2.accenture.business;

import com.squad2.accenture.exception.RegistroJaExisteException;
import com.squad2.accenture.exception.RegistroNaoExisteException;
import com.squad2.accenture.model.TgeCandidatoModel;
import com.squad2.accenture.repository.*;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TgeCandidatoBusiness {

    @Autowired
    TgeCandidatoRepository tgeCandidatoRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(TgeCandidatoBusiness.class);

    public TgeCandidatoModel salvarCandidato(@NotNull TgeCandidatoModel candidatoModel){
        LOGGER.info("Início do método salvarCandidato().");
        if (!this.tgeCandidatoRepository.existsByCpf(candidatoModel.getCpf())){
            this.tgeCandidatoRepository.save(candidatoModel);
            return candidatoModel;
        }else{
            String concat = "Candidato de CPF: " + this.tgeCandidatoRepository.findByCpf(candidatoModel.getCpf()).getCpf() + " já existe!";
            throw  new RegistroJaExisteException(concat);
        }
    }

    public TgeCandidatoModel selecionarCandidato(String cpf){
        LOGGER.info("Início do método selecionarCandidato().");
        validaExistenciaDeCandidato(cpf);
        return this.tgeCandidatoRepository.findByCpf(cpf);
    }

    public List<TgeCandidatoModel> listarCandidatos(){
        LOGGER.info("Início do método listarCandidatos().");
        return this.tgeCandidatoRepository.findAll();
    }

    public void deletarCandidato(String cpf){
        LOGGER.info("Início do método deletarCandidato().");
        validaExistenciaDeCandidato(cpf);
        TgeCandidatoModel tgeCandidatoModel = this.tgeCandidatoRepository.findByCpf(cpf);
        this.tgeCandidatoRepository.delete(tgeCandidatoModel);
    }

    public void atualizarCandidato(String cpf, TgeCandidatoModel tgeCandidatoModel){
        LOGGER.info("Início do método atualizarCandidato().");
        validaExistenciaDeCandidato(cpf);
        TgeCandidatoModel candidatoModel = this.tgeCandidatoRepository.findByCpf(cpf);
        candidatoModel.setCodStatus(tgeCandidatoModel.getCodStatus());
        candidatoModel.setCpf(aplciaMascaraCpf(tgeCandidatoModel.getCpf()));
        candidatoModel.setNome(tgeCandidatoModel.getNome());
        candidatoModel.setEmail(tgeCandidatoModel.getEmail());
        candidatoModel.setNotaSql(tgeCandidatoModel.getNotaSql());
        candidatoModel.setNotaIngles(tgeCandidatoModel.getNotaIngles());
        candidatoModel.setNotaLogica(tgeCandidatoModel.getNotaLogica());
        candidatoModel.setDescricaoTecnica(tgeCandidatoModel.getDescricaoTecnica());
        candidatoModel.setVagasIdVaga(tgeCandidatoModel.getVagasIdVaga());
        candidatoModel.setPretencaoSalario(tgeCandidatoModel.getPretencaoSalario());
        candidatoModel.setIdSenioridade(tgeCandidatoModel.getIdSenioridade());
        this.tgeCandidatoRepository.save(candidatoModel);

    }

    private void validaExistenciaDeCandidato(String cpf){
        LOGGER.info("Início do método validaExistenciaDeCandidato().");
        if(!this.tgeCandidatoRepository.existsByCpf(cpf)){
            String concat = "Candidato de CPF: " + cpf + " não existe na base de dados. Inisra um cpf diferente.";
            throw new RegistroNaoExisteException(concat);
        }
    }

    private String aplciaMascaraCpf(String cpf){
        String sbst1 = cpf.substring(0, 2);
        String sbst2 = cpf.substring(3, 5);
        String sbst3 = cpf.substring(6, 8);
        String sbst4 = cpf.substring(9, 10);
        String concat = sbst1 + "." + sbst2 + "." + sbst3 + "-" + sbst3;
        return concat;
    }
}