create table alunos (
    id bigint not null AUTO_INCREMENT,
    nome varchar(100) not null,
    email varchar(100) not null,
    senha varchar(255) not null,
    logradouro varchar(100),
    bairro varchar(100) not null,
    cep varchar(9) not null,
    complemento varchar(100),
    numero varchar(20),
    uf char(2) not null,
    cidade varchar(100) not null,
    ativo tinyint not null,

    primary key(id)
)
