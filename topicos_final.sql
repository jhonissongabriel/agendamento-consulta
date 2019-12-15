drop database topicos_final;
create database `topicos_final`;

use topicos_final;

create table pess_pessoa(
	id_pess bigint primary key not null auto_increment,
	pess_nome varchar(100) not null,
	pess_cpf varchar(11) not null unique key,
	pess_data_nasc varchar(10) not null
);

insert into pess_pessoa(pess_nome,pess_cpf,pess_data_nasc) values('Jhonisson Gabriel','12312312312','11/07/1990');
insert into pess_pessoa(pess_nome,pess_cpf,pess_data_nasc) values('João Manuel','23423423423','13/05/1980');
insert into pess_pessoa(pess_nome,pess_cpf,pess_data_nasc) values('Maria Aparecida','34534534534','18/11/1992');
insert into pess_pessoa(pess_nome,pess_cpf,pess_data_nasc) values('Carlos Augusto','45645645645','22/09/1995');
insert into pess_pessoa(pess_nome,pess_cpf,pess_data_nasc) values('Luciana dos Santos','56756756756','07/06/1974');
insert into pess_pessoa(pess_nome,pess_cpf,pess_data_nasc) values('Kaio da SIlva','67867867867','01/04/1985');
insert into pess_pessoa(pess_nome,pess_cpf,pess_data_nasc) values('John Almeida','78978978978','11/10/1964');
insert into pess_pessoa(pess_nome,pess_cpf,pess_data_nasc) values('Carla de Jesus da Silva','89089089089','13/11/1980');
insert into pess_pessoa(pess_nome,pess_cpf,pess_data_nasc) values('Junior Benedito Amaral','90190190190','18/08/1992');
insert into pess_pessoa(pess_nome,pess_cpf,pess_data_nasc) values('Alessandro Cardoso Prado','01201201201','07/02/1995');
insert into pess_pessoa(pess_nome,pess_cpf,pess_data_nasc) values('Lucas da Rocha','09809809809','28/02/1974');
insert into pess_pessoa(pess_nome,pess_cpf,pess_data_nasc) values('Mary Jane da SIlva','98798798798','30/03/1954');


create table conv_convenio(
	id_conv bigint primary key not null auto_increment,
	conv_convenio boolean not null,
	conv_empr_conv varchar(50),
    conv_registro varchar(20),
	conv_data_validade varchar(10)
);

insert into conv_convenio(conv_convenio,conv_empr_conv,conv_registro,conv_data_validade) 
values (true,'Conveio Ceu','6542158760','20/05/2024');
insert into conv_convenio(conv_convenio,conv_empr_conv,conv_registro,conv_data_validade) 
values (true,'Santo Convênio','5246125490','15/08/2023');
insert into conv_convenio(conv_convenio,conv_empr_conv,conv_registro,conv_data_validade) 
values (true,'Giga Medi','6531254654','19/09/2021');
insert into conv_convenio(conv_convenio,conv_empr_conv,conv_registro,conv_data_validade) 
values (true,'Amilhão','9696511212','12/03/2021');
insert into conv_convenio(conv_convenio,conv_empr_conv,conv_registro,conv_data_validade) 
values (true,'Unimed','7784841004','17/01/2027');
insert into conv_convenio(conv_convenio,conv_empr_conv,conv_registro,conv_data_validade) 
values (true,'Porto Seguro','4654045405','31/12/2019');
insert into conv_convenio(conv_convenio,conv_empr_conv,conv_registro,conv_data_validade) 
values (true,'Amilhão','9595621032','20/05/2020');
insert into conv_convenio(conv_convenio,conv_empr_conv,conv_registro,conv_data_validade) 
values (true,'Medis Centro','1124516065','20/12/2022');
insert into conv_convenio(conv_convenio,conv_empr_conv,conv_registro,conv_data_validade) 
values (true,'Santo Convênio','4500454658','21/11/2024');
insert into conv_convenio(conv_convenio,conv_empr_conv,conv_registro,conv_data_validade) 
values (true,'Medis Centro','9555654564','11/07/2030');

create table medi_medico(
	id_medi bigint primary key not null auto_increment,
    medi_nome varchar(100)not null,
    medi_crm varchar(10) unique not null 
);

insert into medi_medico(medi_nome, medi_crm) values('Mariana Ribeiro', '9485763');
insert into medi_medico(medi_nome, medi_crm) values('Mauro Robeto França','9885967');
insert into medi_medico(medi_nome, medi_crm) values('Rosa da Cunha','1248963');
insert into medi_medico(medi_nome, medi_crm) values('Bronco Souza Moura','9104933');
insert into medi_medico(medi_nome, medi_crm) values('Francisco Peri','3242675');

