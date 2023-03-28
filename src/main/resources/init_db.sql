create database if not exists `math_teacher_app_db`;
create table if not exists equations
(
    id             bigint auto_increment
        primary key,
    equation_value varchar(255) null
);

create table if not exists roots
(
    id          bigint auto_increment
        primary key,
    equation_id bigint null,
    root_value  bigint null,
    constraint FKcbcqhnui5iusd8xgaf4755eai
        foreign key (equation_id) references equations (id)
);
