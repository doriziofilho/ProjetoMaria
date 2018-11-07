CREATE SCHEMA IF NOT EXISTS `Maria` DEFAULT CHARACTER SET utf8 ;
USE `Maria` ;

drop table if exists SKU_PHASE;
drop table if exists HISTORICO;
drop table if exists CANAL;
drop table if exists PRODUTO;
drop table if exists FAMILIA_COMERCIAL;

create table FAMILIA_COMERCIAL(
ID_FAMILIA_COMERCIAL int(20) NOT NULL AUTO_INCREMENT,
COD_FAMILIA_COMERCIAL varchar(20),
NOME_FAMILIA_COMERCIAL varchar(30),
constraint PK_FAMILIA_COMERCIAL primary key (ID_FAMILIA_COMERCIAL),
constraint UN_FAMILIA_COMERCIAL unique (COD_FAMILIA_COMERCIAL)
);

create table CANAL(
ID_CANAL int(20) NOT NULL AUTO_INCREMENT,
DESCRICAO varchar(255),
constraint PK_CANAL primary key (ID_CANAL)
);

create table PRODUTO(
SKU int(20),
NOME_PRODUTO varchar(255),
ID_FAMILIA_COMERCIAL int(20),
constraint PK_PRODUTO_SKU primary key (SKU),
constraint FK_PRODUTO_FAMILIA_COMERCIAL foreign key (ID_FAMILIA_COMERCIAL) references FAMILIA_COMERCIAL (ID_FAMILIA_COMERCIAL)
);

create table HISTORICO(
ID_HISTORICO int(20) NOT NULL AUTO_INCREMENT,
MES_ANO Date,
QUANTIDADE int(20),
SKU int(20),
ID_CANAL int(20),
constraint PK_HISTORICO primary key (ID_HISTORICO),
constraint FK_PRODUTO_SKU_HISTORICO foreign key (SKU) references PRODUTO (SKU),
constraint FK_CANAL_HISTORICO foreign key (ID_CANAL) references CANAL (ID_CANAL)
);

create table SKU_PHASE(
SKU_PHASE_IN int(20),
SKU_PHASE_OUT int(20),
constraint PK_SKU_PHASE primary key (SKU_PHASE_IN,SKU_PHASE_OUT),
constraint FK_SKU_PHASE_IN foreign key (SKU_PHASE_IN) references PRODUTO (SKU),
constraint FK_SKU_PHASE_OUT foreign key (SKU_PHASE_OUT) references PRODUTO (SKU)
);


insert into CANAL (ID_CANAL,DESCRICAO) values (1,'Distribuição');
insert into CANAL (ID_CANAL,DESCRICAO) values (2,'Varejo');
insert into CANAL (ID_CANAL,DESCRICAO) values (3,'Verticais');
insert into CANAL (ID_CANAL,DESCRICAO) values (4,'Exportação');

insert into FAMILIA_COMERCIAL (ID_FAMILIA_COMERCIAL,COD_FAMILIA_COMERCIAL) values (1,'14414013');
insert into FAMILIA_COMERCIAL (ID_FAMILIA_COMERCIAL,COD_FAMILIA_COMERCIAL) values (2,'14411063');
insert into FAMILIA_COMERCIAL (ID_FAMILIA_COMERCIAL,COD_FAMILIA_COMERCIAL) values (3,'14433025');
insert into FAMILIA_COMERCIAL (ID_FAMILIA_COMERCIAL,COD_FAMILIA_COMERCIAL) values (4,'14432035');
insert into FAMILIA_COMERCIAL (ID_FAMILIA_COMERCIAL,COD_FAMILIA_COMERCIAL) values (5,'14442568');


