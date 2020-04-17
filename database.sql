create database spp;
use spp;

create table proyecto(
	id_proyecto integer auto_increment not null,
	nombre_proyecto varchar(30) not null,
	id_organizacion integer not null,
	id_encargado integer not null,
	objetivo_general varchar(30) not null,
	objetivo_inmediato varchar(30),
	objetivo_mediato varchar(30),
	descripcion varchar(500) not null,
	metodologia varchar(50),
	recursos varchar(50),
	estado varchar(50),
	responsabilidades varchar(50),
	duracion_meses integer,
	num_personal integer,
	primary key(id_proyecto)
);

create table practicante(
	matricula varchar(10) not null,
	contrasena varchar(64) not null,
	nombre varchar(50) not null,
	apellido_paterno varchar(50) not null,
	apellido_materno varchar(50),
	calificacion integer,
	periodo varchar(20),
	num_personal integer,
	id_proyecto integer,
	primary key (matricula)
);

create table organizacion(
	id_organizacion integer auto_increment not null,
	nombre varchar(50) not null,	
	sector varchar(30),
	usuarios_directos varchar(30),
	usuarios_indirectos varchar(30),
	email varchar(30) not null,
	telefono varchar(13) not null,
	estado varchar(30),
	ciudad varchar(30),
	direccion varchar(30),
	primary key(id_organizacion)
);

create table coordinador(
	num_personal integer not null,
	contrasena varchar(64) not null,
	nombre varchar(50) not null,
	apellido_paterno varchar(50) not null,
	apellido_materno varchar(50),
	fecha_registro Date not null,
	fecha_baja Date,
	primary key(num_personal)
);

create table profesor(
	num_personal integer not null,
	contrasena varchar(64) not null,
	nombre varchar(50) not null,
	apellido_paterno varchar(50) not null,
	apellido_materno varchar(50),
	fecha_registro Date not null,
	fecha_baja Date,
	primary key(num_personal)
);

create table encargado(
	id_encargado integer auto_increment not null,
	id_organizacion integer not null,
	nombre varchar(50) not null,
	apellido_paterno varchar(50) not null,
	apellido_materno varchar(50),
	cargo varchar(20),
	email varchar(50),
	primary key(id_encargado)

);

create table reporte(
	id_reporte integer auto_increment not null,
	actividades varchar(30),
	archivo_reporte varchar(30),
	calificacion integer,
	realizacion Date,
	entrega Date,
	matricula varchar(10),
	primary key(id_reporte)
);

create table reporte_parcial(
	id_reporteparcial integer auto_increment not null,
	observaciones varchar(500),
	horas_cubiertas integer,
	num_reporte integer not null,
	resultados_obtenidos integer,
	primary key(id_reporteparcial)
);

create table actividades(
	id_actividad integer auto_increment not null,
	matricula integer not null,
	nombre varchar(20) not null,
	descripcion varchar(200),
	valor integer,
	entrega Date,
	direccion varchar(100),
	primary key(id_actividad)
);

create table actividad(
	id_actividad integer auto_increment not null,
	actividad varchar(50) not null,
	primary key(id_actividad)
);