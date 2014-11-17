use mysql;
drop database compraProveedor;
create database compraProveedor;
use compraProveedor;

create table role (
	id_role int auto_increment unique primary key,
	titulo varchar(30)
);

create table usuario (
	id_usuario int auto_increment unique primary key,
	usuario varchar(30),
	contrasena varchar(30),
	id_fk_role int,
	nombre varchar(30),
	foreign key (id_fk_role) references role(id_role)
); 

create table  pedido (
    id_pedido int auto_increment unique primary key,
    estado bool not null default 0,
    descripcion varchar(200),
    area varchar(100),
	fecha_titulo datetime NOT NULL DEFAULT NOW()
);

create table cotizacion (
	id_cotizacion int auto_increment unique primary key,
	id_fk_pedido int,
	id_fk_usuario int,
	forma_pago varchar(60),
	descripcion varchar(200),
	costo float null default 0,
	foreign key (id_fk_pedido) references pedido(id_pedido),
	foreign key (id_fk_usuario) references usuario(id_usuario)
);

insert into role(titulo) values("proveedor");
insert into role(titulo) values("jefe_compras");

insert into usuario(usuario, contrasena, id_fk_role, nombre) values ("usuario1", "123", 2, "John Paul");
insert into usuario(usuario, contrasena, id_fk_role, nombre) values ("usuario2", "123", 1, "Fiorella Silva");
insert into usuario(usuario, contrasena, id_fk_role, nombre) values ("usuario3", "123", 2, "Rosa Jimenez");

insert into pedido(descripcion, area) values("30 cajas de laptops", "Ventas");
insert into pedido(descripcion, area) values("60 cajas de teclados", "Marketing");
insert into pedido(descripcion, area) values("10 cajas de cuadernos", "Recursos Humanos");
insert into pedido(descripcion, area) values("100 cajas de mouses", "TI");
insert into pedido(descripcion, area) values("60 cajas de tizas", "Ventas");
insert into pedido(descripcion, area) values("30 telefonos", "Call center");

insert into cotizacion(id_fk_pedido, id_fk_usuario, forma_pago, descripcion, costo) values (1, 1, "contado", "esta en algo", 100.30);

insert into cotizacion(id_fk_pedido, id_fk_usuario, forma_pago, descripcion) values(1, 1, "1", "a")