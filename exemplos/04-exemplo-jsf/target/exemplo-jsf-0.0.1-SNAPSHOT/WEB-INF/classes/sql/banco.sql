CREATE TABLE produto (
	id serial not null,
	nome varchar(255) not null,
	preco double not null,
	descricao varchar(255),
	PRIMARY KEY(id)
)