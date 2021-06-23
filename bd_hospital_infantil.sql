create database if not exists hospital_infantil;
use hospital_infantil;

CREATE TABLE login (
  idUsuario int UNSIGNED NOT NULL PRIMARY KEY,
  nombre_usuario varchar(8) DEFAULT NULL,
  pass varchar(244) DEFAULT NULL,
  tipo_usuario int(1) DEFAULT NULL,
  estado varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE hospital (
idHospital int NOT NULL PRIMARY KEY,
nombre varchar(244) DEFAULT NULL,
direccion varchar(244) DEFAULT NULL,
telefono  varchar(10) DEFAULT NULL
) ENGINE= InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE medico (
idMedico int NOT NULL PRIMARY KEY,
nombre varchar(244) DEFAULT NULL,
apellido varchar(244) DEFAULT NULL
) ENGINE= InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE paciente (
idPaciente int NOT NULL PRIMARY KEY,
nombre varchar(244) DEFAULT NULL,
apellido varchar(244) DEFAULT NULL,
edad int(3) DEFAULT NULL,
sexo char(1) NOT NULL,
fecha_nacimiento date DEFAULT NULL,
nombre_tutor  varchar(244) DEFAULT NULL,
telefono_tutor  varchar(10) DEFAULT NULL,
fecha_isncripcion date DEFAULT NULL,
idHospital int NOT NULL,
KEY fk_hospital_origen (idHospital),
CONSTRAINT fk_hospital_origen FOREIGN KEY (idHospital) REFERENCES hospital (idHospital) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE= InnoDB DEFAULT CHARSET=utf8;

#pendiente
CREATE TABLE historial (
idHistorial int NOT NULL PRIMARY KEY,
idPaciente int NOT NULL,
numero_habitacion  int DEFAULT NULL,
fecha_alta date DEFAULT NULL,
KEY fk_paciente (idPaciente),
CONSTRAINT fk_paciente FOREIGN KEY (idPaciente) REFERENCES paciente (idPaciente) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE= InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE visitaMedico (
idMedico int NOT NULL,
fecha_visita date DEFAULT NULL,
diagnostico varchar(244) DEFAULT NULL,
idPaciente int NOT NULL,
KEY fk_medico (idMedico),
KEY fk_paciente (idPaciente),
CONSTRAINT fk_medico FOREIGN KEY (idMedico) REFERENCES medico (idMedico) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT fk_paciente2 FOREIGN KEY (idPaciente) REFERENCES paciente (idPaciente) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE= InnoDB DEFAULT CHARSET=utf8;