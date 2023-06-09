create table order_ticket
(
    id          bigint auto_increment
        primary key,
    expire_date date   null,
    is_status   bit    null,
    total_price double null
);

create table role
(
    id     bigint auto_increment
        primary key,
    name   varchar(255) not null,
    `desc` varchar(255) not null
);

create table user
(
    id             bigint auto_increment
        primary key,
    full_name      varchar(255) not null,
    username       varchar(255) not null,
    password       varchar(255) not null,
    email          varchar(255) not null,
    address        varchar(255) null,
    phone          varchar(255) null,
    avatar         varchar(255) null,
    is_status      bit          not null,
    remember_token varchar(255) null,
    check ((`is_status` = 0) or (`is_status` = 1))
);

create table passenger
(
    id         bigint auto_increment
        primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    oder_id    bigint       null,
    user_id    bigint       null,
    constraint FKmk0iuq3k712q80qqjehqdndoa
        foreign key (user_id) references user (id),
    constraint FKqoeg34hex9fabc3su17b20336
        foreign key (oder_id) references order_ticket (id)
);

create table luggage
(
    id           bigint auto_increment
        primary key,
    kilogam      bigint not null,
    price        double not null,
    order_id     bigint null,
    passenger_id bigint null,
    constraint FK9cy6pmixgdxluao8vc6x6idnj
        foreign key (passenger_id) references passenger (id),
    constraint FKsf9d5wbkerdt8iu67g3vdogjt
        foreign key (order_id) references order_ticket (id)
);

create table ticket
(
    id             bigint auto_increment
        primary key,
    ticket_number  varchar(255) not null,
    flight_number  varchar(255) not null,
    departure      varchar(255) not null,
    destination    varchar(255) not null,
    departure_date date         not null,
    departure_time varchar(255) not null,
    ticket_class   varchar(255) not null,
    seat_number    varchar(255) not null,
    ticket_price   bigint       not null,
    ticket_status  tinyint(1)   not null,
    booking_date   date         not null,
    user_id        bigint       null,
    order_id       bigint       null,
    constraint FK5ni0ffk6ohhlk5wqmidoh065f
        foreign key (order_id) references order_ticket (id),
    constraint fk_user_id
        foreign key (user_id) references user (id)
);

create table user_role
(
    id      bigint auto_increment
        primary key,
    user_id bigint not null,
    role_id bigint not null,
    constraint FK859n2jvi8ivhui0rl0esws6o
        foreign key (user_id) references user (id),
    constraint fk_user_role_role
        foreign key (role_id) references role (id)
);

INSERT INTO `user` (full_name, username, `password`, email, is_status)
values
    ('Thành','vip','$2a$12$gk/atUhj2BZWJFmZVJwlCONujBaGj60i0GCeo5DmwMv/FhlVwEicO','thanh@codegym.com',1),
    ('Phú','phu','$2a$12$gk/atUhj2BZWJFmZVJwlCONujBaGj60i0GCeo5DmwMv/FhlVwEicO','phu@codegym.com',1);
INSERT INTO `role`(`name`,`desc`) values
                                      ('ROLE_ADMIN','Quản trị viên'),
                                      ('ROLE_CUSTOMER','Khách hàng');
INSERT INTO `airline_test`.`ticket` (`ticket_number`, `flight_number`, `departure`, `destination`, `departure_date`, `departure_time`, `ticket_class`, `seat_number`, `ticket_price`, `ticket_status`, `booking_date`,`user_id`)
VALUES ('123', 'abc', 'HN', 'HCM', '2023-06-07', '1h', 'thương gia', 'zxc', '56', '0', '2023-06-07',null);
INSERT INTO `airline_test`.`ticket` (`ticket_number`, `flight_number`, `departure`, `destination`, `departure_date`, `departure_time`, `ticket_class`, `seat_number`, `ticket_price`, `ticket_status`, `booking_date`,`user_id`)
VALUES ('123', 'abc', 'HN', 'HCM', '2023-06-07', '1h', 'thương gia', 'zxc', '30', '0', '2023-06-07',null);
INSERT INTO `airline_test`.`ticket` (`ticket_number`, `flight_number`, `departure`, `destination`, `departure_date`, `departure_time`, `ticket_class`, `seat_number`, `ticket_price`, `ticket_status`, `booking_date`,`user_id`)
VALUES ('123', 'abc', 'HN', 'HCM', '2023-06-07', '1h', 'thương gia', 'zxc', '20', '0', '2023-06-07',null);