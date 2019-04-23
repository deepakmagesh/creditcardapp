drop table credit_card if exists;
drop table role if exists;
drop table user if exists;
drop table user_role if exists;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;
create table credit_card (cardnumber varchar(255) not null, name varchar(255), expiry varchar(255),
username varchar(255), primary key (cardnumber));
create table role (role_id varchar(255) not null, role varchar(255), primary key (role_id));
create table user (user_id integer not null, password varchar(255), username varchar(255), primary key (user_id));
create table user_role (user_id integer not null, role_id varchar(255) not null, primary key (user_id, role_id));