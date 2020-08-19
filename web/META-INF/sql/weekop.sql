-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema weekop
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema weekop
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `weekop` DEFAULT CHARACTER SET utf8 ;
USE `weekop` ;

-- -----------------------------------------------------
-- Table `weekop`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weekop`.`user` ;

CREATE TABLE IF NOT EXISTS `weekop`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `is_active` TINYINT(1) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weekop`.`discovery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weekop`.`discovery` ;

CREATE TABLE IF NOT EXISTS `weekop`.`discovery` (
  `discovery_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(250) NOT NULL,
  `url` VARCHAR(200) NOT NULL,
  `user_id` INT NOT NULL,
  `date` TIMESTAMP NOT NULL,
  `up_vote` INT NOT NULL,
  `down_vote` INT NOT NULL,
  PRIMARY KEY (`discovery_id`, `user_id`),
  UNIQUE INDEX `discovery_id_UNIQUE` (`discovery_id` ASC),
  UNIQUE INDEX `url_UNIQUE` (`url` ASC),
  INDEX `fk_discovery_user_idx` (`user_id` ASC),
  CONSTRAINT `fk_discovery_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `weekop`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weekop`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weekop`.`role` ;

CREATE TABLE IF NOT EXISTS `weekop`.`role` (
  `role_name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(120) NULL,
  UNIQUE INDEX `role_name_UNIQUE` (`role_name` ASC),
  PRIMARY KEY (`role_name`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weekop`.`vote`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weekop`.`vote` ;

CREATE TABLE IF NOT EXISTS `weekop`.`vote` (
  `vote_id` INT NOT NULL AUTO_INCREMENT,
  `discovery_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  `date` TIMESTAMP NOT NULL,
  `type` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`vote_id`, `discovery_id`, `user_id`),
  INDEX `fk_user_has_discovery_discovery1_idx` (`discovery_id` ASC),
  INDEX `fk_user_has_discovery_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_discovery_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `weekop`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_discovery_discovery1`
    FOREIGN KEY (`discovery_id`)
    REFERENCES `weekop`.`discovery` (`discovery_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `weekop`.`user_role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `weekop`.`user_role` ;

CREATE TABLE IF NOT EXISTS `weekop`.`user_role` (
  `role_name` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_name`, `username`),
  INDEX `fk_role_has_user_role1_idx` (`role_name` ASC),
  INDEX `fk_user_role_user_username_idx` (`username` ASC),
  CONSTRAINT `fk_role_has_user_role1`
    FOREIGN KEY (`role_name`)
    REFERENCES `weekop`.`role` (`role_name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_user_username`
    FOREIGN KEY (`username`)
    REFERENCES `weekop`.`user` (`username`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO user VALUES
  (null, 'admin', 'admin@gmail.com', true, '1ec0f2ffc6e70f5bae7139f383d44624'),
  (null, 'ZosiaWasilonek', 'zosia.wasilonek@gmail.com', true, '5f4dcc3b5aa765d61d8327deb882cf99');

INSERT INTO role VALUES('user', 'add new discovery');
INSERT INTO role VALUES('admin', 'all privileges user_role');

INSERT INTO user_role VALUES
  ('admin', 'admin'),
  ('user', 'ZosiaWasilonek');

INSERT INTO discovery VALUES
  (null, 'Weekop', 'Repozytorium z projektem - GitHub', 'https://github.com/ZWasilonek/Weekop', 2, NOW(), 1, 0),
  (null, 'gatesnotes', 'Fundacja Bill\'a Gates\'a','https://www.gatesnotes.com/', 1, NOW(), 2, 0),
  (null, 'Onet-Krychowiak', 'Grzegorz Krychowiak i jego paryski koszmar. Jeden z najgorszych transferów PSG', 'https://www.onet.pl/sport/onetsport/liga-mistrzow-rb-lipsk-psg-psg-to-czarny-punkt-w-karierze-grzegorza-krychowiaka-co/eqs93ms,d87b6cc4', 2, NOW(), 0, 1);

INSERT INTO vote VALUES
  (null, 1, 2, NOW(), 'VOTE_UP'),
  (null, 2, 1, NOW(), 'VOTE_UP'),
  (null, 3, 2, NOW(), 'VOTE_DOWN'),
  (null, 2, 2, NOW(), 'VOTE_UP');
