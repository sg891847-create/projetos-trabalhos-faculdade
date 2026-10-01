create database escola;
use escola;
create table aluno(
id int auto_increment primary key,
nome varchar(50) not null,
idade int not null,
curso varchar(50) not null);
 show tables;
 desc aluno;
 
 insert into aluno (nome, idade, curso)
	value
    ("Nero", "18", "paleontologia"),
    ("Lence", "18", "gastronomia"),
    ("May", "18", "biologia"),
    ("Yamato", "18", "direito"),
    ("Flora", "18", "literatura"),
    ("Elsie", "17", "historia");
    select*from aluno;
    
 create table professor(
id int auto_increment primary key,
nome varchar(50) not null,
idade int not null,
diciplina varchar(50) not null);
 show tables;
 desc professor;
  insert into professor (nome, idade, diciplina)
	value
    ("cayde", "25", "bilogia"),
    ("ogami", "65", "historia");
        select*from professor;

create table matricla(
id int auto_increment primary key,
id_aluno int not null,
id_professor int not null,
data_matricul date,
foreign key (id_aluno) references aluno(id),
foreign key (id_professor) references professor(id));
 show tables;
 desc matricula;

  insert into matricla (id_aluno, id_professor, data_matricul)
	value
    ("1", "1", "2026-09-23"),
    ("1", "1", "2026-09-23"),
    ("1", "1", "2026-09-23"),
    ("1", "1", "2026-09-23"),
    ("1", "1", "2026-09-23");
        select*from matricla;