create table ende_endereco(
	id_ende bigint primary key not null auto_increment,
	ende_rua varchar(100) not null,
	ende_numero int not null,
    ende_edificio varchar(50),
    ende_andar varchar(20),
    ende_sala varchar(20),
	ende_cep varchar(9) not null,
	ende_bairro varchar(50) not null,
	ende_cidade varchar(50) not null
);

insert into ende_endereco(ende_rua, ende_numero, ende_cep, ende_bairro, ende_cidade) 
values('Rua das flores',123,'21434-654','Jardim das Flores','Rio de Janeiro');
insert into ende_endereco(ende_rua, ende_numero, ende_cep, ende_bairro, ende_cidade) 
values('Av. XV de Novembro',900,'54212-004','Centro','Pouso Alegre');
insert into ende_endereco(ende_rua, ende_numero, ende_cep, ende_bairro, ende_cidade) 
values('Av. José da Silva',600,'33112-100','Vila das Velas','São José das Contas');
insert into ende_endereco(ende_rua, ende_numero, ende_cep, ende_bairro, ende_cidade) 
values('Av.Brasil',123,'12112-320','Jardim Paulista','São José dos Campos');
insert into ende_endereco(ende_rua, ende_numero, ende_cep, ende_bairro, ende_cidade) 
values('Av. São João',1654,'12312-650','Jardim Aquárius','São José dos Campos');
insert into ende_endereco(ende_rua, ende_numero, ende_cep, ende_bairro, ende_cidade) 
values('Rua das Andorinhas',1050,'21345-650','Jardim dos Pássaros','São Bernado do Campo');
insert into ende_endereco(ende_rua, ende_numero, ende_cep, ende_bairro, ende_cidade) 
values('Av. Paulista',10050,'11150-000','Centro','São Paulo');
insert into ende_endereco(ende_rua, ende_numero, ende_cep, ende_bairro, ende_cidade) 
values('Dr. Ignácio Proença de Gouveia', 1117,'11232-100','Casa Verde','São Paulo');
insert into ende_endereco(ende_rua, ende_numero, ende_cep, ende_bairro, ende_cidade) 
values('Av. dos Astrounautas',100,'32123-370','Novo Mundo','Belo Horizonte');
insert into ende_endereco(ende_rua, ende_numero, ende_cep, ende_bairro, ende_cidade) 
values('Av. Antonio Carlos Magalhães',1500,'71425-010','Pernambuéis','Salvador');

create table cont_contato(
	id_cont bigint primary key not null auto_increment,
	cont_telefone varchar(11) not null,
	cont_email varchar(50),
    cont_site varchar(50)
);

insert into cont_contato(cont_telefone, cont_email) values ('12981979448','jhonisson.gabriel@gmail.com');
insert into cont_contato(cont_telefone, cont_email) values ('21546879454','joao948209384@gmail.com');
insert into cont_contato(cont_telefone, cont_email) values ('11556641238','maria982048@gmail.com');
insert into cont_contato(cont_telefone, cont_email, cont_site) values ('11245465466','rw242@corvale.com.br','http://www.corvale.com.br/');
insert into cont_contato(cont_telefone, cont_email) values ('12654879897','luc92834@terra.com.br');
insert into cont_contato(cont_telefone, cont_email) values ('11213456987','nosso-email@bol.com.br');
insert into cont_contato(cont_telefone, cont_email) values ('11654987321','jaskl2@bol.com');
insert into cont_contato(cont_telefone) values ('41963215648');
insert into cont_contato(cont_telefone) values ('7946532168');
insert into cont_contato(cont_telefone) values ('2165321645');
insert into cont_contato(cont_telefone, cont_email, cont_site) values ('1132329081','contato@spmed.com.br','http://www.spmed.com.br/');


create table usua_usuario(
	id_usua bigint primary key not null auto_increment,
    usua_nome varchar(20) not null unique,
    usua_senha varchar(50) not null
);

