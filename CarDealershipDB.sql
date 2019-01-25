-- -----------------------------------------------------
-- Schema CarDealership
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `CarDealership` ;

-- -----------------------------------------------------
-- Schema CarDealership
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CarDealership` DEFAULT CHARACTER SET utf8 ;
USE `CarDealership` ;

-- -----------------------------------------------------
-- Table `CarDealership`.`Makes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealership`.`make` ;

CREATE TABLE IF NOT EXISTS `CarDealership`.`make` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `make` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealership`.`BodyStyles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealership`.`type` ;

CREATE TABLE IF NOT EXISTS `CarDealership`.`type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealership`.`ExteriorColors`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealership`.`exteriorcolor` ;

CREATE TABLE IF NOT EXISTS `CarDealership`.`exteriorcolor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `exteriorcolor` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealership`.`BodyStyles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealership`.`bodystyle` ;

CREATE TABLE IF NOT EXISTS `CarDealership`.`bodystyle` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `bodystyle` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealership`.`Transmissions`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealership`.`transmission` ;

CREATE TABLE IF NOT EXISTS `CarDealership`.`transmission` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `transmission` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealership`.`InteriorColors`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealership`.`interiorcolor` ;

CREATE TABLE IF NOT EXISTS `CarDealership`.`interiorcolor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `interiorcolor` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealership`.`Models`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealership`.`model` ;

CREATE TABLE IF NOT EXISTS `CarDealership`.`model` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(45) NOT NULL UNIQUE,
  `makeid` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Models_Makes1_idx` (`makeid` ASC),
  CONSTRAINT `fk_Models_Makes1`
    FOREIGN KEY (`makeid`)
    REFERENCES `CarDealership`.`make` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealership`.`Vehicles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealership`.`vehicle` ;

CREATE TABLE IF NOT EXISTS `CarDealership`.`vehicle` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `makeid` INT NOT NULL,
  `modelid` INT NULL,
  `typeid` INT NULL,
  `exteriorcolorid` INT NULL,
  `bodystyleid` INT NULL,
  `transmissionid` INT NULL,
  `interiorcolorid` INT NULL,
  `year` INT(4) NULL,
  `mileage` INT NOT NULL,
  `vinnum` VARCHAR(45) NULL,
  `msrp` DOUBLE NULL,
  `salesprice` DOUBLE NULL,
  `description` MEDIUMTEXT NULL,
  `isfeatured` TINYINT(1) NULL,
  `isavailable` TINYINT(1) NULL,
  `imagepath` VARCHAR(45) NULL,
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
    REFERENCES `CarDealership`.`make` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicles_Types1`
    FOREIGN KEY (`typeid`)
    REFERENCES `CarDealership`.`type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicles_ExteriorColors1`
    FOREIGN KEY (`exteriorcolorid`)
    REFERENCES `CarDealership`.`exteriorcolor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicles_BodyStyles1`
    FOREIGN KEY (`bodystyleid`)
    REFERENCES `CarDealership`.`bodystyle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicles_Transmissions1`
    FOREIGN KEY (`transmissionid`)
    REFERENCES `CarDealership`.`transmission` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicles_InteriorColors1`
    FOREIGN KEY (`interiorcolorid`)
    REFERENCES `CarDealership`.`interiorcolor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicles_Models1`
    FOREIGN KEY (`modelid`)
    REFERENCES `CarDealership`.`model` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealership`.`Contacts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealership`.`contact` ;

CREATE TABLE IF NOT EXISTS `CarDealership`.`contact` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `message` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealership`.`Specials`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealership`.`special` ;

CREATE TABLE IF NOT EXISTS `CarDealership`.`special` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealership`.`Roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealership`.`role` ;

CREATE TABLE IF NOT EXISTS `CarDealership`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealership`.`States`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealership`.`state` ;

