drop table member;

create table if not exists member (
    id bigserial not null,
    login_id varchar(100) not null,
    name varchar(100) not null,
    password varchar(100) not null,
    create_by bigint,
    created_date timestamp(6),
    modified_by bigint,
    modified_date timestamp(6),
    deleted_by bigint,
    deleted_date timestamp(6),
    primary key (id)
);