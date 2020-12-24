-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema futurex
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema futurex
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `futurex` DEFAULT CHARACTER SET utf8 ;
USE `futurex` ;

-- -----------------------------------------------------
-- Table `futurex`.`station`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `futurex`.`station` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `futurex`.`train`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `futurex`.`train` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `futurex`.`wagon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `futurex`.`wagon` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `train_id` INT NOT NULL,
  `name` INT NOT NULL,
  `count_of_people` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_wagon_train_idx` (`train_id` ASC) VISIBLE,
  CONSTRAINT `fk_wagon_train`
    FOREIGN KEY (`train_id`)
    REFERENCES `futurex`.`train` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `futurex`.`direction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `futurex`.`direction` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `futurex`.`train_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `futurex`.`train_details` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `train_id` INT NOT NULL,
  `station_id` INT NOT NULL,
  `direction_id` INT NOT NULL,
  `distance_time` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_train_details_station1_idx` (`station_id` ASC) VISIBLE,
  INDEX `fk_train_details_train1_idx` (`train_id` ASC) VISIBLE,
  INDEX `fk_train_details_direction1_idx` (`direction_id` ASC) VISIBLE,
  CONSTRAINT `fk_train_details_station1`
    FOREIGN KEY (`station_id`)
    REFERENCES `futurex`.`station` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_train_details_train1`
    FOREIGN KEY (`train_id`)
    REFERENCES `futurex`.`train` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_train_details_direction1`
    FOREIGN KEY (`direction_id`)
    REFERENCES `futurex`.`direction` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