CREATE TABLE IF NOT EXISTS `CarDealership`.`state` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `state` CHAR(2) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealership`.`PurchaseTypes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealership`.`purchasetype` ;

CREATE TABLE IF NOT EXISTS `CarDealership`.`purchasetype` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `purchasetype` VARCHAR(45) NOT NULL UNIQUE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealership`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealership`.`user` ;

CREATE TABLE IF NOT EXISTS `CarDealership`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `active` TINYINT(1) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealership`.`Sales`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealership`.`sale` ;

CREATE TABLE IF NOT EXISTS `CarDealership`.`sale` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `purchaser` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `street1` VARCHAR(45) NULL,
  `street2` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  `zipcode` INT(5) NULL,
  `purchaseprice` DOUBLE NULL,
  `purchasedate` DATETIME NULL DEFAULT NOW(),
  `stateid` INT NULL,
  `purchasetypeid` INT NULL,
  `vehicleid` INT NULL,
  `userid` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Sales_States1_idx` (`stateid` ASC),
  INDEX `fk_Sales_PurchaseTypes1_idx` (`purchasetypeid` ASC),
  INDEX `fk_Sales_Vehicles1_idx` (`vehicleid` ASC),
  INDEX `fk_Sales_Users1_idx` (`userid` ASC),
  CONSTRAINT `fk_Sales_States1`
    FOREIGN KEY (`stateid`)
    REFERENCES `CarDealership`.`state` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sales_PurchaseTypes1`
    FOREIGN KEY (`purchasetypeid`)
    REFERENCES `CarDealership`.`purchasetype` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sales_Vehicles1`
    FOREIGN KEY (`vehicleid`)
    REFERENCES `CarDealership`.`vehicle` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Sales_Users1`
    FOREIGN KEY (`userid`)
    REFERENCES `CarDealership`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CarDealership`.`UsersRoles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `CarDealership`.`userrole` ;

CREATE TABLE IF NOT EXISTS `CarDealership`.`userrole` (
  `userid` INT NOT NULL,
  `roleid` INT NOT NULL,
  PRIMARY KEY (`userid`, `roleid`),
  INDEX `fk_Users_has_Roles_Roles1_idx` (`roleid` ASC),
  INDEX `fk_Users_has_Roles_Users1_idx` (`userid` ASC),
  CONSTRAINT `fk_Users_has_Roles_Users1`
    FOREIGN KEY (`userid`)
    REFERENCES `CarDealership`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_has_Roles_Roles1`
    FOREIGN KEY (`roleid`)
    REFERENCES `CarDealership`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO State (`state`) 
VALUES ("AL"), ("AK"), ("AZ"), ("AR"), ("CA"), ("CO"), ("CT"), ("DE"),
 ("FL"), ("GA"), ("HI"), ("ID"), ("IL"), ("IN"), ("IA"), ("KS"), ("KY"),
 ("LA"), ("ME"), ("MD"), ("MA"), ("MI"), ("MN"), ("MS"), ("MO"), ("MT"),
 ("NE"), ("NV"), ("NH"), ("NJ"), ("NM"), ("NY"), ("NC"), ("ND"), ("OH"),
 ("OK"), ("OR"), ("PA"), ("RI"), ("SC"), ("SD"), ("TN"), ("TX"), ("UT"),
 ("VT"), ("VA"), ("WA"), ("WV"), ("WI"), ("WY");
 
 INSERT INTO Role (`role`)
 VALUES ("Admin"), ("Sales"), ("Disabled");
 
 INSERT INTO PurchaseType (`purchasetype`)
 VALUES ("Bank Finance"), ("Cash"), ("Dealer Finance");
 
 INSERT INTO Type (`Type`) 
 VALUES ("New"), ("Used");
 
 INSERT INTO BodyStyle (`bodystyle`)
 VALUES ("Sedan"), ("SUV"), ("Van"), ("Pick-Up Truck"), ("Coupe"), ("Station Wagon"), ("Convertible");
 
 INSERT INTO Transmission (`transmission`) 
 VALUES ("Manual"), ("Automatic");
 
 INSERT INTO Exteriorcolor (`exteriorcolor`) 
 VALUES ("Black"), ("White"), ("Grey"), ("Blue"), ("Red");
 
 INSERT INTO Interiorcolor (`interiorcolor`)
 VALUES ("Black"), ("Beige"), ("Brown"), ("Grey");
 
 
INSERT INTO make (make) values
('Nissan'),
('Hyundai'),
('Ford'),
('Chevy');

INSERT INTO model (model, makeid) values
('Altima',1),
('HVAC',2),
('Chase',4),
('Charger',5),
('Fusion',3);

DROP VIEW SearchCar;

CREATE VIEW SearchCar AS;

SELECT v.*, ma.make as makename, mo.model as modelname, cast(v.year as char) yearstr
FROM vehicle v
JOIN make ma ON v.makeid = ma.id
JOIN model mo ON mo.id = v.modelid AND ma.id = mo.makeid;

SELECT *
FROM SearchCar v 
WHERE (modelname = 'Fusion') or (makename = 'Ford')
or (yearstr = '2000') and year between 2000 AND 2009 and salesprice between 40000 AND 99999;

Select *
From vehicle;


Select *
From special;

Select *
From sale;

Select *
From user;
Select *
From role;
Select *
From userrole;

Select *
From contact;

INSERT INTO `user`(id,firstname,lastname,email,`password`, active) values
(1,'Neil','Sefah','nksefah@gmail.com','password',0);

INSERT INTO `user`(firstname,lastname,email,`password`, active) values
('Bob','Jobbo','bob@gmail.com','password',0),
('Alex','Master','alex@gmail.com','password',0);


Insert into `userrole`(userid, roleid) values
(1,1);

Insert into `userrole`(userid, roleid) values
(2,2),
(3,3);


INSERT INTO Role (`role`)
 VALUES ("Admin"), ("Sales"), ("Disabled");

Select *
From role;
INSERT INTO sale(purchaser, phone, email, `street1`, `street2`, city,zipcode,purchaseprice,purchasedate,stateid,purchasetypeid,vehicleid,userid) values
('example', 5556667777,'email@email.com', 'street', 'street2','cityname', 88888,40000,'2018-04-11 09:54:35',1,1,1,1);
