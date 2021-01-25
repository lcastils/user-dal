DROP TABLE IF EXISTS fare_class_benefits;
CREATE TABLE fare_class_benefits (
  id                      bigint(20) NOT NULL AUTO_INCREMENT comment 'identificador', 
  fare_class_id           bigint(20) NOT NULL comment 'identificador de la clase tarifaria', 
  benefits_agmt_detail_id bigint(20) NOT NULL comment 'identificador del detalle beneficio', 
  discount                double comment 'valor del descuento asociado', 
  PRIMARY KEY (id));
  

DROP TABLE IF EXISTS benefits_maintainer;
CREATE TABLE benefits_maintainer (
  benefits_maintainer_id   bigint(20) NOT NULL AUTO_INCREMENT comment 'identificador unico mantenedor beneficios', 
  benefits_type_id         bigint(20) comment 'identificador tipo de beneficio', 
  benf_route_ori           varchar(10) comment 'ruta origen', 
  benf_route_dest          varchar(10) comment 'ruta destino', 
  benefits_maintainer_orig varchar(3) comment 'origen descuento', 
  benefits_maintainer_dest varchar(3) comment 'destino descuento', 
  insert_date              timestamp NULL comment 'fecha insercion descuento', 
  update_date              timestamp NULL comment 'fecha modificacion descuento', 
  user_create_id           varchar(10) comment 'identificador usuario creacion', 
  user_update_id           varchar(10) comment 'identificador usuario actualizacion', 
  identifier               varchar(60) comment 'identificador combo', 
  PRIMARY KEY (benefits_maintainer_id));

DROP TABLE IF EXISTS  benefits_agreement_detail;
CREATE TABLE benefits_agreement_detail (
  benefits_agmt_detail_id bigint(20) NOT NULL AUTO_INCREMENT comment 'identificador detalle beneficio acuerdo comercial', 
  benefits_id             bigint(20) comment 'identificador de beneficio', 
  benefits_type_id        bigint(20) NOT NULL comment 'identificador tipo de descuento', 
  benf_route_ori          varchar(10) comment 'ruta origen', 
  benf_route_dest         varchar(10) comment 'ruta destino', 
  benefits_detail_orig    varchar(3) comment 'origen descuento', 
  benefits_detail_dest    varchar(3) comment 'destino descuento', 
  insert_date             timestamp NULL comment 'fecha insercion descuento', 
  update_date             timestamp NULL comment 'fecha actualizacion descuento', 
  user_create_id          varchar(10) comment 'identicador usuario creacion', 
  user_update_id          varchar(10) comment 'identificador usuario actualizacion', 
  identifier              varchar(60) comment 'identificador combo', 
  PRIMARY KEY (benefits_agmt_detail_id));
  
DROP TABLE IF EXISTS benefits;
CREATE TABLE benefits (
  benefits_id        bigint(20) NOT NULL AUTO_INCREMENT comment 'id unico beneficios', 
  name               varchar(100) comment 'nombre beneficio', 
  sub_agmt_id        bigint(20) comment 'identificador unico version acuerdo comercial', 
  tactical_action_id bigint(20) comment 'identificador unico accion tactica', 
  PRIMARY KEY (benefits_id));
  
 DROP TABLE IF EXISTS benefits_type;
  CREATE TABLE benefits_type (
  benefits_type_id bigint(20) NOT NULL AUTO_INCREMENT comment 'identificador tipo beneficio', 
  name             varchar(15) comment 'nombre tipo de beneficio', 
  PRIMARY KEY (benefits_type_id));

DROP TABLE IF EXISTS sub_agreement;
CREATE TABLE sub_agreement (
  sub_agmt_id      bigint(20) NOT NULL AUTO_INCREMENT comment 'id unico version acuerdo comercial', 
  agmt_id          bigint(20) comment 'id acuerdo comercial', 
  pos_id           bigint(20) NOT NULL comment 'identificador relacionado al pos del acuerdo', 
  seg_id           bigint(20) NOT NULL comment 'id segmentación', 
  start_date       timestamp NULL comment 'fecha inicio contrato', 
  end_date         timestamp NULL comment 'fecha termino contrato', 
  tourcode         varchar(8) comment 'identificador unico de acuerdo comercial', 
  user_bp          varchar(10) comment 'id usuario realiza contrato', 
  corporate_id     varchar(40) NOT NULL comment 'id empresa', 
  account_code     varchar(10) comment 'nombre identificador para realizar efectivo el descuento', 
  taxid            varchar(32) comment 'registro unico tributario', 
  rule_number      varchar(4) comment 'regla activa atpco', 
  ariba_code       varchar(10) comment 'codigo acuerdo comercial sistema legal', 
  sub_agmt_version bigint(20) comment 'id version acuerdo comercial', 
  PRIMARY KEY (sub_agmt_id));
  
