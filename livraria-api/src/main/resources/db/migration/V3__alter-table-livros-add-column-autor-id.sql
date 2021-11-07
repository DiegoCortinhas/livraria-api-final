alter table livros add column cadastroAutor_id bigint not null;
alter table livros add foreign key (cadastroAutor_id) references autores(id);