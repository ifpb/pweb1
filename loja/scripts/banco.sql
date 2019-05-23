CREATE TABLE usuarios (
    id serial not null,
    primeiroNome varchar(200) not null,
    ultimoNome varchar(200) not null,
    dataNascimento timestamp not null,
    genero varchar(20) not null,
    telefone varchar(20) not null,
    senha varchar(64) not null,
    email varchar(200),
    cidade varchar(150),
    pais varchar(100),
    primary key (id)
)