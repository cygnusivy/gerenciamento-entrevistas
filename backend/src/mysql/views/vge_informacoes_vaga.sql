-- -----------------------------------------------------
-- View `gerenciamento-entrevistas`.`vge_informacoes_vaga`
-- -----------------------------------------------------
CREATE OR REPLACE VIEW vge_informacoes_vaga AS
     SELECT v.id_vaga,
            v.nome_vaga,
            v.temp_alocacao,
            v.localidade,
            v.descricao,
            i.nome_idioma
       FROM tge_vaga v,
            tge_idioma i
      where i.id_idioma = v.id_idioma;