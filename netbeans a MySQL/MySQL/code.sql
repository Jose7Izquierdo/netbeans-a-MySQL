create database proyectoe;


create table  Estados(
id int auto_increment primary key,
nombre varchar (50) not null
);

create table EstadoCivil(
id int auto_increment primary key,
descripcion varchar (60) not null
);

create table Estudiantes(
id int AUTO_INCREMENT primary key,
nombre varchar (50) not null,
apellido varchar (50) not null,
fecha_nacimiento date not null,
direccion varchar (100),
estado_id int,
estado_civil_id int,
foreign key (estado_id) references Estados(id),
foreign key (estado_civil_id) references EstadoCivil(id)
);

create table Documentos(
id int auto_increment primary key,
tipo_documento varchar (50) not null,
numero_documento varchar (25) not null,
estudiente_id int,
foreign key (estudiente_id) references Estudiantes(id)
);