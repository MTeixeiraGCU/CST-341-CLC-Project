-- MySQL Script generated by MySQL Workbench
-- Fri May  7 19:25:10 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cst-341-clcproject
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cst-341-clcproject` ;

-- -----------------------------------------------------
-- Schema cst-341-clcproject
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cst-341-clcproject` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `cst-341-clcproject` ;

-- -----------------------------------------------------
-- Table `cst-341-clcproject`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cst-341-clcproject`.`users` ;

CREATE TABLE IF NOT EXISTS `cst-341-clcproject`.`users` (
  `FIRST_NAME` VARCHAR(45) NULL DEFAULT NULL,
  `LAST_NAME` VARCHAR(45) NULL DEFAULT NULL,
  `EMAIL` VARCHAR(45) NULL DEFAULT NULL,
  `PHONE_NUMBER` VARCHAR(45) NULL DEFAULT NULL,
  `USER_NAME` VARCHAR(45) NOT NULL,
  `PASSWORD` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`USER_NAME`),
  UNIQUE INDEX `USER_NAME_UNIQUE` (`USER_NAME` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;