DROP TABLE IF EXISTS corporate;  
  CREATE TABLE corporate (
  corporate_id varchar(40) NOT NULL comment 'identificador unico empresa', 
  legalname    varchar(100) comment 'nombre legal empresa', 
  tradename    varchar(50) comment 'nombre fantasia empresa', 
  PRIMARY KEY (corporate_id));
  
DROP TABLE IF EXISTS segmentation; 
 CREATE TABLE segmentation (
  seg_id bigint(20) NOT NULL AUTO_INCREMENT comment 'identificador unico segmetacion', 
  name   varchar(15) comment 'nombre segmentacion', 
  PRIMARY KEY (seg_id));
 
CREATE TABLE agency (
  agency_id          varchar(40) NOT NULL comment 'identificador unico agencia', 
  sub_agmt_id        bigint(20) NOT NULL comment 'identificador unico version acuerdo comercial', 
  legalname          varchar(100) comment 'nombre legal de agencia', 
  tradename          varchar(50) comment 'nombre fantasia agencia', 
  account_code       varchar(10) comment 'nombre identificador para realizar efectivo el descuento', 
  tactical_action_id bigint(20) comment 'identificador accion tactica', 
  PRIMARY KEY (agency_id, 
  sub_agmt_id));
  
DROP TABLE IF EXISTS agreement;
CREATE TABLE agreement (
  agmt_id        BIGINT NOT NULL AUTO_INCREMENT comment 'id unico acuerdo comercial', 
  pos_lider_id   bigint(20) NOT NULL comment 'pos lider acuerdo comercial', 
  agmt_type_id   bigint(20) NOT NULL comment 'id tipo de acuerdo comercial', 
  agmt_status_id bigint(20) NOT NULL comment 'id estado de acuerdo comercial', 
  neg_id         bigint(20) comment 'id negociacion asociada a un acuerdo comercial', 
  PRIMARY KEY (agmt_id));

CREATE TABLE agreement_log (
  agmt_log_id    bigint(20) NOT NULL AUTO_INCREMENT comment 'identificador unico registro log', 
  agmt_id        bigint(20) comment 'identificador unico de acuerdo comercial', 
  agmt_status_id bigint(20) comment 'identificador unico estado acuerdo comercial', 
  user_bp        varchar(10) comment 'identificador unico usuario', 
  execution_date timestamp NULL comment 'fecha de ejecucion cambio en acuerdo comercial', 
  PRIMARY KEY (agmt_log_id));

DROP TABLE IF EXISTS agreement_status;
CREATE TABLE agreement_status (
  agmt_status_id bigint(20) NOT NULL AUTO_INCREMENT comment 'identificador estado acuerdo comercial', 
  name           varchar(25) comment 'nombre estado acuerdo comercial', 
  PRIMARY KEY (agmt_status_id));

DROP TABLE IF EXISTS agreement_type;
CREATE TABLE agreement_type (
  agmt_type_id bigint(20) NOT NULL AUTO_INCREMENT comment 'identificaro tipo de acuerdo comercial', 
  name         varchar(20) comment 'nombre tipo de acuerdo comercial', 
  PRIMARY KEY (agmt_type_id));
  



DROP TABLE IF EXISTS fare_class;
CREATE TABLE fare_class (
  fare_class_id bigint(20) NOT NULL AUTO_INCREMENT comment 'identificador de la clase tarifaria', 
  name          varchar(1) comment 'nombre de la clase tarifaria', 
  PRIMARY KEY (fare_class_id));


