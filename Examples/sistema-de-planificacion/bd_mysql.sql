use mysql;

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
	fecha_inicio datetime not null DEFAULT NOW(),
	fecha_termino datetime not null DEFAULT NOW(),
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
	fecha_inicio datetime not null DEFAULT NOW(),
	fecha_final datetime not null DEFAULT NOW()
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
	id_plan_estrategico int null,
	id_encargado int null,
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
	fecha_inicio datetime not null DEFAULT NOW(),
	fecha_final datetime not null DEFAULT NOW(),
	foreign key(id_actividad) references actividad(id)
);

#tabla rol
insert into rol(nombre) values('director');
insert into rol(nombre) values('jefe_area');

#tabla usuario
insert into usuario(username, contra, id_rol) values('usuario1', '123', 1);
insert into usuario(username, contra, id_rol) values('usuario2', '123', 1);
insert into usuario(username, contra, id_rol) values('usuario3', '123', 2);
insert into usuario(username, contra, id_rol) values('usuario4', '123', 2);

#tabla UnidadOrganizativa
insert into rol(nombre) values('Adminitracion');
insert into rol(nombre) values('Ventas');

#tabla UnidadOrganizativa
insert into UnidadOrganizativa(nombre) values('Adminitracion');
insert into UnidadOrganizativa(nombre) values('Ventas');
insert into UnidadOrganizativa(nombre) values('Marketing');
insert into UnidadOrganizativa(nombre) values('Gerencia');
insert into UnidadOrganizativa(nombre) values('Produccion');
insert into UnidadOrganizativa(nombre) values('Almacen');
insert into UnidadOrganizativa(nombre) values('Recursos Humanos');


# tabla PlanEstrategico
insert into PlanEstrategico(nombre, fecha_inicio, fecha_termino, anio_inicio, anio_termino, aprobado_por, descripcion) 
values('Plan integral', '2014-08-12', '2014-09-14', '2014', '2014', 1, 'Plan principal de toda la escuela');
insert into PlanEstrategico(nombre, anio_inicio, anio_termino, aprobado_por, descripcion)
values('Plan Secundario', '2013', '2015', 2, 'Plan para la economia de la escuela');
insert into PlanEstrategico(nombre, anio_inicio, anio_termino, aprobado_por, descripcion)
values('Plan Secundario2', '2014', '2015', 1, 'Plan para la gestion de la escuela');
insert into PlanEstrategico(nombre, anio_inicio, anio_termino, aprobado_por, descripcion)
values('Plan Secundario3', '2015', '2016', 2, 'Plan para la politica de la escuela');
insert into PlanEstrategico(nombre, anio_inicio, anio_termino, aprobado_por, descripcion)
values('Plan Secundario4', '2016', '2017', 1, 'Plan para la organizacion de la escuela');
insert into PlanEstrategico(nombre, anio_inicio, anio_termino, aprobado_por, descripcion)
values('Plan Secundario5', '2017', '2018', 2, 'Plan para la educacion de la escuela');

# tabla PlanOperativo
insert into PlanOperativo(nombre, descripcion, id_plan_estrategico, id_encargado, id_unidad_org)
values('Plan Secundario', 'Plan para la educacion de la escuela', 1, 1, 2);
insert into PlanOperativo(nombre, descripcion, id_plan_estrategico, id_encargado, id_unidad_org)
values('Plan Integral', 'Plan para la educacion de la escuela', 1, 2, 2);
insert into PlanOperativo(nombre, descripcion, id_plan_estrategico, id_encargado, id_unidad_org)
values('Plan Secundario2', 'Plan para la economia de la escuela', 2, 1, 2);
insert into PlanOperativo(nombre, descripcion, id_plan_estrategico, id_encargado, id_unidad_org)
values('Plan Secundario3', 'Plan para la politica de la escuela', 2, 2, 2);

insert into PlanOperativo(nombre, descripcion, id_plan_estrategico, id_encargado, id_unidad_org)
values('Plan Secundario3', null, 1, 1, 4);


#select id, nombre, fecha_inicio, fecha_termino, anio_inicio, anio_termino, aprobado_por, descripcion from PlanEstrategico;