--liquibase formatted sql

--changeset nvoxland:1
CREATE TABLE employee (
    id uuid PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    surname VARCHAR(30) NOT NULL,
    patronymic VARCHAR(30),
    active boolean not null,
    date_of_birth timestamp not null,
    phone varchar(30) not null,
    email varchar(50) not null,
    additional_info varchar(300)
);
--rollback drop table employee;

insert into employee (id, name, surname, patronymic, active, date_of_birth, phone, email)
values ('9939af8e-0679-4f27-b905-425fc3113338', 'Александр', 'Докетов', 'Сергеевич', true, '2002-03-10 00:00:00', '9203609918', 'doketov37@mail.ru');

insert into employee (id, name, surname, patronymic, active, date_of_birth, phone, email)
values ('9939af8e-0679-4f27-b905-425fc3113337', 'Стефан', 'Карри', null, true, '1990-08-30 00:00:00', '9051557528', 'curry@gmail.com');

--changeset nvoxland:2
create table post (
    id uuid primary key,
    employee_id uuid references employee(id) not null,
    name varchar(30) not null,
    main boolean not null,
    schedule varchar(15) not null,
    first_work_day timestamp not null
);
--rollback drop table post;

insert into post (id, employee_id, name, main, schedule, first_work_day)
values ('9939af8e-0679-4f27-b905-425fc31133ff', '9939af8e-0679-4f27-b905-425fc3113338', 'Бухгалтер', false, 'FIVE_TWO', '2024-05-13');

insert into post (id, employee_id, name, main, schedule, first_work_day)
values ('9939af8e-0679-4f27-b905-425fc31133f1', '9939af8e-0679-4f27-b905-425fc3113338', 'Директор', true, 'FIVE_TWO', '2024-05-13');

insert into post (id, employee_id, name, main, schedule, first_work_day)
values ('9939af8e-0679-4f27-b905-425fc31133f0', '9939af8e-0679-4f27-b905-425fc3113337', 'Механик', true, 'TWO_TWO', '2024-05-13');

--changeset nvoxland:3
CREATE TABLE contractor
(
    id uuid NOT NULL PRIMARY KEY,
    name varchar(40) not null,
    type VARCHAR(20) NOT NULL
);
--rollback drop table contractor;

--changeset nvoxland:4
CREATE TABLE contractor_contact (
    id uuid not null primary key,
    contractor_id uuid not null references contractor (id),
    type varchar(20) not null,
    value varchar(40) not null,
    main boolean not null
);
--rollback drop table contact;

insert into contractor (id, name, type)
values ('249a8909-932d-42fc-85be-9ae86633a358', 'TestContractor', 'PERSON');

insert into contractor_contact (id, contractor_id, type, value, main)
values ('fa0f2ac1-d053-47fd-a7d5-d96e4570aea7', '249a8909-932d-42fc-85be-9ae86633a358', 'EMAIL', 'doketov@mail.ru', true);

--changeset nvoxland:5
create table task (
    id uuid not null primary key,
    title varchar(30) not null,
    description varchar(300),
    executor_id uuid not null references employee (id),
    inspector_id uuid not null references employee (id),
    status varchar(10) not null,
    status_change_comment varchar(300),
    end_date timestamp not null
);
--rollback drop table task;

insert into task (id, title, description, executor_id, inspector_id, status, status_change_comment, end_date)
values ('fa0f2ac1-d053-47fd-a7d5-d96e4570ae88', 'Тестовая задача',
        null, '9939af8e-0679-4f27-b905-425fc3113338', '9939af8e-0679-4f27-b905-425fc3113337', 'IN_WORK', null, '2024-05-30');

--changeset nvoxland:6
create table task_link (
    id uuid not null primary key,
    short_name varchar(20) not null,
    description varchar(100),
    url varchar(300) not null,
    task_id uuid not null references task (id)
);
--rollback drop table task_link;

insert into task_link (id, short_name, description, url, task_id)
values ('9a0f2ac1-d053-47fd-a7d5-d96e4570ae88', 'Яндекс', 'Подробное описание ссылки и инструкции', 'https://ya.ru', 'fa0f2ac1-d053-47fd-a7d5-d96e4570ae88');