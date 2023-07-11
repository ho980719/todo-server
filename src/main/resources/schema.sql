drop table if exists todo, member;

create table if not exists member (
    id bigserial not null,
    login_id varchar(100) not null,
    name varchar(100) not null,
    password varchar(100) not null,
    create_by bigint,
    created_date timestamp(6),
    modified_by bigint,
    modified_date timestamp(6),
    deleted boolean default false,
    deleted_by bigint,
    deleted_date timestamp(6),
    primary key (id)
);

create table if not exists todo (
    id bigserial not null,
    member_id bigint,
    title varchar(255),
    date varchar(8),
    completed boolean,
    create_by bigint,
    created_date timestamp(6),
    modified_by bigint,
    modified_date timestamp(6),
    deleted boolean default false,
    deleted_by bigint,
    deleted_date timestamp(6),
    primary key (id)
);

alter table if exists todo
add constraint FK67o67f2ave0yd2pb137aoh603
   foreign key (member_id)
   references member