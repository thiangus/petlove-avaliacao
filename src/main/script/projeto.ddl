--Usuários: você deve criar o cadastro, com nome, e-mail e senha
--Proprietário: Cadastro completo, com dados pessoais e endereço
--Animais: Nome, data de nascimento, raça, espécie e proprietário
--Serviços: Descrição do serviço e valor de venda
--Agenda: Criar agendamento com os dados do animal, proprietário, serviço e horário


create table usuario (
                         id int primary key not null,
                         nome varchar (255) not null,
                         email varchar (255) not null,
                         senha varchar (255) not null
);



create table endereco(
                         id int primary key not null,
                         cep varchar(255) not null,
                         logradouro varchar(255) not null,
                         complemento varchar(255),
                         cidade varchar(255),
                         uf varchar(2)
);

create table proprietario (
                              id int primary key not null,
                              nome varchar (255) not null,
                              data_nascimento date not null,
                              usuario_id int not null,
                              endereco_id int not null,
                              UNIQUE(usuario_id),
                              CONSTRAINT fk_usuario FOREIGN KEY(usuario_id) REFERENCES usuario(id),
                              CONSTRAINT fk_endereco FOREIGN KEY(endereco_id) REFERENCES endereco(id)
--  usuario_id INT FOREIGN KEY REFERENCES usuario(id)
);


create table raca(
                     id int primary key not null,
                     nome varchar (255) not null
);

create table especie(
                        id int primary key not null,
                        nome varchar (255) not null
);

create table animal(
                       id int primary key not null,
                       nome varchar (255) not null,
                       data_nascimento  date,
                       raca_id int not null,
                       especie_id int not null,
                       proprietario_id int not null,
                       CONSTRAINT fk_raca FOREIGN KEY(raca_id) REFERENCES raca(id),
                       CONSTRAINT fk_especie FOREIGN KEY(especie_id) REFERENCES especie(id),
                       CONSTRAINT fk_proprietario FOREIGN KEY(proprietario_id) REFERENCES proprietario(id)
);

create table servico(
                        id int primary key not null,
                        descricao varchar (255) not null,
                        valor numeric(3,2) not null
);


create table agenda (
                        id int primary key not null,
                        descricao varchar (255) not null,
                        horario date not null,
                        animal_id INT not null,
                        proprietario_id INT not null,
                        servico_id INT  not null,
                        CONSTRAINT fk_animal FOREIGN KEY(animal_id) REFERENCES animal(id),
                        CONSTRAINT fk_servico FOREIGN KEY(servico_id) REFERENCES servico(id),
                        CONSTRAINT fk_proprietario FOREIGN KEY(proprietario_id) REFERENCES proprietario(id)

);

CREATE SEQUENCE usuario_sequence;
CREATE SEQUENCE endereco_sequence;
CREATE SEQUENCE proprietario_sequence;
CREATE SEQUENCE raca_sequence;
CREATE SEQUENCE especie_sequence;
CREATE SEQUENCE animal_sequence;
CREATE SEQUENCE servico_sequence;
CREATE SEQUENCE agenda_sequence;
