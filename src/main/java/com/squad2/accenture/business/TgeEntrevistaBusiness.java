package com.squad2.accenture.business;

import com.squad2.accenture.exception.RegistroJaExisteException;
import com.squad2.accenture.model.TgeEntrevistaModel;
import com.squad2.accenture.repository.TgeEntrevistaRepository;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TgeEntrevistaBusiness {

    @Autowired
    TgeEntrevistaRepository entrevistaRepository;

    private final Logger LOGGER = LoggerFactory.getLogger(TgeEntrevistaBusiness.class);

    public TgeEntrevistaModel selecionarEntrevista(Integer idEntrevista){
        LOGGER.info("Início do método selecionarEntrevista().");
        verificaExistenciaDeEntrevista(idEntrevista);

        return this.entrevistaRepository.findById(idEntrevista).get();
    }

    public TgeEntrevistaModel salvarEntrevista(@NotNull TgeEntrevistaModel tgeEntrevistaModel){
        LOGGER.info("Início do método salvarEntrevista().");
        tgeEntrevistaModel.setIdEntrevista(0);
        if(!this.entrevistaRepository.existsById(tgeEntrevistaModel.getIdEntrevista())){
            this.entrevistaRepository.save(tgeEntrevistaModel);
            return tgeEntrevistaModel;
        }else{
            String concat = "Entrevista de ID: "+ tgeEntrevistaModel.getIdEntrevista() + " já existe";
            throw new RegistroJaExisteException(concat);
        }
    }

    public TgeEntrevistaModel atualizarEntrevista(Integer id, TgeEntrevistaModel tgeEntrevistaModel){
        LOGGER.info("Início do método atualizarEntrevista().");
        TgeEntrevistaModel TgeEntrevistaModel = this.entrevistaRepository.findById(id).get();

        TgeEntrevistaModel.setDataEntrevista(tgeEntrevistaModel.getDataEntrevista());
        TgeEntrevistaModel.setCandidatoCpf(aplciaMascaraCpf(tgeEntrevistaModel.getCandidatoCpf()));
        TgeEntrevistaModel.setDescHabilidadesTecnicas(tgeEntrevistaModel.getDescHabilidadesTecnicas());
        TgeEntrevistaModel.setCodStatus(tgeEntrevistaModel.getCodStatus());
        TgeEntrevistaModel.setDescHabilidadesInterpessoais(tgeEntrevistaModel.getDescHabilidadesInterpessoais());

        this.entrevistaRepository.save(TgeEntrevistaModel);
        return TgeEntrevistaModel;
    }

    public List<TgeEntrevistaModel> tgeEntrevistaModelList(){
        LOGGER.info("Início do método tgeEntrevistaModelList().");
       return this.entrevistaRepository.findAll();
    }

    public void deletarEntrevista(Integer id){
        LOGGER.info("Início do método deletarEntrevista().");
        verificaExistenciaDeEntrevista(id);
        this.entrevistaRepository.delete(this.entrevistaRepository.findById(id).get());
    }
    public void verificaExistenciaDeEntrevista(Integer idEntrevista){
        LOGGER.info("Início do método verificaExistenciaDeEntrevista().");
        if (!this.entrevistaRepository.existsById(idEntrevista)){
            String concat = "Entrevista de ID: " + idEntrevista;
            throw new RegistroJaExisteException(concat);
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
