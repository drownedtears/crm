--liquibase formatted sql

--changeset nvoxland:1
CREATE TABLE employee (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(30) NOT NULL,
                       surname VARCHAR(30) NOT NULL,
                       patronymic VARCHAR(30)
);
--rollback drop table employee;

insert into employee (id, name, surname, patronymic)
values ('9939af8e-0679-4f27-b905-425fc3113338', 'TestName', 'TestSurname', 'TestPatronymic');

--changeset nvoxland:2
CREATE TABLE roles
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL
);
--rollback drop table roles;

--changeset nvoxland:3
CREATE TABLE user_roles (
                            user_id INTEGER REFERENCES users(id) ON DELETE CASCADE,
                            role_id INTEGER REFERENCES roles(id) ON DELETE CASCADE,
                            PRIMARY KEY (user_id, role_id)
);
--rollback drop table user_roles;

--changeset nvoxland:4
CREATE TABLE articles
(
    id SERIAL PRIMARY KEY,
    header VARCHAR(50) NOT NULL,
    content VARCHAR(255),
    rating INT NOT NULL,
    cre_date VARCHAR(20) NOT NULL,
    author_id INT NOT NULL,
    FOREIGN KEY (author_id) REFERENCES users(id)

);
--rollback drop table articles;