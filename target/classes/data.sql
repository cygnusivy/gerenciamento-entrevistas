DELETE FROM tge_vinculo_habilidade_vaga;
DELETE FROM tge_habilidade;
DELETE FROM tge_vaga;
DELETE FROM tge_idioma;

INSERT INTO tge_idioma (nome_idioma) VALUES ('Português');
INSERT INTO tge_idioma (nome_idioma) VALUES ('Espanhol');
INSERT INTO tge_idioma (nome_idioma) VALUES ('Inglês');
INSERT INTO tge_idioma (nome_idioma) VALUES ('Francês');
INSERT INTO tge_idioma (nome_idioma) VALUES ('Chinês');
INSERT INTO tge_idioma (nome_idioma) VALUES ('Coreano');
INSERT INTO tge_idioma (nome_idioma) VALUES ('Alemão');
INSERT INTO tge_idioma (nome_idioma) VALUES ('Russo');
INSERT INTO tge_idioma (nome_idioma) VALUES ('Turco');

INSERT INTO tge_vaga (nome_vaga, temp_alocacao, id_idioma, localidade, descricao) VALUES ('Analista de Sistemas Java Júnior', '2023-12-31', 1, 'Recife', '--');
INSERT INTO tge_vaga (nome_vaga, temp_alocacao, id_idioma, localidade, descricao) VALUES ('Analista de Sistemas Java Pleno', '2023-12-31', 2, 'Camaragibe', '--');
INSERT INTO tge_vaga (nome_vaga, temp_alocacao, id_idioma, localidade, descricao) VALUES ('Analista de Sistemas Java Sênior', '2023-12-31', 3, 'Olinda', '--');
INSERT INTO tge_vaga (nome_vaga, temp_alocacao, id_idioma, localidade, descricao) VALUES ('Especialista', '2023-12-31', 8, 'Remoto', '--');


INSERT INTO tge_habilidade (nome_habilidade) VALUES ('SQL');
INSERT INTO tge_habilidade (nome_habilidade) VALUES ('JAVA');
INSERT INTO tge_habilidade (nome_habilidade) VALUES ('PLSQL');
INSERT INTO tge_habilidade (nome_habilidade) VALUES ('Spring Boot');
INSERT INTO tge_habilidade (nome_habilidade) VALUES ('Spring Data Jpa');
INSERT INTO tge_habilidade (nome_habilidade) VALUES ('Banco de Dados Oracle');
INSERT INTO tge_habilidade (nome_habilidade) VALUES ('PHP');
INSERT INTO tge_habilidade (nome_habilidade) VALUES ('JavaScript');
INSERT INTO tge_habilidade (nome_habilidade) VALUES ('Python');

INSERT INTO tge_vinculo_habilidade_vaga (id_habilidade, id_vaga) VALUES (1, 1);
INSERT INTO tge_vinculo_habilidade_vaga (id_habilidade, id_vaga) VALUES (2, 1);
INSERT INTO tge_vinculo_habilidade_vaga (id_habilidade, id_vaga) VALUES (3, 1);

INSERT INTO tge_vinculo_habilidade_vaga (id_habilidade, id_vaga) VALUES (2, 3);
INSERT INTO tge_vinculo_habilidade_vaga (id_habilidade, id_vaga) VALUES (3, 3);
INSERT INTO tge_vinculo_habilidade_vaga (id_habilidade, id_vaga) VALUES (4, 3);
INSERT INTO tge_vinculo_habilidade_vaga (id_habilidade, id_vaga) VALUES (5, 3);
INSERT INTO tge_vinculo_habilidade_vaga (id_habilidade, id_vaga) VALUES (6, 3);
INSERT INTO tge_vinculo_habilidade_vaga (id_habilidade, id_vaga) VALUES (1, 3);

INSERT INTO tge_vinculo_habilidade_vaga (id_habilidade, id_vaga) VALUES (1, 2);
INSERT INTO tge_vinculo_habilidade_vaga (id_habilidade, id_vaga) VALUES (3, 2);
INSERT INTO tge_vinculo_habilidade_vaga (id_habilidade, id_vaga) VALUES (6, 2);
INSERT INTO tge_vinculo_habilidade_vaga (id_habilidade, id_vaga) VALUES (5, 2);