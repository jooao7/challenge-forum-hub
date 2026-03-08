CREATE TABLE respostas(

    id bigint not null auto_increment,
    mensagem TEXT,
    topico_id bigint not null,
    data_criacao datetime not null,
    autor_id bigint not null,
    solucao varchar(100) not null,


    primary key(id),
    constraint fk_respostas_autor_id foreign key(autor_id) references autores(id),
    constraint fk_respostas_topico_id foreign key(topico_id) references topicos(id)

);