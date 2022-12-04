-- -----------------------------------------------------
-- INSERT INTO `gerenciamento-entrevistas`.`tge_idioma`
-- -----------------------------------------------------
INSERT INTO tge_idioma (id_idioma, nome_idioma) VALUES (1, 'Português');
INSERT INTO tge_idioma (id_idioma, nome_idioma) VALUES (2, 'Espanhol');
INSERT INTO tge_idioma (id_idioma, nome_idioma) VALUES (3, 'Inglês');
INSERT INTO tge_idioma (id_idioma, nome_idioma) VALUES (4, 'Francês');
INSERT INTO tge_idioma (id_idioma, nome_idioma) VALUES (5, 'Chinês');
INSERT INTO tge_idioma (id_idioma, nome_idioma) VALUES (6, 'Coreano');
INSERT INTO tge_idioma (id_idioma, nome_idioma) VALUES (7, 'Alemão');
INSERT INTO tge_idioma (id_idioma, nome_idioma) VALUES (8, 'Russo');
INSERT INTO tge_idioma (id_idioma, nome_idioma) VALUES (9, 'Turco');

-- -----------------------------------------------------
-- INSERT INTO `gerenciamento-entrevistas`.`tge_vaga`
-- -----------------------------------------------------
INSERT INTO tge_vaga (id_vaga, nome_vaga, temp_alocacao, id_idioma, localidade, descricao) VALUES (1, 'Analista de Sistemas Java Júnior', '2023-12-31', 1, 'Recife', '--');
INSERT INTO tge_vaga (id_vaga, nome_vaga, temp_alocacao, id_idioma, localidade, descricao) VALUES (2, 'Analista de Sistemas Java Pleno', '2023-12-31', 2, 'Camaragibe', '--');
INSERT INTO tge_vaga (id_vaga, nome_vaga, temp_alocacao, id_idioma, localidade, descricao) VALUES (3, 'Analista de Sistemas Java Sênior', '2023-12-31', 3, 'Olinda', '--');

-- --------------------------------------------------------
-- INSERT INTO `gerenciamento-entrevistas`.`tge_habilidade`
-- --------------------------------------------------------
INSERT INTO tge_habilidade (id_habilidade, nome_habilidade) VALUES (1, 'SQL');
INSERT INTO tge_habilidade (id_habilidade, nome_habilidade) VALUES (2, 'JAVA');
INSERT INTO tge_habilidade (id_habilidade, nome_habilidade) VALUES (3, 'PLSQL');
INSERT INTO tge_habilidade (id_habilidade, nome_habilidade) VALUES (4, 'Spring Boot');
INSERT INTO tge_habilidade (id_habilidade, nome_habilidade) VALUES (5, 'Spring Data Jpa');
INSERT INTO tge_habilidade (id_habilidade, nome_habilidade) VALUES (6, 'Banco de Dados Oracle');
INSERT INTO tge_habilidade (id_habilidade, nome_habilidade) VALUES (7, 'PHP');
INSERT INTO tge_habilidade (id_habilidade, nome_habilidade) VALUES (8, 'JavaScript');
INSERT INTO tge_habilidade (id_habilidade, nome_habilidade) VALUES (9, 'Python');

-- ---------------------------------------------------------------------
-- INSERT INTO `gerenciamento-entrevistas`.`tge_vinculo_habilidade_vaga`
-- ---------------------------------------------------------------------
INSERT INTO tge_vinculo_habilidade_vaga (id_vinculo, id_habilidade, id_vaga) VALUES (1, 1, 1);
INSERT INTO tge_vinculo_habilidade_vaga (id_vinculo, id_habilidade, id_vaga) VALUES (2, 2, 1);
INSERT INTO tge_vinculo_habilidade_vaga (id_vinculo, id_habilidade, id_vaga) VALUES (3, 3, 1);

INSERT INTO tge_vinculo_habilidade_vaga (id_vinculo, id_habilidade, id_vaga) VALUES (4, 2, 3);
INSERT INTO tge_vinculo_habilidade_vaga (id_vinculo, id_habilidade, id_vaga) VALUES (5, 3, 3);
INSERT INTO tge_vinculo_habilidade_vaga (id_vinculo, id_habilidade, id_vaga) VALUES (6, 4, 3);
INSERT INTO tge_vinculo_habilidade_vaga (id_vinculo, id_habilidade, id_vaga) VALUES (7, 5, 3);
INSERT INTO tge_vinculo_habilidade_vaga (id_vinculo, id_habilidade, id_vaga) VALUES (8, 6, 3);
INSERT INTO tge_vinculo_habilidade_vaga (id_vinculo, id_habilidade, id_vaga) VALUES (9, 1, 3);