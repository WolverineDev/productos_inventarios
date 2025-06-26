create database empresa_articulos;

use empresa_articulos;


/*

delete from Producto;

delete from Inventario;




drop table Producto;

drop table Inventario;
*/




create table Producto (
	id varchar(20) not null,
	nombre varchar(30),
	precio varchar(50)
);


create table Inventario (
	id varchar(20) not null,
	producto varchar(20) not null,
	cantidad int,

);




select * from Producto;

select * from Inventario;




