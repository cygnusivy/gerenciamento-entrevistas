-- -----------------------------------------------------
-- View `gerenciamento-entrevistas`.`vge_habilidade`
-- -----------------------------------------------------
CREATE OR REPLACE VIEW vge_habilidade AS
     SELECT h.id_habilidade,
            h.nome_habilidade,
            v.id_vaga
       FROM tge_vaga v,
            tge_habilidade h,
            tge_vinculo_habilidade_vaga vh
      where h.id_habilidade = vh.id_habilidade and
            vh.id_vaga = v.id_vaga;