create table usuarios (
    id integer not null auto_increment,
    login varchar(32) not null,
    senha varchar(32) not null,
    admin char(1) not null,
    primary key (id),
    unique (login)
);

create table pedidos (
    id integer not null auto_increment,
    descricao varchar(255) not null,
    id_usuario int not null,
    status varchar(32) not null,
    primary key (id),
    foreign key (id_usuario) references usuarios (id)
);

insert into usuarios (login, senha, admin) values ('admin', 'admin', '1');
insert into usuarios (login, senha, admin) values ('teste1', 'teste1', '0');
insert into usuarios (login, senha, admin) values ('teste2', 'teste2', '0');
