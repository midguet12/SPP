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
	id_manager INTEGER,
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
alter table project add CONSTRAINT  fk_project_manager FOREIGN key (id_manager) REFERENCES manager(id_manager);
alter table project add CONSTRAINT fk_project_organization FOREIGN key (id_organization) REFERENCES organization(id_organization);
alter table manager add CONSTRAINT fk_manager_organization FOREIGN key (id_organization) REFERENCES organization(id_organization);

INSERT INTO state(id_state, state) VALUES
(1, 'Aguascalientes'),
(2, 'Baja California'),
(3, 'Baja California Sur'),
(4, 'Campeche'),
(5, 'Coahuila de Zaragoza'),
(6, 'Colima'),
(7, 'Chiapas'),
(8, 'Chihuahua'),
(9, 'Distrito Federal'),
(10, 'Durango'),
(11, 'Guanajuato'),
(12, 'Guerrero'),
(13, 'Hidalgo'),
(14, 'Jalisco'),
(15, 'México'),
(16, 'Michoacán de Ocampo'),
(17, 'Morelos'),
(18, 'Nayarit'),
(19, 'Nuevo León'),
(20, 'Oaxaca de Juárez'),
(21, 'Puebla'),
(22, 'Querétaro'),
(23, 'Quintana Roo'),
(24, 'San Luis Potosí'),
(25, 'Sinaloa'),
(26, 'Sonora'),
(27, 'Tabasco'),
(28, 'Tamaulipas'),
(29, 'Tlaxcala'),
(30, 'Veracruz de Ignacio de la Llave'),
(31, 'Yucatán'),
(32, 'Zacatecas');

insert into user(id_user, name, middlename, lastname, password, email, phone_number, id_type) values 
	('18012193', 'Midguet Arturo','Garcia','Torres', 'Magt2208','midguet12@hotmail.com','9982935090',3),
	('18014123', 'Seth Noe', 'Diaz', 'Diaz', 'Sndd1026','seth@hotmail.com','7422859674',3),
	('45129636', 'Juan Carlos', 'Perez','Arriaga', 'JCPA26042020','elrevo@gmail.com','4152967896',2),
	('96853214', 'Angel Juan', 'Sanchez','Garcia', 'AJSG24042020','angelj@gmail.com','9639781452',1);

insert into organization(name, email, phone_number, id_state, city, address) values
	('Garman', 'garman@garman.com', '9963524185', 23, 'Cancun', 'SM28');



insert into manager(name, middlename, email, id_organization) values
	("Midguet","Garcia","midguet@garman.com",1);

insert into project(project_name, description, id_manager,id_organization) values
	('Cloud','Servicio de nube',1,1),
	('VPN','Servicio de red privada virtual',1,1);



Select * from user LEFT JOIN user_type ON user.id_type = user_type.id_type where id_user = 18012193;







Select project.project_name, project.description, manager.id_manager, organization.id_organization from project left join manager on project.id_manager = manager.id_manager, project.id_organization = organization.id_organization where id_project = 1;
select * from project;