insert into usua_usuario(usua_nome, usua_senha) values('admin', concat('{MD5}', MD5('admin')));
insert into usua_usuario(usua_nome, usua_senha) values('jhonisson',concat('{MD5}', MD5('jhonisson@123')));
insert into usua_usuario(usua_nome, usua_senha) values('jomanu',concat('{MD5}', MD5('4%@$#hg B@123')));
insert into usua_usuario(usua_nome, usua_senha) values('ma_aparecida',concat('{MD5}', MD5('familia10')));
insert into usua_usuario(usua_nome, usua_senha) values('augusto-c',concat('{MD5}', MD5('88GBA$%bbhasUHD&*')));
insert into usua_usuario(usua_nome, usua_senha) values('lucsantos',concat('{MD5}', MD5('lulu4321#1$%S%A$D%¨SD')));
insert into usua_usuario(usua_nome, usua_senha) values('teste90',concat('{MD5}', MD5('dasd@123')));
insert into usua_usuario(usua_nome, usua_senha) values('xxxcad',concat('{MD5}', MD5('4%@$#asdaf3')));
insert into usua_usuario(usua_nome, usua_senha) values('louco_doido',concat('{MD5}', MD5('aad55q46e#')));
insert into usua_usuario(usua_nome, usua_senha) values('ricoci',concat('{MD5}', MD5('adIksd456sUHD&*')));
insert into usua_usuario(usua_nome, usua_senha) values('cas900bs',concat('{MD5}', MD5('dfgSAdfgD%D')));


create table auto_autorizacao(
	id_auto bigint primary key not null auto_increment,
    auto_nome varchar(20) not null unique,
    auto_role varchar(20) not null unique
);

insert into auto_autorizacao(auto_nome, auto_role) values('Administrador','ROLE_ADMIN');
insert into auto_autorizacao(auto_nome, auto_role) values('Gestor','ROLE_GESTOR');
insert into auto_autorizacao(auto_nome, auto_role) values('Cliente','ROLE_CLIENTE');
insert into auto_autorizacao(auto_nome, auto_role) values('Funcionario','ROLE_FUNCIONARIO');
insert into auto_autorizacao(auto_nome, auto_role) values('Médico','ROLE_MEDICO');

create table espe_especialidade(
	id_espe bigint primary key not null auto_increment,
	espe_nome varchar(50) not null
);

insert into espe_especialidade(espe_nome) values('Acupuntura');
insert into espe_especialidade(espe_nome) values('Alergia e Imunologia');
insert into espe_especialidade(espe_nome) values('Anestesiologia');
insert into espe_especialidade(espe_nome) values('Angiologia');
insert into espe_especialidade(espe_nome) values('Cancerologia');
insert into espe_especialidade(espe_nome) values('Cardiologia');
insert into espe_especialidade(espe_nome) values('Cirurgia Cardiovascular');
insert into espe_especialidade(espe_nome) values('Cirurgia da Mão');
insert into espe_especialidade(espe_nome) values('Cirurgia de Cabeça e Pescoço');
insert into espe_especialidade(espe_nome) values('Cirurgia do Aparelho Digestivo');
insert into espe_especialidade(espe_nome) values('Cirurgia Geral');
insert into espe_especialidade(espe_nome) values('Cirurgia Pediátrica');
insert into espe_especialidade(espe_nome) values('Cirurgia Plástica');
insert into espe_especialidade(espe_nome) values('Cirurgia Torácica');
insert into espe_especialidade(espe_nome) values('Cirurgia Vascular');
insert into espe_especialidade(espe_nome) values('Clínica Médica');
insert into espe_especialidade(espe_nome) values('Coloproctologia');
insert into espe_especialidade(espe_nome) values('Dermatologia');
insert into espe_especialidade(espe_nome) values('Endocrinologia e Metabologia');
insert into espe_especialidade(espe_nome) values('Endoscopia');
insert into espe_especialidade(espe_nome) values('Gastroenterologia');
insert into espe_especialidade(espe_nome) values('Genética Médica');
insert into espe_especialidade(espe_nome) values('Geriatria');
insert into espe_especialidade(espe_nome) values('Ginecologia e Obstetrícia');
insert into espe_especialidade(espe_nome) values('Hematologia e Hemoterapia');
insert into espe_especialidade(espe_nome) values('Homeopatia');
insert into espe_especialidade(espe_nome) values('Infectologia');
insert into espe_especialidade(espe_nome) values('Mastologia');
insert into espe_especialidade(espe_nome) values('Medicina de Família e Comunidade');
insert into espe_especialidade(espe_nome) values('Medicina de Emergência');
insert into espe_especialidade(espe_nome) values('Medicina do Trabalho');
insert into espe_especialidade(espe_nome) values('Medicina Esportiva');
insert into espe_especialidade(espe_nome) values('Medicina Física e Reabilitação');
insert into espe_especialidade(espe_nome) values('Medicina Intensiva');
insert into espe_especialidade(espe_nome) values('Medicina Legal e Perícia Médica');
insert into espe_especialidade(espe_nome) values('Medicina Nuclear');
insert into espe_especialidade(espe_nome) values('Medicina Preventiva e Social');
insert into espe_especialidade(espe_nome) values('Nefrologia');
insert into espe_especialidade(espe_nome) values('Neurocirurgia');
insert into espe_especialidade(espe_nome) values('Neurologia');
insert into espe_especialidade(espe_nome) values('Nutrologia');
insert into espe_especialidade(espe_nome) values('Obstetrícia');
insert into espe_especialidade(espe_nome) values('Oftalmologia');
insert into espe_especialidade(espe_nome) values('Ortopedia e Traumatologia');
insert into espe_especialidade(espe_nome) values('Otorrinolaringologia');
insert into espe_especialidade(espe_nome) values('Patologia');
insert into espe_especialidade(espe_nome) values('Patologia Clínica/Medicina Laboratorial');
insert into espe_especialidade(espe_nome) values('Pediatria');
insert into espe_especialidade(espe_nome) values('Pneumologia');
insert into espe_especialidade(espe_nome) values('Psiquiatria');
insert into espe_especialidade(espe_nome) values('Radiologia e Diagnóstico por Imagem');
insert into espe_especialidade(espe_nome) values('Radioterapia');
insert into espe_especialidade(espe_nome) values('Reumatologia');
insert into espe_especialidade(espe_nome) values('Urologia');