CREATE TABLE benefits_max_maintainer (
  benefits_max_maintainer_id bigint(20) NOT NULL AUTO_INCREMENT comment 'identificador nantenedor beneficio', 
  benefits_type_id           bigint(20) comment 'identificador del tipo de beneficio asociado', 
  benf_route_ori             varchar(10) comment 'ruta origen', 
  benf_route_dest            varchar(10) comment 'ruta destino', 
  benefits_max_orig          varchar(3) comment 'origen del beneficio', 
  benefits_max_dest          varchar(3) comment 'destino del beneficio', 
  insert_date                timestamp NULL comment 'fecha de insercion', 
  user_create_id             varchar(10) comment 'usuario creacion', 
  user_update_id             varchar(10) comment 'usuario actualizacion', 
  PRIMARY KEY (benefits_max_maintainer_id));







CREATE TABLE fare_class_benefits_maintainer (
  fare_class_id          bigint(20) NOT NULL comment 'identificador clase tarifaria', 
  benefits_maintainer_id bigint(20) NOT NULL comment 'identificador mantenedor descuento', 
  discount               double NOT NULL comment 'descuento asignado', 
  PRIMARY KEY (fare_class_id, 
  benefits_maintainer_id));

CREATE TABLE fare_class_benefits_max_maintainer (
  fare_class_id              bigint(20) NOT NULL comment 'identificador clase tarifaria', 
  benefits_max_maintainer_id bigint(20) NOT NULL comment 'identificador beneficio maximo', 
  discount                   double NOT NULL comment 'descuento asignado', 
  PRIMARY KEY (fare_class_id, 
  benefits_max_maintainer_id));

DROP TABLE IF EXISTS pos;
CREATE TABLE pos (
  pos_id bigint(20) NOT NULL AUTO_INCREMENT comment 'identificador del pos', 
  name   varchar(3) comment 'nombre del pos', 
  PRIMARY KEY (pos_id));

CREATE TABLE Routes (
  id_route bigint(20) NOT NULL AUTO_INCREMENT comment 'identificador ruta', 
  name     varchar(10) comment 'nombre tipo ruta', 
  PRIMARY KEY (id_route));

CREATE TABLE sales_channel (
  sales_channel_id bigint(20) NOT NULL AUTO_INCREMENT comment 'identificador canal de venta', 
  type             varchar(10) comment 'tipo canal de venta', 
  value            varchar(10) comment 'valor canal de venta', 
  agency_id        varchar(40) comment 'identificador canal de venta', 
  PRIMARY KEY (sales_channel_id));





CREATE TABLE tactical_action (
  tactical_action_id bigint(20) NOT NULL AUTO_INCREMENT comment 'id unico accion tactica', 
  rule_number        varchar(4) comment 'regla activa atpco', 
  agmt_id            bigint(20) comment 'id unico acuerdo comercial', 
  tourcode           varchar(8) comment 'identificador unico de acuerdo comercial', 
  pos_id             bigint(20) comment 'identificador del pos asociado', 
  agmt_status_id     bigint(20) comment 'identificador del estado asociado', 
  account_code       varchar(10) comment 'nombre identificador para realizar efectivo el descuento', 
  corporate_id       bigint(20) comment 'identificador unico de empresa', 
  start_date         timestamp NULL comment 'fecha inicio accion tactica', 
  end_date           timestamp NULL comment 'fecha termino accion tactica', 
  user_bp            varchar(10) comment 'usuario asociado a accion tactica', 
  PRIMARY KEY (tactical_action_id));

CREATE TABLE `user` (
  user_bp   varchar(10) NOT NULL comment 'bp usuario latam', 
  user_name varchar(30) comment 'nombre de usuario', 
  last_name varchar(30) comment 'apellido usuario', 
  rol       varchar(20) comment 'rol usuario latam', 
  email     varchar(120) comment 'email usuario latam', 
  PRIMARY KEY (user_bp));

ALTER TABLE benefits_agreement_detail ADD CONSTRAINT FKbenefits_a90137 FOREIGN KEY (benefits_id) REFERENCES benefits (benefits_id);

ALTER TABLE sales_channel ADD CONSTRAINT FKsales_chan560645 FOREIGN KEY (agency_id) REFERENCES agency (agency_id);

ALTER TABLE fare_class_benefits_maintainer ADD CONSTRAINT FKfare_class401545 FOREIGN KEY (benefits_maintainer_id) REFERENCES benefits_maintainer (benefits_maintainer_id);

