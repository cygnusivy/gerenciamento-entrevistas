SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gerenciamento-entrevistas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gerenciamento-entrevistas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gerenciamento-entrevistas` DEFAULT CHARACTER SET utf8 ;
USE `gerenciamento-entrevistas` ;

-- -----------------------------------------------------
-- Table `gerenciamento-entrevistas`.`tge_idioma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciamento-entrevistas`.`tge_idioma` (
  `id_idioma` INT NOT NULL,
  `nome_idioma` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_idioma`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `gerenciamento-entrevistas`.`tge_vaga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciamento-entrevistas`.`tge_vaga` (
  `id_vaga` INT NOT NULL,
  `nome_vaga` VARCHAR(45) NOT NULL,
  `temp_alocacao` DATE NOT NULL,
  `id_idioma` INT NOT NULL,
  `localidade` VARCHAR(45) NOT NULL,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`id_vaga`),
  CONSTRAINT `fk_vaga_idioma`
        FOREIGN KEY (`id_idioma`)
        REFERENCES `gerenciamento-entrevistas`.`tge_idioma` (`id_idioma`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `gerenciamento-entrevistas`.`tge_habilidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciamento-entrevistas`.`tge_habilidade` (
  `id_habilidade` INT NOT NULL,
  `nome_habilidade` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_habilidade`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `gerenciamento-entrevistas`.`tge_vinculo_habilidade_vaga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciamento-entrevistas`.`tge_vinculo_habilidade_vaga` (
  `id_vinculo` INT NOT NULL,
  `id_habilidade` INT NOT NULL,
  `id_vaga` INT NOT NULL,
  PRIMARY KEY (`id_vinculo`),
  CONSTRAINT `fk_vinculo_habilidade`
      FOREIGN KEY (`id_habilidade`)
      REFERENCES `gerenciamento-entrevistas`.`tge_habilidade` (`id_habilidade`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_vinculo_vaga`
      FOREIGN KEY (`id_vaga`)
      REFERENCES `gerenciamento-entrevistas`.`tge_vaga` (`id_vaga`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `gerenciamento-entrevistas`.`tge_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciamento-entrevistas`.`tge_status` (
  `id_status` INT NOT NULL,
  `nome_status` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`id_status`),
  UNIQUE INDEX `status_UNIQUE` (`nome_status` ASC))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `gerenciamento-entrevistas`.`tge_senioridade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciamento-entrevistas`.`tge_senioridade` (
  `id_senioridade` INT NOT NULL,
  `nome_senioridade` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`id_senioridade`),
  UNIQUE INDEX `senioridade_UNIQUE` (`nome_senioridade` ASC))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `gerenciamento-entrevistas`.`tge_candidado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciamento-entrevistas`.`tge_candidado` (
  `cpf` VARCHAR(15) NOT NULL,
  `nome` VARCHAR(60) NOT NULL,
  `descricao_tecnica` VARCHAR(2000) NULL,
  `email` VARCHAR(100) NOT NULL,
  `pretencao_salario` DECIMAL(7,2) NOT NULL,
  `nota_ingles` DECIMAL(4,2) NOT NULL,
  `nota_logica` DECIMAL(4,2) NOT NULL,
  `nota_sql` DECIMAL(4,2) NOT NULL,
  `id_senioridade` INT NOT NULL,
  `status_id_status` INT NOT NULL,
  `vagas_id_vaga` INT NOT NULL,
  PRIMARY KEY (`cpf`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC),
  UNIQUE INDEX `nome_UNIQUE` (`nome` ASC),
  INDEX `fk_candidato_vagas1_idx` (`vagas_id_vaga` ASC),
  CONSTRAINT `fk_candidato_vagas1`
    FOREIGN KEY (`vagas_id_vaga`)
    REFERENCES `gerenciamento-entrevistas`.`tge_vaga` (`id_vaga`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_candidato_status`
      FOREIGN KEY (`status_id_status`)
      REFERENCES `gerenciamento-entrevistas`.`tge_status` (`id_status`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
  CONSTRAINT `fk_senioridade_status`
        FOREIGN KEY (`id_senioridade`)
        REFERENCES `gerenciamento-entrevistas`.`tge_senioridade` (`id_senioridade`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `gerenciamento-entrevistas`.`tge_entrevista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciamento-entrevistas`.`tge_entrevista` (
  `data_entrevista` DATETIME NOT NULL,
  `candidato_cpf` VARCHAR(15) NOT NULL,
  `descr_habilidades_tecnicas` TEXT(200) NOT NULL,
  `descr_habilidades_interpessoal` TEXT(200) NOT NULL,
  PRIMARY KEY (`data_entrevista`),
  INDEX `fk_entrevista_candidato1_idx` (`candidato_cpf` ASC),
  CONSTRAINT `fk_entrevista_candidato1`
    FOREIGN KEY (`candidato_cpf`)
    REFERENCES `gerenciamento-entrevistas`.`tge_candidado` (`cpf`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gerenciamento-entrevistas`.`tge_endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciamento-entrevistas`.`tge_endereco` (
  `id_endereco` INT NOT NULL,
  `candidato_cpf` VARCHAR(15) NOT NULL,
  `uf` VARCHAR(2) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `bairro` VARCHAR(45) NOT NULL,
  `rua` VARCHAR(45) NOT NULL,
  `numero` INT NOT NULL,
  PRIMARY KEY (`id_endereco`),
  INDEX `fk_endereco_candidato_idx` (`candidato_cpf` ASC),
  CONSTRAINT `fk_endereco_candidato`
    FOREIGN KEY (`candidato_cpf`)
    REFERENCES `gerenciamento-entrevistas`.`tge_candidado` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gerenciamento-entrevistas`.`tge_telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gerenciamento-entrevistas`.`tge_telefone` (
  `idtelefone` INT NOT NULL,
  `candidato_cpf` VARCHAR(15) NULL,
  `numero` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`idtelefone`),
  INDEX `fk_telefone_candidato1_idx` (`candidato_cpf` ASC),
  CONSTRAINT `fk_telefone_candidato1`
    FOREIGN KEY (`candidato_cpf`)
    REFERENCES `gerenciamento-entrevistas`.`tge_candidado` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

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

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;