create table cons_consultorio(
	id_cons bigint primary key not null auto_increment,
	cons_nome varchar(100) not null,
	cons_cnpj varchar(18),
	ende_id bigint not null,
    cont_id bigint not null,
    constraint cont_cons_fk foreign key (cont_id) references cont_contato(id_cont),
    constraint ende_cons_fk foreign key (ende_id) references ende_endereco(id_ende)
);

insert into cons_consultorio(cons_nome, cons_cnpj, ende_id, cont_id) values('Clínica Vale Vida','31.222.222/0001-32',5,2);
insert into cons_consultorio(cons_nome, cons_cnpj, ende_id, cont_id) values('Clínica OrtoPaulo','56.656.565/0001-79',7,8);
insert into cons_consultorio(cons_nome, cons_cnpj, ende_id, cont_id) values('Clínica Vanadium','11.345.345/0001-30',4,4);
insert into cons_consultorio(cons_nome, cons_cnpj, ende_id, cont_id) values('Clínica Urodedo','99.888.777/0001-02',1,3);
insert into cons_consultorio(cons_nome, cons_cnpj, ende_id, cont_id) values('Clínica Cardio Center','11.333.222/0001-55',3,5);
insert into cons_consultorio(cons_nome, cons_cnpj, ende_id, cont_id) values('Clínica MedSul','55.999.555/0001-35',9,2);


create table agen_agenda(
	id_agen bigint primary key not null auto_increment,
	agen_data varchar(10) not null,
	agen_horario varchar(5) not null,
    cons_id bigint not null,
    espe_id bigint not null,
    medi_id bigint not null,
	cont_id bigint not null,
    ende_id bigint not null,
    constraint cons_agen_fk foreign key (cons_id) references cons_consultorio(id_cons),
	constraint espe_agen_fk foreign key (espe_id) references espe_especialidade(id_espe),
	constraint medi_agen_fk foreign key (medi_id) references medi_medico(id_medi),
    constraint cont_agen_fk foreign key (cont_id) references cont_contato(id_cont),
	constraint ende_agen_fk foreign key (ende_id) references ende_endereco(id_ende)
);

insert into agen_agenda(agen_data, agen_horario, cons_id, ende_id, cont_id, espe_id, medi_id) values('03/12/2019','13:00',2,1,1,1,1);
insert into agen_agenda(agen_data, agen_horario, cons_id, ende_id, cont_id, espe_id, medi_id) values('15/12/2019','18:00',1,2,2,2,1);
insert into agen_agenda(agen_data, agen_horario, cons_id, ende_id, cont_id, espe_id, medi_id) values('03/11/2019','11:00',4,3,3,3,2);
insert into agen_agenda(agen_data, agen_horario, cons_id, ende_id, cont_id, espe_id, medi_id) values('20/12/2019','14:50',4,4,4,4,3);
insert into agen_agenda(agen_data, agen_horario, cons_id, ende_id, cont_id, espe_id, medi_id) values('10/01/2020','13:00',2,1,1,1,1);
insert into agen_agenda(agen_data, agen_horario, cons_id, ende_id, cont_id, espe_id, medi_id) values('13/12/2019','19:00',5,2,2,2,1);
insert into agen_agenda(agen_data, agen_horario, cons_id, ende_id, cont_id, espe_id, medi_id) values('31/12/2019','09:00',5,3,3,3,2);
insert into agen_agenda(agen_data, agen_horario, cons_id, ende_id, cont_id, espe_id, medi_id) values('11/02/2020','11:30',3,4,4,4,3);

