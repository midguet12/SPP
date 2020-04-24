create database spp;
use spp;

create table organization(
	id_organization INTEGER auto_increment not null,
	name VARCHAR(30) not null,	
	sector VARCHAR(20),
	email VARCHAR(30) not null,
	phone_number VARCHAR(30) not null,
	id_state INTEGER not null,
	city VARCHAR(30) not null,
	address VARCHAR(30) not null,
	primary key(id_organization)
);


create table project(
	id_project INTEGER auto_increment not null,
	project_name VARCHAR(30) not null,
	description VARCHAR(50) not null,
	responsabilities VARCHAR(50),
	activities VARCHAR(50),
	duration INTEGER,
	general_objective VARCHAR(30),
	metodology VARCHAR(50),
	resources VARCHAR(30),
	id_project_manager INTEGER,
	id_organization INTEGER,
	primary key(id_project)
);

create table intern(
	id_intern VARCHAR(15) not null,
	period VARCHAR(20),
	grade INTEGER,
	id_project INTEGER not null,
	primary key (id_intern)
);

create table report(
	id_report integer auto_increment not null,
	id_type VARCHAR(15) not null,
	description VARCHAR(200),
	filepath VARCHAR(100) not null,
	grade INTEGER,
	upload_date DATE not null,
	id_intern VARCHAR(15) not null,
	primary key(id_report)
);

create table activity(
	id_activity INTEGER auto_increment not null,
	name VARCHAR(20) not null,
	value VARCHAR(20) not null,
	description VARCHAR(30),
	upload_date DATE not null,
	id_intern VARCHAR(15) not null,
	primary key(id_activity)
);

create table user(
	id_user VARCHAR(15) not null,
	name VARCHAR(30) not null,
	middlename VARCHAR(30) not null,
	lastname VARCHAR(30),
	password VARCHAR(64) not null,
	email VARCHAR(50) not null,
	phone_number VARCHAR(14) not null,
	id_type INTEGER not null,
	primary key(id_user)
);




create table document(
	id_document INTEGER auto_increment not null,
	file_path VARCHAR(200) not null,
	upload_date DATE not null,
	id_intern VARCHAR(15),
	id_type INTEGER,
	primary key(id_document)
);

create table project_manager(
	id_project INTEGER,
	id_manager INTEGER
);

create table state(
	id_state INTEGER,
	state VARCHAR(35),
	primary key(id_state)
);


create table manager(
	id_manager INTEGER auto_increment not null,
	name VARCHAR(30) not null,
	middlename VARCHAR(30) not null,
	lastname VARCHAR(30),
	position VARCHAR(30),
	email VARCHAR(50) not null,
	id_organization INTEGER not null,
	primary key(id_manager)
);

create table user_type(
	id_type INTEGER auto_increment not null,
	type VARCHAR(15) not null,
	primary key(id_type)
);

create table document_type(
	id_type INTEGER auto_increment not null,
	type VARCHAR(15) not null,
	primary key(id_type)
	
);

create table report_type(
	id_type INTEGER auto_increment not null,
	type VARCHAR(15) not null,
	primary key(id_type)

);

insert into user_type(type) values 
	('Coordinador'),
	('Profesor'),
	('Practicante')
;


ALTER TABLE user ADD CONSTRAINT FK_user_type1 FOREIGN KEY (id_type) REFERENCES user_type(id_type);

insert into user(id_user, name, middlename, lastname, password, email, phone_number, id_type) values 
	('18012193', 'Midguet Arturo','Garcia','Torres', 'Magt2208','midguet12@hotmail.com','9982935090',3),
	('18014123', 'Seth Noe', 'Diaz', 'Diaz', 'Sndd1026','seth@hotmail.com','7422859674',3),
	('45129636', 'Juan Carlos', 'Perez','Arriaga', 'JCPA26042020','elrevo@gmail.com','4152967896',2),
	('96853214', 'Angel Juan', 'Sanchez','Garcia', 'AJSG24042020','angelj@gmail.com','9639781452',1);

