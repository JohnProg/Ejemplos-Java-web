use master;

DROP DATABASE IF EXISTS maristas;
CREATE DATABASE maristas;
#GO
use maristas;
#GO

#-----------------------------------
#--LOGIN
#------------------------------------
create table rol(
	id int primary key AUTO_INCREMENT UNIQUE,
	nombre varchar(30)
);

create table usuario(
	id int primary key AUTO_INCREMENT UNIQUE,
	username varchar(30) not null, 
	contra varchar(30) not null,
	id_rol int not null,
	foreign key(id_rol) references rol(id)
);
#-----------------------------------
#--PLAN ESTRATEGICO
#------------------------------------

create table PlanEstrategico(
	id int primary key AUTO_INCREMENT UNIQUE,
	nombre varchar(100),
	fecha_inicio datetime,
	fecha_termino datetime,
	anio_inicio char(4),
	anio_termino char(4),
	aprobado_por int not null,
	descripcion varchar(100),
	foreign key(aprobado_por) references usuario(id)
);


create table Linea(
	id int not null primary key AUTO_INCREMENT UNIQUE,
	id_plan_estrategico int not null,
	nombre varchar(30) not null, 
	descripcion varchar(30),
	foreign key(id_plan_estrategico) references PlanEstrategico(id)
);


create table Objetivo(
	id int not null primary key AUTO_INCREMENT UNIQUE,
	linea int not null,
	nombre varchar(50) not null,
	descripcion varchar(150) not null,
	foreign key(linea) references Linea(id)
);


create table SubObjetivo(
	id int not null primary key AUTO_INCREMENT UNIQUE,
	objetivo int not null,
	nombre varchar(50) not null,
	descripcion varchar(150) not null,
	foreign key(objetivo) references objetivo(id)
);

#-----------------------------------
#--PLAN PRESUPUESTAL
#------------------------------------

create table PlanPresupuestal(
	id int not null primary key AUTO_INCREMENT UNIQUE,
	nombre varchar(30) not null,
	monto float not null,
	fecha_inicio date not null DEFAULT NOW(),
	fecha_final date not null
);

#-----------------------------------
#--PLAN OPERATIVO
#------------------------------------

create table UnidadOrganizativa(
	id int not null primary key AUTO_INCREMENT UNIQUE,
	nombre varchar(30) not null
);

create table PlanOperativo(
	id int not null primary key AUTO_INCREMENT UNIQUE,
	nombre varchar(30) not null,
	descripcion varchar(150) null,
	id_plan_estrategico int not null,
	id_encargado int not null,
	id_unidad_org int not null,
	foreign key(id_plan_estrategico) references PlanEstrategico(id),
	foreign key(id_encargado) references rol(id),
	foreign key(id_unidad_org) references UnidadOrganizativa(id)
);


create table actividad(
	id int not null primary key AUTO_INCREMENT UNIQUE,
	id_plan_operativo int not null,
	nombre varchar(30) not null,
	gastos float null,
	ingresos float null,
	id_sub_objetivo int not null,
	id_presupuesto int not null,
	foreign key(id_plan_operativo) references PlanOperativo(id),
	foreign key(id_sub_objetivo) references SubObjetivo(id),
	foreign key(id_presupuesto) references PlanPresupuestal(id)
);

create table indicador(
	id int not null primary key AUTO_INCREMENT UNIQUE,
	id_actividad int not null,
	nombre varchar(30) not null,
	tipo_logo varchar(30) not null,
	logro varchar(50) not null,
	foreign key(id_actividad) references actividad(id)
);

create table programacion(
	id int not null primary key AUTO_INCREMENT UNIQUE,
	id_actividad int not null,
	fecha_inicio date not null DEFAULT NOW(),
	fecha_final date not null DEFAULT NOW(),
	foreign key(id_actividad) references actividad(id)
);

#tabla rol
insert into rol(nombre) values('director');
insert into rol(nombre) values('jefe_area');

#tabla usuario
insert into usuario(username, contra, id_rol) values('johnp', '123', 1);
insert into usuario(username, contra, id_rol) values('aldo', '123', 2);

#tabla UnidadOrganizativa
insert into rol(nombre) values('Adminitracion');
insert into rol(nombre) values('Ventas');


insert into Planes(nombre, fecha_vigencia, fecha_termino, anio_inicio, anio_termino, aprobado_por, descripcion) 
values('Plan integral', '12/08/2014', '14/09/2014', '2014', '2014', 1, 'Plan principal de toda la escuela');

insert into Planes(nombre, fecha_vigencia, fecha_termino, anio_inicio, anio_termino, aprobado_por, descripcion)
values('Plan Secundario', '10/08/2013', '14/09/2015', '2013', '2015', 1, 'Plan para la economia de la escuela');

select id, nombre, fecha_vigencia, fecha_termino, anio_inicio, anio_termino, aprobado_por, descripcion from Planes;
