--liquibase formatted sql

CREATE TABLE employee (
    id uuid PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    surname VARCHAR(30) NOT NULL,
    patronymic VARCHAR(30),
    active boolean not null

);

insert into employee (id, name, surname, patronymic, active)
values ('9939af8e-0679-4f27-b905-425fc3113338', 'TestName', 'TestSurname', 'TestPatronymic', true);

create table post (
    id uuid primary key,
    employee_id uuid references employee(id) not null,
    name varchar(30) not null,
    main boolean not null,
    schedule varchar(15) not null
);

insert into post (id, employee_id, name, main, schedule)
values ('9939af8e-0679-4f27-b905-425fc31133ff', '9939af8e-0679-4f27-b905-425fc3113338', 'Бухгалтер', true, FIVE_TWO);

CREATE TABLE contractor
(
    id uuid NOT NULL PRIMARY KEY,
    name varchar(40) not null,
    type VARCHAR(20) NOT NULL
);

CREATE TABLE contact (
    id uuid not null primary key,
    contractor_id uuid not null references contractor (id),
    type varchar(20) not null,
    value varchar(40) not null,
    main boolean not null
);

insert into contractor (id, name, type)
values ('249a8909-932d-42fc-85be-9ae86633a358', 'TestContractor', 'PERSON');

insert into contact (id, contractor_id, type, value, main)
values ('fa0f2ac1-d053-47fd-a7d5-d96e4570aea7', '249a8909-932d-42fc-85be-9ae86633a358', 'EMAIL', 'doketov@mail.ru', true);
