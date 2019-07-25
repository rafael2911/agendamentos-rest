INSERT INTO USUARIO(nome, email, senha) VALUES('Aluno', 'aluno@email.com', '$2a$10$lOAE44uqqKC6ECy3TvVD4.7/VvrivGeMKOIYCukeM/Yu1jdKkNIyO');

insert into motivo (descricao) values('Viagem');

insert into grupo (descricao, ativo) values('Equipamentos', 1);
insert into grupo (descricao, ativo) values('Veículos', 1);

insert into item (descricao, grupo_id, ativo) values('Notebook 1', 1, 1);
insert into item (descricao, grupo_id, ativo) values('Projetor 1', 1, 1);
insert into item (descricao, grupo_id, ativo) values('Moto 1', 2, 1);
insert into item (descricao, grupo_id, ativo) values('Carro 1', 2, 1);