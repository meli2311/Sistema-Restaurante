create database if not exists Sistema_restaurante;


use Sistema_restaurante; 

DROP TABLES if exists Usuarios;

create table Usuarios(
Usuario varchar(20) not null,
Password varchar(30) not null,
Level_Acces int(5) not null,
primary key (Usuario)
);


drop table if exists Presupuesto;
create table Presupuesto(
id_Presupuesto int(10) not null auto_increment,
Ganancia int(10) not null,
fecha date not null,
primary key  (id_Presupuesto)
);

drop table if exists Reserva;
create table Reserva(
id_Reserva int(10) not null auto_increment,
Nombre_Cliente int(10) not null,
DNI int(8) not null,
email varchar(50) not null,
Telefono int(9) not null,
hora datetime not null,
fecha date not null,
numero_mesa int(50) not null,
primary key  (id_Reserva)
);