insert into PRODUTO (ID_FAMILIA_COMERCIAL,SKU,NOME_PRODUTO) values (1,4000444,'Camera X10');
insert into PRODUTO (ID_FAMILIA_COMERCIAL,SKU,NOME_PRODUTO) values (1,4000442,'Camera X9');
insert into PRODUTO (ID_FAMILIA_COMERCIAL,SKU,NOME_PRODUTO) values (1,4000440,'Camera X8');
insert into PRODUTO (ID_FAMILIA_COMERCIAL,SKU,NOME_PRODUTO) values (1,4000408,'Camera X7');
insert into PRODUTO (ID_FAMILIA_COMERCIAL,SKU,NOME_PRODUTO) values (1,4000406,'Camera X6');
insert into PRODUTO (ID_FAMILIA_COMERCIAL,SKU,NOME_PRODUTO) values (1,4000404,'Camera X5');
insert into PRODUTO (ID_FAMILIA_COMERCIAL,SKU,NOME_PRODUTO) values (1,4000402,'Camera X3');
insert into PRODUTO (ID_FAMILIA_COMERCIAL,SKU,NOME_PRODUTO) values (1,4000400,'Camera X1');


insert into SKU_PHASE (SKU_PHASE_IN,SKU_PHASE_OUT) values (4000444,4000442);
insert into SKU_PHASE (SKU_PHASE_IN,SKU_PHASE_OUT) values (4000444,4000440);
insert into SKU_PHASE (SKU_PHASE_IN,SKU_PHASE_OUT) values (4000444,4000408);
insert into SKU_PHASE (SKU_PHASE_IN,SKU_PHASE_OUT) values (4000444,4000406);
insert into SKU_PHASE (SKU_PHASE_IN,SKU_PHASE_OUT) values (4000444,4000404);
insert into SKU_PHASE (SKU_PHASE_IN,SKU_PHASE_OUT) values (4000444,4000402);
insert into SKU_PHASE (SKU_PHASE_IN,SKU_PHASE_OUT) values (4000444,4000400);



insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,1,4000400,str_to_date('jan/11','%b/%y'),197);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,2,4000400,str_to_date('feb/11','%b/%y'),279);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,3,4000400,str_to_date('mar/11','%b/%y'),294);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,4,4000400,str_to_date('apr/11','%b/%y'),488);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,5,4000400,str_to_date('may/11','%b/%y'),298);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,6,4000400,str_to_date('jun/11','%b/%y'),394);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,7,4000400,str_to_date('jul/11','%b/%y'),356);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,8,4000400,str_to_date('aug/11','%b/%y'),342);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,9,4000400,str_to_date('sep/11','%b/%y'),143);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,10,4000400,str_to_date('oct/11','%b/%y'),299);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,11,4000400,str_to_date('nov/11','%b/%y'),369);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,12,4000400,str_to_date('dec/11','%b/%y'),174);

insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,13,4000402,str_to_date('jan/12','%b/%y'),174);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,14,4000402,str_to_date('feb/12','%b/%y'),192);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,15,4000402,str_to_date('mar/12','%b/%y'),335);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,16,4000402,str_to_date('apr/12','%b/%y'),347);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,17,4000402,str_to_date('may/12','%b/%y'),253);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,18,4000402,str_to_date('jun/12','%b/%y'),297);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,19,4000402,str_to_date('jul/12','%b/%y'),312);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,20,4000402,str_to_date('aug/12','%b/%y'),392);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,21,4000402,str_to_date('sep/12','%b/%y'),357);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,22,4000402,str_to_date('oct/12','%b/%y'),396);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,23,4000402,str_to_date('nov/12','%b/%y'),480);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,24,4000402,str_to_date('dec/12','%b/%y'),401);

insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,25,4000404,str_to_date('jan/13','%b/%y'),206);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,26,4000404,str_to_date('feb/13','%b/%y'),332);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,27,4000404,str_to_date('mar/13','%b/%y'),579);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,28,4000404,str_to_date('apr/13','%b/%y'),615);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,29,4000404,str_to_date('may/13','%b/%y'),778);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,30,4000404,str_to_date('jun/13','%b/%y'),265);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,31,4000404,str_to_date('jul/13','%b/%y'),517);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,32,4000404,str_to_date('aug/13','%b/%y'),668);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,33,4000404,str_to_date('sep/13','%b/%y'),578);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,34,4000404,str_to_date('oct/13','%b/%y'),439);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,35,4000404,str_to_date('nov/13','%b/%y'),551);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,36,4000404,str_to_date('dec/13','%b/%y'),416);

insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,37,4000406,str_to_date('jan/14','%b/%y'),441);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,38,4000406,str_to_date('feb/14','%b/%y'),419);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,39,4000406,str_to_date('mar/14','%b/%y'),372);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,40,4000406,str_to_date('apr/14','%b/%y'),543);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,41,4000406,str_to_date('may/14','%b/%y'),512);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,42,4000406,str_to_date('jun/14','%b/%y'),593);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,43,4000406,str_to_date('jul/14','%b/%y'),537);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,44,4000406,str_to_date('aug/14','%b/%y'),694);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,45,4000406,str_to_date('sep/14','%b/%y'),376);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,46,4000406,str_to_date('oct/14','%b/%y'),607);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,47,4000406,str_to_date('nov/14','%b/%y'),781);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,48,4000406,str_to_date('dec/14','%b/%y'),656);


insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,49,4000408,str_to_date('jan/15','%b/%y'),509);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,50,4000408,str_to_date('feb/15','%b/%y'),490);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,51,4000408,str_to_date('mar/15','%b/%y'),582);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,52,4000408,str_to_date('apr/15','%b/%y'),819);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,53,4000408,str_to_date('may/15','%b/%y'),826);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,54,4000408,str_to_date('jun/15','%b/%y'),644);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,55,4000408,str_to_date('jul/15','%b/%y'),699);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,56,4000408,str_to_date('aug/15','%b/%y'),796);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,57,4000408,str_to_date('sep/15','%b/%y'),1174);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,58,4000408,str_to_date('oct/15','%b/%y'),989);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,59,4000408,str_to_date('nov/15','%b/%y'),864);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,60,4000408,str_to_date('dec/15','%b/%y'),704);

insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,61,4000440,str_to_date('jan/16','%b/%y'),752);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,62,4000440,str_to_date('feb/16','%b/%y'),766);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,63,4000440,str_to_date('mar/16','%b/%y'),1035);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,64,4000440,str_to_date('apr/16','%b/%y'),834);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,65,4000440,str_to_date('may/16','%b/%y'),935);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,66,4000440,str_to_date('jun/16','%b/%y'),603);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,67,4000440,str_to_date('jul/16','%b/%y'),728);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,68,4000440,str_to_date('aug/16','%b/%y'),877);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,69,4000440,str_to_date('sep/16','%b/%y'),1069);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,70,4000440,str_to_date('oct/16','%b/%y'),456);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,71,4000440,str_to_date('nov/16','%b/%y'),584);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,72,4000440,str_to_date('dec/16','%b/%y'),636);

insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,73,4000442,str_to_date('jan/17','%b/%y'),971);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,74,4000442,str_to_date('feb/17','%b/%y'),459);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,75,4000442,str_to_date('mar/17','%b/%y'),429);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,76,4000442,str_to_date('apr/17','%b/%y'),972);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,77,4000442,str_to_date('may/17','%b/%y'),808);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,78,4000442,str_to_date('jun/17','%b/%y'),855);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,79,4000442,str_to_date('jul/17','%b/%y'),1012);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,80,4000442,str_to_date('aug/17','%b/%y'),820);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,81,4000442,str_to_date('sep/17','%b/%y'),811);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,82,4000442,str_to_date('oct/17','%b/%y'),981);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,83,4000442,str_to_date('nov/17','%b/%y'),1074);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,84,4000442,str_to_date('dec/17','%b/%y'),757);



insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,85,4000444,str_to_date('jan/18','%b/%y'),971);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,86,4000444,str_to_date('feb/18','%b/%y'),459);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,87,4000444,str_to_date('mar/18','%b/%y'),429);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,88,4000444,str_to_date('apr/18','%b/%y'),972);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,89,4000444,str_to_date('may/18','%b/%y'),808);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (2,90,4000444,str_to_date('jun/18','%b/%y'),855);





insert into PRODUTO (ID_FAMILIA_COMERCIAL,SKU,NOME_PRODUTO) values (2,4000546,'Roteador Y3');
insert into PRODUTO (ID_FAMILIA_COMERCIAL,SKU,NOME_PRODUTO) values (2,4000540,'Roteador Y2');
insert into PRODUTO (ID_FAMILIA_COMERCIAL,SKU,NOME_PRODUTO) values (2,4000538,'Roteador Y1');



insert into SKU_PHASE (SKU_PHASE_IN,SKU_PHASE_OUT) values (4000546,4000540);
insert into SKU_PHASE (SKU_PHASE_IN,SKU_PHASE_OUT) values (4000546,4000538);


insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,100,4000538,str_to_date('jan/15','%b/%y'),752);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,101,4000538,str_to_date('feb/15','%b/%y'),766);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,102,4000538,str_to_date('mar/15','%b/%y'),1035);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,103,4000538,str_to_date('apr/15','%b/%y'),834);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,104,4000538,str_to_date('may/15','%b/%y'),935);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,105,4000538,str_to_date('jun/15','%b/%y'),603);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,106,4000538,str_to_date('jul/15','%b/%y'),728);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,107,4000538,str_to_date('aug/15','%b/%y'),877);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,108,4000538,str_to_date('sep/15','%b/%y'),1069);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,109,4000538,str_to_date('oct/15','%b/%y'),456);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,110,4000538,str_to_date('nov/15','%b/%y'),584);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,111,4000538,str_to_date('dec/15','%b/%y'),636);

insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,112,4000540,str_to_date('jan/16','%b/%y'),971);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,113,4000540,str_to_date('feb/16','%b/%y'),459);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,114,4000540,str_to_date('mar/16','%b/%y'),429);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,115,4000540,str_to_date('apr/16','%b/%y'),972);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,116,4000540,str_to_date('may/16','%b/%y'),808);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,117,4000540,str_to_date('jun/16','%b/%y'),855);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,118,4000540,str_to_date('jul/16','%b/%y'),1012);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,119,4000540,str_to_date('aug/16','%b/%y'),820);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,120,4000540,str_to_date('sep/16','%b/%y'),811);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,121,4000540,str_to_date('oct/16','%b/%y'),981);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,122,4000540,str_to_date('nov/16','%b/%y'),1074);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,123,4000540,str_to_date('dec/16','%b/%y'),757);

insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,124,4000546,str_to_date('jan/17','%b/%y'),803);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,125,4000546,str_to_date('feb/17','%b/%y'),793);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,126,4000546,str_to_date('mar/17','%b/%y'),983);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,127,4000546,str_to_date('apr/17','%b/%y'),1338);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,128,4000546,str_to_date('may/17','%b/%y'),1173);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,129,4000546,str_to_date('jun/17','%b/%y'),796);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,130,4000546,str_to_date('jul/17','%b/%y'),1220);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,131,4000546,str_to_date('aug/17','%b/%y'),2061);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,132,4000546,str_to_date('sep/17','%b/%y'),1717);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,133,4000546,str_to_date('oct/17','%b/%y'),1558);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,134,4000546,str_to_date('nov/17','%b/%y'),1738);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,135,4000546,str_to_date('dec/17','%b/%y'),1720);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,136,4000546,str_to_date('jan/18','%b/%y'),1452);
insert into HISTORICO (ID_CANAL,ID_HISTORICO,SKU,MES_ANO,QUANTIDADE) values (3,137,4000546,str_to_date('feb/18','%b/%y'),1652);