create table paci_paciente(
	id_paci bigint primary key not null auto_increment,
	pess_id bigint not null,
    agen_id bigint not null,
	ende_id bigint not null,
	cont_id bigint not null,
    constraint pess_paci_fk foreign key (pess_id) references pess_pessoa(id_pess),
    constraint agen_paci_fk foreign key (agen_id) references agen_agenda(id_agen),
    constraint ende_paci_fk foreign key (ende_id) references ende_endereco(id_ende),
    constraint cont_paci_fk foreign key (cont_id) references cont_contato(id_cont)
);

insert into paci_paciente(pess_id, agen_id, ende_id, cont_id) values(3,2,2,1);
insert into paci_paciente(pess_id, agen_id, ende_id, cont_id) values(4,1,4,4);


create table func_funcionario(
	id_func bigint primary key not null auto_increment,
	func_registro varchar(6) not null,
	func_data_admissao varchar(10) not null,
	func_data_demissao varchar(10),
	pess_id bigint not null,
	cont_id bigint not null,
	ende_id bigint not null,
    constraint pess_func_fk foreign key (pess_id) references pess_pessoa(id_pess),
    constraint cont_func_fk foreign key (cont_id) references cont_contato(id_cont),
    constraint ende_func_fk foreign key (ende_id) references ende_endereco(id_ende)
);

insert into func_funcionario(func_registro, func_data_admissao, pess_id, cont_id, ende_id)
values('234355','12/08/2015',2,10,6);


create table ua_usuario_autorizacao(
	usua_id bigint not null,
    auto_id bigint not null,
    primary key (usua_id, auto_id),
    foreign key ua_usuario_fk (usua_id) references usua_usuario(id_usua) on delete restrict on update cascade,
	foreign key ua_autorizacao_fk (auto_id) references auto_autorizacao(id_auto) on delete restrict on update cascade
);	

insert into ua_usuario_autorizacao(usua_id,auto_id) values(1,1);
insert into ua_usuario_autorizacao(usua_id,auto_id) values(2,3);
insert into ua_usuario_autorizacao(usua_id,auto_id) values(3,4);
insert into ua_usuario_autorizacao(usua_id,auto_id) values(4,5);
insert into ua_usuario_autorizacao(usua_id,auto_id) values(5,3);
insert into ua_usuario_autorizacao(usua_id,auto_id) values(6,1);


create table cp_convenio_paciente(
	conv_id bigint not null,
    paci_id bigint not null,
    primary key (conv_id, paci_id),
    foreign key cp_convenio_fk (conv_id) references conv_convenio(id_conv) on delete restrict on update cascade,
	foreign key cp_paciente_fk (paci_id) references paci_paciente(id_paci) on delete restrict on update cascade
);

insert into cp_convenio_paciente(conv_id, paci_id) values(4,1);
insert into cp_convenio_paciente(conv_id, paci_id) values(1,2);


create table ap_agenda_paciente(
	agen_id bigint not null,
    paci_id bigint not null,
    primary key (agen_id, paci_id),
    foreign key ap_agenda_fk (agen_id) references agen_agenda(id_agen) on delete restrict on update cascade,
	foreign key ap_paciente_fk (paci_id) references paci_paciente(id_paci) on delete restrict on update cascade
);

insert into ap_agenda_paciente(agen_id, paci_id) values(1,1);
insert into ap_agenda_paciente(agen_id, paci_id) values(2,2);
insert into ap_agenda_paciente(agen_id, paci_id) values(4,1);
insert into ap_agenda_paciente(agen_id, paci_id) values(3,1);


create table em_especialidade_medico(
	espe_id bigint not null,
    medi_id bigint not null,
    primary key (espe_id, medi_id),
    foreign key em_especialidade_fk (espe_id) references espe_especialidade(id_espe) on delete restrict on update cascade,
	foreign key em_medico_fk (medi_id) references medi_medico(id_medi) on delete restrict on update cascade
);

