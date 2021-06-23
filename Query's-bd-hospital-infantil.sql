#usuarios
use hospital_infantil;

INSERT INTO login (idUsuario, nombre_usuario, pass, tipo_usuario, estado) VALUES 
(1, 'super_admin', 'super', 1, 1),
(2, 'admin', 'root', 2, 1);

DELETE FROM login WHERE nombre_usuario ='user';

select *from login;
select *from hospital;
select *from medico;
select * from login where nombre_usuario='admin' and pass='root' and Estado=1;
select idPaciente from paciente order by idPaciente desc limit 1;
select*from paciente;


INSERT INTO hospital (idHospital, nombre, direccion, telefono) VALUES 
(1, 'Hospital Especializado. Dr Manuel Campos', 'Boulevard N/A, Barrio de Guadalupe', 9818111709),
(2, 'Sanatorio y Clínica Campeche S.A. de C.V.', 'Privada 65, Barrio de Sta Ana', 9812345678),
(3, 'Hospital General de Especialidades Dr. Javier Buenfil Osorio', 'Las Flores', 9811273980),
(4, 'Hospital Regional de Alta Especialidad de la Península de Yucatán', 'C. 22, Col. Altabrisa', 9999427600),
(5, 'Hospital General Agustín O-Horan', 'Avenida Itzaes s/n x Av Centro Jacinto Canek', 9999303320),
(6, 'Star Médica Mérida', 'C. 26 199, Col. Altabrisa',  9999302880);

INSERT INTO medico (idMedico, nombre, apellido) VALUES 
(1, 'Gabriela', 'Gomez'),
(2, 'Luis', 'Sulub'),
(3, 'Carolina', 'Flores'),
(4, 'Eduardo', 'Manzanilla'),
(5, 'Samanta', 'Montero'),
(6, 'Alonso', 'Ceballos');

INSERT INTO paciente (idPaciente, nombre, apellido, edad, sexo, fecha_nacimiento, nombre_tutor, telefono_tutor, fecha_isncripcion, idHospital) VALUES 
(1, 'Nashby Gabriela', 'Galvan Gomez', 13, 'F', '2008/06/19', 'Juan Galvan', '9182736540', '2021/04/16', 5),
(2, 'Roberto Augusto', 'Maas Rico', 10, 'M', '2011/04/28', 'Erika Rico', '9981457363', '2020/01/30', 6),
(3, 'Alejandra', 'Gutierrez Perez', 12, 'F', '2009/02/10', 'Joaquin Gutierrez', '9992345678', '2020/10/10', 2),
(4, 'Eduardo Josue', 'Manzanilla Yeh', 9, 'M', '2012/05/18', 'Janet Yeh', '9988745320', '2021/01/06', 1);


select paciente.idPaciente, paciente.nombre, paciente.apellido, paciente.edad, paciente.sexo, paciente.fecha_nacimiento, paciente.nombre_tutor, paciente.telefono_tutor, paciente.fecha_isncripcion, hospital.nombre from hospital_infantil.paciente, hospital_infantil.hospital where paciente.idHospital = hospital.idHospital;


select *from paciente where idPaciente=1;

select *from hospital;

DELETE FROM paciente WHERE idPaciente= 4;

select *from paciente where idPaciente = 1;

select paciente.nombre, paciente.apellido, paciente.edad, paciente.sexo, paciente.fecha_nacimiento, paciente.nombre_tutor, paciente.telefono_tutor, paciente.fecha_isncripcion, hospital.nombre from hospital_infantil.paciente, hospital_infantil.hospital where paciente.idHospital = hospital.idHospital and idPaciente = 1;
