SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `bd_renta_car_el_bory` ;
CREATE SCHEMA IF NOT EXISTS `bd_renta_car_el_bory` DEFAULT CHARACTER SET utf8 ;
USE `bd_renta_car_el_bory` ;

-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`clasevehiculo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`clasevehiculo` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`clasevehiculo` (
  `idClaseVehiculo` INT(11) NOT NULL,
  `Descripcion` VARCHAR(45) NULL DEFAULT NULL,
  `CostoDiario` DOUBLE NULL DEFAULT NULL,
  `CostoProteccion` DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (`idClaseVehiculo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`estatuscliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`estatuscliente` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`estatuscliente` (
  `idEstatusCliente` INT(11) NOT NULL,
  `EstatusCliente` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`idEstatusCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`telefonocliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`telefonocliente` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`telefonocliente` (
  `idTelefonoCliente` INT(11) NOT NULL,
  `NumeroTelefono` VARCHAR(10) NULL DEFAULT NULL,
  `TipoTelefono` VARCHAR(25) NULL DEFAULT NULL,
  `Descripcion` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idTelefonoCliente`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`cliente` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`cliente` (
  `idCliente` INT(11) NOT NULL,
  `NombreCliente` VARCHAR(25) NULL DEFAULT NULL,
  `ApellidoCliente` VARCHAR(25) NULL DEFAULT NULL,
  `CedulaCliente` VARCHAR(11) NULL DEFAULT NULL,
  `DireccionCliente` VARCHAR(45) NULL DEFAULT NULL,
  `EmailCliente` VARCHAR(25) NULL DEFAULT NULL,
  `FechaIngreso` DATETIME NULL DEFAULT NULL,
  `idEstatusCliente` INT(11) NOT NULL,
  `idTelefonoCliente` INT(11) NOT NULL,
  PRIMARY KEY (`idCliente`, `idEstatusCliente`, `idTelefonoCliente`),
  INDEX `fk_cliente_estatuscliente1_idx` (`idEstatusCliente` ASC),
  INDEX `fk_cliente_telefonocliente1_idx` (`idTelefonoCliente` ASC),
  CONSTRAINT `fk_cliente_estatuscliente1`
    FOREIGN KEY (`idEstatusCliente`)
    REFERENCES `bd_renta_car_el_bory`.`estatuscliente` (`idEstatusCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_telefonocliente1`
    FOREIGN KEY (`idTelefonoCliente`)
    REFERENCES `bd_renta_car_el_bory`.`telefonocliente` (`idTelefonoCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`conductor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`conductor` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`conductor` (
  `idConductor` INT(11) NOT NULL,
  `CedulaConductor` VARCHAR(11) NULL DEFAULT NULL,
  `NombreConductor` VARCHAR(25) NULL DEFAULT NULL,
  `ApellidoConductor` VARCHAR(25) NULL DEFAULT NULL,
  `FechaNacimiento` DATETIME NULL DEFAULT NULL,
  `LicenciaConductor` VARCHAR(11) NULL DEFAULT NULL,
  `CategoriaLicencia` INT(11) NULL DEFAULT NULL,
  `DireccionConductor` VARCHAR(45) NULL DEFAULT NULL,
  `TelefonoConductor` VARCHAR(11) NULL DEFAULT NULL,
  `EmailConductor` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idConductor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`marcavehiculo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`marcavehiculo` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`marcavehiculo` (
  `idMarcaVehiculo` INT(11) NOT NULL,
  `NombreMarcaVehiculocol` VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (`idMarcaVehiculo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`modelovehiculo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`modelovehiculo` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`modelovehiculo` (
  `idModeloVehiculo` INT(11) NOT NULL,
  `NombreModeloVehiculo` VARCHAR(25) NULL DEFAULT NULL,
  `idMarcaVehiculo` INT(11) NOT NULL,
  `idClaseVehiculo` INT(11) NOT NULL,
  PRIMARY KEY (`idModeloVehiculo`, `idMarcaVehiculo`, `idClaseVehiculo`),
  INDEX `fk_modelovehiculo_marcavehiculo_idx` (`idMarcaVehiculo` ASC),
  INDEX `fk_modelovehiculo_clasevehiculo1_idx` (`idClaseVehiculo` ASC),
  CONSTRAINT `fk_modelovehiculo_clasevehiculo1`
    FOREIGN KEY (`idClaseVehiculo`)
    REFERENCES `bd_renta_car_el_bory`.`clasevehiculo` (`idClaseVehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_modelovehiculo_marcavehiculo`
    FOREIGN KEY (`idMarcaVehiculo`)
    REFERENCES `bd_renta_car_el_bory`.`marcavehiculo` (`idMarcaVehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`aseguradora`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`aseguradora` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`aseguradora` (
  `idAseguradora` INT(11) NOT NULL,
  `NombreAseguradora` VARCHAR(45) NULL DEFAULT NULL,
  `DireccionAseguradora` VARCHAR(45) NULL DEFAULT NULL,
  `TelefonoAseguradora` VARCHAR(11) NULL DEFAULT NULL,
  `FaxAseguradora` VARCHAR(11) NULL DEFAULT NULL,
  `EmailAseguradora` VARCHAR(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idAseguradora`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`poliza`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`poliza` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`poliza` (
  `idPoliza` INT(11) NOT NULL,
  `FechaEmision` DATETIME NULL DEFAULT NULL,
  `FechaInicio` DATETIME NULL DEFAULT NULL,
  `FechaFin` DATETIME NULL DEFAULT NULL,
  `idAseguradora` INT(11) NOT NULL,
  PRIMARY KEY (`idPoliza`, `idAseguradora`),
  INDEX `fk_poliza_aseguradora1_idx` (`idAseguradora` ASC),
  CONSTRAINT `fk_poliza_aseguradora1`
    FOREIGN KEY (`idAseguradora`)
    REFERENCES `bd_renta_car_el_bory`.`aseguradora` (`idAseguradora`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`statusvehiculo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`statusvehiculo` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`statusvehiculo` (
  `idStatusVehiculo` INT(11) NOT NULL,
  `StatusVehiculo` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`idStatusVehiculo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`vehiculo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`vehiculo` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`vehiculo` (
  `idVehiculo` INT(11) NOT NULL,
  `PlacaVehiculo` VARCHAR(25) NULL DEFAULT NULL,
  `ColorVehiculo` VARCHAR(25) NULL DEFAULT NULL,
  `FechaIngreso` DATETIME NULL DEFAULT NULL,
  `SerialCarroceria` VARCHAR(45) NULL DEFAULT NULL,
  `SerialMotor` VARCHAR(45) NULL DEFAULT NULL,
  `KmVehiculo` INT(11) NULL DEFAULT NULL,
  `Litros` FLOAT NULL DEFAULT NULL,
  `idAseguradora` INT(11) NOT NULL,
  `idModeloVehiculo` INT(11) NOT NULL,
  `idStatusVehiculo` INT(11) NOT NULL,
  PRIMARY KEY (`idVehiculo`, `idAseguradora`, `idModeloVehiculo`, `idStatusVehiculo`),
  INDEX `fk_vehiculo_poliza1_idx` (`idAseguradora` ASC),
  INDEX `fk_vehiculo_modelovehiculo1_idx` (`idModeloVehiculo` ASC),
  INDEX `fk_vehiculo_statusvehiculo1_idx` (`idStatusVehiculo` ASC),
  CONSTRAINT `fk_vehiculo_modelovehiculo1`
    FOREIGN KEY (`idModeloVehiculo`)
    REFERENCES `bd_renta_car_el_bory`.`modelovehiculo` (`idModeloVehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehiculo_poliza1`
    FOREIGN KEY (`idAseguradora`)
    REFERENCES `bd_renta_car_el_bory`.`poliza` (`idAseguradora`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehiculo_statusvehiculo1`
    FOREIGN KEY (`idStatusVehiculo`)
    REFERENCES `bd_renta_car_el_bory`.`statusvehiculo` (`idStatusVehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`alquiler`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`alquiler` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`alquiler` (
  `idAlquiler` INT(11) NOT NULL,
  `FechaSalida` VARCHAR(45) NULL DEFAULT NULL,
  `FechaRetorno` DATETIME NULL DEFAULT NULL,
  `TipoProteccion` VARCHAR(20) NULL DEFAULT NULL,
  `ProteccionRoboAcesorios` VARCHAR(20) NULL DEFAULT NULL,
  `CostoDiario` DOUBLE NULL DEFAULT NULL,
  `EsReserva` CHAR(2) NULL DEFAULT NULL,
  `idVehiculo` INT(11) NOT NULL,
  `idClaseVehiculo` INT(11) NOT NULL,
  `cliente_idCliente` INT(11) NOT NULL,
  `idConductor` INT(11) NOT NULL,
  PRIMARY KEY (`idAlquiler`, `idVehiculo`, `idClaseVehiculo`, `cliente_idCliente`, `idConductor`),
  INDEX `fk_alquiler_vehiculo1_idx` (`idVehiculo` ASC),
  INDEX `fk_alquiler_clasevehiculo1_idx` (`idClaseVehiculo` ASC),
  INDEX `fk_alquiler_cliente1_idx` (`cliente_idCliente` ASC),
  INDEX `fk_alquiler_conductor1_idx` (`idConductor` ASC),
  CONSTRAINT `fk_alquiler_clasevehiculo1`
    FOREIGN KEY (`idClaseVehiculo`)
    REFERENCES `bd_renta_car_el_bory`.`clasevehiculo` (`idClaseVehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alquiler_cliente1`
    FOREIGN KEY (`cliente_idCliente`)
    REFERENCES `bd_renta_car_el_bory`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alquiler_conductor1`
    FOREIGN KEY (`idConductor`)
    REFERENCES `bd_renta_car_el_bory`.`conductor` (`idConductor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_alquiler_vehiculo1`
    FOREIGN KEY (`idVehiculo`)
    REFERENCES `bd_renta_car_el_bory`.`vehiculo` (`idVehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`controlvehiculo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`controlvehiculo` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`controlvehiculo` (
  `idControlVehiculo` INT(11) NOT NULL,
  `FechaControl` DATETIME NULL DEFAULT NULL,
  `Micas` CHAR(2) NULL DEFAULT NULL,
  `TrancaPalanca` CHAR(2) NULL DEFAULT NULL,
  `Radio` CHAR(2) NULL DEFAULT NULL,
  `Placas` CHAR(2) NULL DEFAULT NULL,
  `Gato` CHAR(2) NULL DEFAULT NULL,
  `Cono` CHAR(2) NULL DEFAULT NULL,
  `Triangulo` CHAR(2) NULL DEFAULT NULL,
  `Espejos` CHAR(2) NULL DEFAULT NULL,
  `Faros` CHAR(2) NULL DEFAULT NULL,
  `Cerraduras` CHAR(2) NULL DEFAULT NULL,
  `TapaAceite` CHAR(2) NULL DEFAULT NULL,
  `Bateria` CHAR(2) NULL DEFAULT NULL,
  `Herramientas` CHAR(2) NULL DEFAULT NULL,
  `Observaciones` VARCHAR(60) NULL DEFAULT NULL,
  `idVehiculo` INT(11) NOT NULL,
  PRIMARY KEY (`idControlVehiculo`, `idVehiculo`),
  INDEX `fk_controlvehiculo_vehiculo1_idx` (`idVehiculo` ASC),
  CONSTRAINT `fk_controlvehiculo_vehiculo1`
    FOREIGN KEY (`idVehiculo`)
    REFERENCES `bd_renta_car_el_bory`.`vehiculo` (`idVehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`facturas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`facturas` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`facturas` (
  `idFacturas` INT(11) NOT NULL,
  `Monto` DOUBLE NULL DEFAULT NULL,
  `Fecha` DATETIME NULL DEFAULT NULL,
  `Descripcion` VARCHAR(45) NULL DEFAULT NULL,
  `idAlquiler` INT(11) NOT NULL,
  PRIMARY KEY (`idFacturas`, `idAlquiler`),
  INDEX `fk_facturas_alquiler1_idx` (`idAlquiler` ASC),
  CONSTRAINT `fk_facturas_alquiler1`
    FOREIGN KEY (`idAlquiler`)
    REFERENCES `bd_renta_car_el_bory`.`alquiler` (`idAlquiler`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`mantenimiento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`mantenimiento` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`mantenimiento` (
  `idmantenimiento` INT(11) NOT NULL,
  `FechaInicio` DATETIME NULL DEFAULT NULL,
  `Status` VARCHAR(45) NULL DEFAULT NULL,
  `Comentarios` VARCHAR(45) NULL DEFAULT NULL,
  `idVehiculo` INT(11) NOT NULL,
  PRIMARY KEY (`idmantenimiento`, `idVehiculo`),
  INDEX `fk_mantenimiento_vehiculo1_idx` (`idVehiculo` ASC),
  CONSTRAINT `fk_mantenimiento_vehiculo1`
    FOREIGN KEY (`idVehiculo`)
    REFERENCES `bd_renta_car_el_bory`.`vehiculo` (`idVehiculo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`tipotarjeta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`tipotarjeta` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`tipotarjeta` (
  `idTipoTarjeta` INT(11) NOT NULL,
  `NombreTarjeta` VARCHAR(25) NULL DEFAULT NULL,
  PRIMARY KEY (`idTipoTarjeta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`tarjetacredito`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`tarjetacredito` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`tarjetacredito` (
  `idTarjetaCredito` INT(11) NOT NULL,
  `NumeroTarjetaCredito` VARCHAR(25) NULL DEFAULT NULL,
  `Titular` VARCHAR(45) NULL DEFAULT NULL,
  `FechaVencimiento` DATETIME NULL DEFAULT NULL,
  `Limite` INT(11) NULL DEFAULT NULL,
  `idCliente` INT(11) NOT NULL,
  `idTipoTarjeta` INT(11) NOT NULL,
  PRIMARY KEY (`idTarjetaCredito`, `idCliente`, `idTipoTarjeta`),
  INDEX `fk_tarjetacredito_cliente1_idx` (`idCliente` ASC),
  INDEX `fk_tarjetacredito_tipotarjeta1_idx` (`idTipoTarjeta` ASC),
  CONSTRAINT `fk_tarjetacredito_cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `bd_renta_car_el_bory`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarjetacredito_tipotarjeta1`
    FOREIGN KEY (`idTipoTarjeta`)
    REFERENCES `bd_renta_car_el_bory`.`tipotarjeta` (`idTipoTarjeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bd_renta_car_el_bory`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bd_renta_car_el_bory`.`usuario` ;

CREATE TABLE IF NOT EXISTS `bd_renta_car_el_bory`.`usuario` (
  `idUsuario` INT(11) NOT NULL,
  `Usuario` VARCHAR(45) NULL DEFAULT NULL,
  `NombreUsuario` VARCHAR(45) NULL DEFAULT NULL,
  `ContraseñaUsuario` VARCHAR(45) NULL DEFAULT NULL,
  `CedulaUsuario` INT(11) NULL DEFAULT NULL,
  `TelefonoUsuario` INT(11) NULL DEFAULT NULL,
  `TipoUsuario` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
