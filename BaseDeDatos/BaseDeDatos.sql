create database EjercicioCandoit;
use  EjercicioCandoit;

insert into Alumno(id,dni,nombre,apellido,eliminado)
value (1,30568789,'Jose','Gongalez',false),
 (2,87945,'Jose','Gongalez',false),
 (3,456456,'Maria','Martinez',false),
 (4,789789,'Ana','Gongalez',false);
 
 
insert into Curso(id,nombreDelCurso,comision,eliminado)
value (1,'Tecnología de Redes','TM',false),
(2,'Tecnología de Redes','TN',false),
(3,'Tecnología de Redes II','TN',false),
(4,'Programacion I','TN',false),
(5,'Ingles V','TN',false),
(6,'Ingles II','TN',false),
(7,'Base de datos','TM',false);



Select * from Curso;
SELECT * FROM alumno;
SELECT * FROM CURSADA;