ALTER TABLE sub_agreement ADD CONSTRAINT FKsub_agreem668486 FOREIGN KEY (seg_id) REFERENCES segmentation (seg_id);

ALTER TABLE sub_agreement ADD CONSTRAINT FKsub_agreem802562 FOREIGN KEY (user_bp) REFERENCES `user` (user_bp);

ALTER TABLE benefits ADD CONSTRAINT FKbenefits890428 FOREIGN KEY (tactical_action_id) REFERENCES tactical_action (tactical_action_id);

ALTER TABLE agency ADD CONSTRAINT FKagency254635 FOREIGN KEY (tactical_action_id) REFERENCES tactical_action (tactical_action_id);

ALTER TABLE benefits ADD CONSTRAINT FKbenefits747563 FOREIGN KEY (sub_agmt_id) REFERENCES sub_agreement (sub_agmt_id);

ALTER TABLE agency ADD CONSTRAINT FKagency111770 FOREIGN KEY (sub_agmt_id) REFERENCES sub_agreement (sub_agmt_id);

ALTER TABLE agreement_log ADD CONSTRAINT FKagreement_509003 FOREIGN KEY (agmt_id) REFERENCES agreement (agmt_id);

ALTER TABLE sub_agreement ADD CONSTRAINT FKsub_agreem376335 FOREIGN KEY (agmt_id) REFERENCES agreement (agmt_id);

ALTER TABLE agreement ADD CONSTRAINT FKagreement319114 FOREIGN KEY (agmt_status_id) REFERENCES agreement_status (agmt_status_id);

ALTER TABLE benefits_agreement_detail ADD CONSTRAINT FKbenefits_a646908 FOREIGN KEY (benefits_type_id) REFERENCES benefits_type (benefits_type_id);

ALTER TABLE agreement ADD CONSTRAINT FKagreement993764 FOREIGN KEY (agmt_type_id) REFERENCES agreement_type (agmt_type_id);

ALTER TABLE fare_class_benefits ADD CONSTRAINT FKfare_class691625 FOREIGN KEY (benefits_agmt_detail_id) REFERENCES benefits_agreement_detail (benefits_agmt_detail_id);

ALTER TABLE sub_agreement ADD CONSTRAINT FKsub_agreem45059 FOREIGN KEY (corporate_id) REFERENCES corporate (corporate_id);

ALTER TABLE sub_agreement ADD CONSTRAINT FKsub_agreem637129 FOREIGN KEY (pos_id) REFERENCES pos (pos_id);

ALTER TABLE agreement ADD CONSTRAINT FKagreement772340 FOREIGN KEY (pos_lider_id) REFERENCES pos (pos_id);

ALTER TABLE fare_class_benefits ADD CONSTRAINT FKfare_class524159 FOREIGN KEY (fare_class_id) REFERENCES fare_class (fare_class_id);

ALTER TABLE fare_class_benefits_maintainer ADD CONSTRAINT FKfare_class371173 FOREIGN KEY (fare_class_id) REFERENCES fare_class (fare_class_id);

ALTER TABLE fare_class_benefits_max_maintainer ADD CONSTRAINT FKfare_class456393 FOREIGN KEY (fare_class_id) REFERENCES fare_class (fare_class_id);

ALTER TABLE fare_class_benefits_max_maintainer ADD CONSTRAINT FKfare_class508586 FOREIGN KEY (benefits_max_maintainer_id) REFERENCES benefits_max_maintainer (benefits_max_maintainer_id);

insert into pos (name) values ('CL');
insert into pos (name) values ('BR');
insert into pos (name) values ('PE');

insert into corporate (corporate_id,legalname,tradename) values ('123','TREBOL','TREBOL SA') ; 
insert into agreement_status (name) values ('aprobado');
insert into agreement_status (name) values ('rechazado');

insert into agreement_type (name) values ('local');
insert into agreement_type (name) values ('global');
insert into segmentation (name) values ('elite');
 
insert into agreement (pos_lider_id,agmt_type_id,agmt_status_id,neg_id) values (1,1,1,null);
 
  
insert into sub_agreement (agmt_id,pos_id,seg_id,corporate_id) values (1,1,1,'123');
insert into benefits_type (name) values ('S');
insert into benefits_type (name) values ('P');
insert into fare_class (name) values ('J');
