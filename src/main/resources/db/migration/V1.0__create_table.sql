create table user
(
    id      bigint       not null primary key,
    country varchar(255) null,
    name    varchar(255) null
);

create table user_progress
(
    id      bigint not null primary key,
    level   int    not null,
    score   float  not null,
    user_id bigint null,
    constraint user$FkConstraint foreign key (user_id) references user (id)
);