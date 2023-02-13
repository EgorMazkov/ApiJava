drop schema if exists project cascade;

create schema if not exists project;

create table if not exists project.projects
(
    id           serial primary key,
    name_project varchar
);

create table if not exists project.geometry
(
    id serial primary key,
    id_project   BIGINT,
    name_Geomerty varchar(10) not null,
    foreign key (id_project) references project.projects(id)

);

create table if not exists project.attribute
(
    id serial primary key,
    id_project   BIGINT,
    name_Attribute varchar(10) not null,

    foreign key (id_project) references project.projects(id)
);