use master;
create database maristas;
GO
use maristas;
GO

-----------------------------------
--LOGIN
------------------------------------
create table rol(
	id int primary key IDENTITY,
	nombre varchar(30)
)

create table usuario(
	id int primary key IDENTITY,
	username varchar(30) not null, 
	contra varchar(30) not null,
	id_rol int not null foreign key references rol
)
-----------------------------------
--PLAN ESTRATEGICO
------------------------------------

create table PlanEstrategico(
	id int primary key IDENTITY,
	nombre varchar(100),
	fecha_inicio datetime,
	fecha_termino datetime,
	anio_inicio char(4),
	anio_termino char(4),
	aprobado_por int not null foreign key references usuario,
	descripcion varchar(100)
)


create table Linea(
	id int not null primary key IDENTITY,
	id_plan_estrategico int not null foreign key references PlanEstrategico,
	nombre varchar(30) not null, 
	descripcion varchar(30)
)


create table Objetivo(
	id int not null primary key IDENTITY,
	linea int not null foreign key references Linea,
	nombre varchar(50) not null,
	descripcion varchar(150) not null
)


create table SubObjetivo(
	id int not null primary key IDENTITY,
	objetivo int not null foreign key references objetivo,
	nombre varchar(50) not null,
	descripcion varchar(150) not null
)

-----------------------------------
--PLAN PRESUPUESTAL
------------------------------------

create table PlanPresupuestal(
	id int not null primary key IDENTITY,
	nombre varchar(30) not null,
	monto money not null,
	fecha_inicio date not null DEFAULT GETDATE(),
	fecha_final date not null,
)

-----------------------------------
--PLAN OPERATIVO
------------------------------------

create table UnidadOrganizativa(
	id int not null primary key IDENTITY,
	nombre varchar(30) not null,
)

create table PlanOperativo(
	id int not null primary key IDENTITY,
	nombre varchar(30) not null,
	descripcion varchar(150) null,
	id_plan_estrategico int not null foreign key references PlanEstrategico,
	id_encargado int not null foreign key references rol,
	id_unidad_org int not null foreign key references UnidadOrganizativa
)


create table actividad(
	id int not null primary key IDENTITY,
	id_plan_operativo int not null foreign key references PlanOperativo,
	nombre varchar(30) not null,
	gastos money null,
	ingresos money null,
	id_sub_objetivo int not null foreign key references SubObjetivo,
	id_presupuesto int not null foreign key references PlanPresupuestal,
)

create table indicador(
	id int not null primary key IDENTITY,
	id_actividad int not null foreign key references actividad,
	nombre varchar(30) not null,
	tipo_logo varchar(30) not null,
	logro varchar(50) not null,
)

create table programacion(
	id int not null primary key IDENTITY,
	id_actividad int not null foreign key references actividad,
	fecha_inicio date not null DEFAULT GETDATE(),
	fecha_final date not null DEFAULT GETDATE(),
)


insert into PlanEstrategico(nombre, fecha_inicio, fecha_termino, anio_inicio, anio_termino, aprobado_por, descripcion) 
values('Plan integral', '12/08/2014', '14/09/2014', '2014', '2014', 1, 'Plan principal de toda la escuela')

insert into PlanEstrategico(nombre, fecha_inicio, fecha_termino, anio_inicio, anio_termino, aprobado_por, descripcion) 
values('Plan Secundario', '10/08/2013', '14/09/2015', '2013', '2015', 1, 'Plan para la economia de la escuela')

select id, nombre, fecha_inicio, fecha_termino, anio_inicio, anio_termino, aprobado_por, descripcion from PlanEstrategico