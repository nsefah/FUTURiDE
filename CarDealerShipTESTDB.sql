-- -----------------------------------------------------
-- Schema CarDealershipTest
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `CarDealershipTest` ;

-- -----------------------------------------------------
-- Schema CarDealershipTest
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CarDealershipTest` DEFAULT CHARACTER SET utf8 ;
USE `CarDealershipTest` ;

-- -----------------------------------------------------
-- Table `CarDealershipTest`.`Makes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealershipTest`.`make` ;

CREATE TABLE IF NOT EXISTS `CarDealershipTest`.`make` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `make` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealershipTest`.`BodyStyles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealershipTest`.`type` ;

CREATE TABLE IF NOT EXISTS `CarDealershipTest`.`type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealershipTest`.`ExteriorColors`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealershipTest`.`exteriorcolor` ;

CREATE TABLE IF NOT EXISTS `CarDealershipTest`.`exteriorcolor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `exteriorcolor` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealershipTest`.`BodyStyles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealershipTest`.`bodystyle` ;

CREATE TABLE IF NOT EXISTS `CarDealershipTest`.`bodystyle` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bodystyle` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealershipTest`.`Transmissions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealershipTest`.`transmission` ;

CREATE TABLE IF NOT EXISTS `CarDealershipTest`.`transmission` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `transmission` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealershipTest`.`InteriorColors`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealershipTest`.`interiorcolor` ;

CREATE TABLE IF NOT EXISTS `CarDealershipTest`.`interiorcolor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `interiorcolor` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealershipTest`.`Models`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealershipTest`.`model` ;

CREATE TABLE IF NOT EXISTS `CarDealershipTest`.`model` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(45) NOT NULL UNIQUE,
  `makeid` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Models_Makes1_idx` (`makeid` ASC),
  CONSTRAINT `fk_Models_Makes1`
    FOREIGN KEY (`makeid`)
    REFERENCES `CarDealershipTest`.`make` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealershipTest`.`Vehicles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealershipTest`.`vehicle` ;

CREATE TABLE IF NOT EXISTS `CarDealershipTest`.`vehicle` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `makeid` INT NOT NULL,
  `modelid` INT NOT NULL,
  `typeid` INT NOT NULL,
  `exteriorcolorid` INT NOT NULL,
  `bodystyleid` INT NOT NULL,
  `transmissionid` INT NOT NULL,
  `interiorcolorid` INT NOT NULL,
  `year` YEAR NOT NULL,
  `mileage` INT NOT NULL,
  `vinnum` VARCHAR(45) NOT NULL,
  `msrp` DOUBLE NOT NULL,
  `salesprice` DOUBLE NOT NULL,
  `description` MEDIUMTEXT NOT NULL,
  `isfeatured` TINYINT(1) NOT NULL,
  `isavailable` TINYINT(1) NOT NULL,
  `imagepath` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Vehicles_Makes_idx` (`makeid` ASC),
  INDEX `fk_Vehicles_Types1_idx` (`typeid` ASC),
  INDEX `fk_Vehicles_ExteriorColors1_idx` (`exteriorcolorid` ASC),
  INDEX `fk_Vehicles_BodyStyles1_idx` (`bodystyleid` ASC),
  INDEX `fk_Vehicles_Transmissions1_idx` (`transmissionid` ASC),
  INDEX `fk_Vehicles_InteriorColors1_idx` (`interiorcolorid` ASC),
  INDEX `fk_Vehicles_Models1_idx` (`modelid` ASC),
  CONSTRAINT `fk_Vehicles_Makes`
    FOREIGN KEY (`makeid`)
    REFERENCES `CarDealershipTest`.`make` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicles_Types1`
    FOREIGN KEY (`typeid`)
    REFERENCES `CarDealershipTest`.`type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicles_ExteriorColors1`
    FOREIGN KEY (`exteriorcolorid`)
    REFERENCES `CarDealershipTest`.`exteriorcolor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicles_BodyStyles1`
    FOREIGN KEY (`bodystyleid`)
    REFERENCES `CarDealershipTest`.`bodystyle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicles_Transmissions1`
    FOREIGN KEY (`transmissionid`)
    REFERENCES `CarDealershipTest`.`transmission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicles_InteriorColors1`
    FOREIGN KEY (`interiorcolorid`)
    REFERENCES `CarDealershipTest`.`interiorcolor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicles_Models1`
    FOREIGN KEY (`modelid`)
    REFERENCES `CarDealershipTest`.`model` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealershipTest`.`Contacts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealershipTest`.`contact` ;

CREATE TABLE IF NOT EXISTS `CarDealershipTest`.`contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `message` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealershipTest`.`Specials`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealershipTest`.`special` ;

CREATE TABLE IF NOT EXISTS `CarDealershipTest`.`special` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealershipTest`.`Roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealershipTest`.`role` ;

CREATE TABLE IF NOT EXISTS `CarDealershipTest`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealershipTest`.`States`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealershipTest`.`state` ;

CREATE TABLE IF NOT EXISTS `CarDealershipTest`.`state` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `state` CHAR(2) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealershipTest`.`PurchaseTypes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealershipTest`.`purchasetype` ;

CREATE TABLE IF NOT EXISTS `CarDealershipTest`.`purchasetype` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `purchasetype` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealershipTest`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealershipTest`.`user` ;

CREATE TABLE IF NOT EXISTS `CarDealershipTest`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealershipTest`.`Sales`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealershipTest`.`sale` ;

CREATE TABLE IF NOT EXISTS `CarDealershipTest`.`sale` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `purchaser` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `street 1` VARCHAR(45) NOT NULL,
  `street 2` VARCHAR(45) NULL,
  `city` VARCHAR(45) NOT NULL,
  `zipcode` INT(5) NOT NULL,
  `purchaseprice` DOUBLE NOT NULL,
  `purchasedate` DATETIME NOT NULL DEFAULT NOW(),
  `stateid` INT NOT NULL,
  `purchasetypeid` INT NOT NULL,
  `vehicleid` INT NOT NULL,
  `userid` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Sales_States1_idx` (`stateid` ASC),
  INDEX `fk_Sales_PurchaseTypes1_idx` (`purchasetypeid` ASC),
  INDEX `fk_Sales_Vehicles1_idx` (`vehicleid` ASC),
  INDEX `fk_Sales_Users1_idx` (`userid` ASC),
  CONSTRAINT `fk_Sales_States1`
    FOREIGN KEY (`stateid`)
    REFERENCES `CarDealershipTest`.`state` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sales_PurchaseTypes1`
    FOREIGN KEY (`purchasetypeid`)
    REFERENCES `CarDealershipTest`.`purchasetype` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sales_Vehicles1`
    FOREIGN KEY (`vehicleid`)
    REFERENCES `CarDealershipTest`.`vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sales_Users1`
    FOREIGN KEY (`userid`)
    REFERENCES `CarDealershipTest`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealershipTest`.`UsersRoles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealershipTest`.`userrole` ;

CREATE TABLE IF NOT EXISTS `CarDealershipTest`.`userrole` (
  `userid` INT NOT NULL,
  `roleid` INT NOT NULL,
  PRIMARY KEY (`userid`, `roleid`),
  INDEX `fk_Users_has_Roles_Roles1_idx` (`roleid` ASC),
  INDEX `fk_Users_has_Roles_Users1_idx` (`userid` ASC),
  CONSTRAINT `fk_Users_has_Roles_Users1`
    FOREIGN KEY (`userid`)
    REFERENCES `CarDealershipTest`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_has_Roles_Roles1`
    FOREIGN KEY (`roleid`)
    REFERENCES `CarDealershipTest`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;