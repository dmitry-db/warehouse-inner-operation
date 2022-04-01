CREATE SEQUENCE nomenclatures_seq;
create table nomenclature (
    id BIGINT PRIMARY KEY NOT NULL default nextval('nomenclatures_seq'),
    product_type varchar(255) NOT NULL,
    product_name varchar(255) NOT NULL,
    unique (product_type, product_name)
);

CREATE SEQUENCE products_seq;
create table products (
    id BIGINT PRIMARY KEY NOT NULL default nextval('products_seq'),
    nomenclature_id BIGINT unique,
    price decimal(10,2) not null ,
    count BIGINT default 0 not null,
    CHECK ( price >= 0 AND count >= 0 ),
    FOREIGN KEY (nomenclature_id) REFERENCES nomenclature(id)
);

create sequence user_seq;
create table users (
    id BIGINT PRIMARY KEY NOT NULL default nextval('user_seq'),
    login varchar(255) not null unique,
    password varchar(255) not null unique,
    enabled boolean not null default true
);

create sequence roles_seq;
create table roles (
    id BIGINT PRIMARY KEY NOT NULL default nextval('roles_seq'),
    name varchar(255) not null
);

create table user_roles (
    user_id BIGINT not null,
    roles_id BIGINT NOT NULL,
    PRIMARY KEY (user_id, roles_id),
    foreign key (user_id) references users(id),
    foreign key (roles_id) references roles(id)
);

CREATE SEQUENCE log_sequence;
create table log (
    id BIGINT PRIMARY KEY NOT NULL default nextval('log_sequence'),
    type varchar(255) not null,
    date_time date not null,
    name_method varchar(255) not null,
    full_name_class varchar(255) not null
);

CREATE SEQUENCE profit_seq;
create table profit_on_day (
    id BIGINT PRIMARY KEY NOT NULL default nextval('profit_seq'),
    day date not null,
    profit BIGINT NOT NULL
);