insert into em_especialidade_medico(espe_id,medi_id) values(1,4);
insert into em_especialidade_medico(espe_id,medi_id) values(2,4);
insert into em_especialidade_medico(espe_id,medi_id) values(3,3);
insert into em_especialidade_medico(espe_id,medi_id) values(4,3);
insert into em_especialidade_medico(espe_id,medi_id) values(5,3);
insert into em_especialidade_medico(espe_id,medi_id) values(11,1);
insert into em_especialidade_medico(espe_id,medi_id) values(12,1);
insert into em_especialidade_medico(espe_id,medi_id) values(15,1);
insert into em_especialidade_medico(espe_id,medi_id) values(21,2);
insert into em_especialidade_medico(espe_id,medi_id) values(27,2);
insert into em_especialidade_medico(espe_id,medi_id) values(34,2);
insert into em_especialidade_medico(espe_id,medi_id) values(43,2);

create table ce_consultorio_especialidade(
	cons_id bigint not null,
    espe_id bigint not null,
    primary key(cons_id, espe_id),
	foreign key ce_cons_fk (cons_id) references cons_consultorio(id_cons) on delete restrict on update cascade,
	foreign key ce_espe_fk (espe_id) references espe_especialidade(id_espe) on delete restrict on update cascade
);

insert into ce_consultorio_especialidade(cons_id, espe_id) values(1,1);
insert into ce_consultorio_especialidade(cons_id, espe_id) values(1,32);
insert into ce_consultorio_especialidade(cons_id, espe_id) values(1,10);
insert into ce_consultorio_especialidade(cons_id, espe_id) values(1,15);
insert into ce_consultorio_especialidade(cons_id, espe_id) values(1,19);
insert into ce_consultorio_especialidade(cons_id, espe_id) values(1,34);
insert into ce_consultorio_especialidade(cons_id, espe_id) values(1,43);
insert into ce_consultorio_especialidade(cons_id, espe_id) values(1,50);

insert into ce_consultorio_especialidade(cons_id, espe_id) values(2,1);
insert into ce_consultorio_especialidade(cons_id, espe_id) values(2,32);
insert into ce_consultorio_especialidade(cons_id, espe_id) values(2,10);
insert into ce_consultorio_especialidade(cons_id, espe_id) values(2,15);
insert into ce_consultorio_especialidade(cons_id, espe_id) values(2,17);

insert into ce_consultorio_especialidade(cons_id, espe_id) values(3,52);
insert into ce_consultorio_especialidade(cons_id, espe_id) values(3,42);
insert into ce_consultorio_especialidade(cons_id, espe_id) values(3,20);


create table cm_consultorio_medico(
	cons_id bigint not null,
    medi_id bigint not null,
    primary key(cons_id, medi_id),
	foreign key cm_cons_fk (cons_id) references cons_consultorio(id_cons) on delete restrict on update cascade,
	foreign key cm_medi_fk (medi_id) references medi_medico(id_medi) on delete restrict on update cascade
);

insert into cm_consultorio_medico(cons_id,medi_id) values(1,1);
insert into cm_consultorio_medico(cons_id,medi_id) values(1,2);
insert into cm_consultorio_medico(cons_id,medi_id) values(1,3);
insert into cm_consultorio_medico(cons_id,medi_id) values(5,2);
insert into cm_consultorio_medico(cons_id,medi_id) values(2,1);
insert into cm_consultorio_medico(cons_id,medi_id) values(2,4);
insert into cm_consultorio_medico(cons_id,medi_id) values(3,4);
insert into cm_consultorio_medico(cons_id,medi_id) values(4,5);


create table up_usuario_pessoa(
	usua_id bigint not null,
    pess_id bigint not null,
    primary key(usua_id, pess_id),
	foreign key up_usua_fk (usua_id) references usua_usuario(id_usua) on delete restrict on update cascade,
	foreign key up_pess_fk (pess_id) references pess_pessoa(id_pess) on delete restrict on update cascade
);

insert into up_usuario_pessoa(usua_id,pess_id) values(1,1);
insert into up_usuario_pessoa(usua_id,pess_id) values(2,2);
insert into up_usuario_pessoa(usua_id,pess_id) values(3,3);
insert into up_usuario_pessoa(usua_id,pess_id) values(4,4);
insert into up_usuario_pessoa(usua_id,pess_id) values(5,5);
insert into up_usuario_pessoa(usua_id,pess_id) values(6,6);
