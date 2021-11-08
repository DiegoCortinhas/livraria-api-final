create table autores(
	id bigint not null auto_increment,
	nome varchar(100) not null,
	email varchar(50) not null,
	dataNascimento date not null,
	miniCurriculo varchar(200) not null,
	primary key(id)
);	