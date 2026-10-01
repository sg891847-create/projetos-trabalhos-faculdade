create database BDaula;

show databases;
use BDaula;

create table pessoa(
id int auto_increment primary key,
nome varchar(50) not null,
sexo varchar(1) not null,
idioma varchar(50) not null);
 
 show tables;
 desc pessoa;
 
 insert into pessoa (nome, sexo, idioma)
 value ("Nero", "M", "Japones"),
		("Lence", "M", "Portugues"),
		("May", "F", "Japones"),
		("Yamato", "M", "Alemao"),
		("Flora", "F", "Frances"),
		("Elsie", "F", "Russo");
    
     select*from pessoa;