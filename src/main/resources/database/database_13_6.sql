create database airline_test;
use airline_test;
create table role
(
    id     int auto_increment
        primary key,
    `desc` varchar(100) not null,
    name   varchar(50)  not null
);

create table user
(
    id             bigint auto_increment
        primary key,
    address        varchar(255) null,
    avatar         text         null,
    email          varchar(255) not null,
    full_name      varchar(255) not null,
    is_status      bit          not null,
    password       varchar(255) null,
    phone          varchar(12)  null,
    remember_token varchar(255) null,
    username       varchar(20)  not null
);

create table order_ticket
(
    id          bigint auto_increment
        primary key,
    expire_date date   null,
    is_status   bit    null,
    total_price double null,
    user_id     bigint null,
    constraint FK6c9f39b86t3unij3eyhxvv2my
        foreign key (user_id) references user (id)
);

create table passenger
(
    id         bigint auto_increment
        primary key,
    first_name varchar(255) not null,
    is_luggage bit          null,
    last_name  varchar(255) not null,
    oder_id    bigint       null,
    user_id    bigint       null,
    constraint FKmk0iuq3k712q80qqjehqdndoa
        foreign key (user_id) references user (id),
    constraint FKqoeg34hex9fabc3su17b20336
        foreign key (oder_id) references order_ticket (id)
);

create table ticket
(
    id             bigint auto_increment
        primary key,
    booking_date   date         not null,
    departure      varchar(255) not null,
    departure_date date         not null,
    departure_time varchar(255) not null,
    destination    varchar(255) not null,
    flight_number  varchar(255) not null,
    seat_number    varchar(255) not null,
    ticket_class   varchar(255) not null,
    ticket_number  varchar(255) not null,
    ticket_price   bigint       not null,
    ticket_status  bit          not null,
    order_id       bigint       null,
    user_id        bigint       null,
    constraint FK5ni0ffk6ohhlk5wqmidoh065f
        foreign key (order_id) references order_ticket (id),
    constraint FKdvt57mcco3ogsosi97odw563o
        foreign key (user_id) references user (id)
);

create table user_role
(
    id      bigint auto_increment
        primary key,
    role_id int    null,
    user_id bigint null,
    constraint FK859n2jvi8ivhui0rl0esws6o
        foreign key (user_id) references user (id),
    constraint FKa68196081fvovjhkek5m97n3y
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
VALUES ('1', '1', 'HN', 'HCM', '2023-06-07', '1h', 'thương gia', 'zxc', '56', false, '2023-06-07',null);
INSERT INTO `airline_test`.`ticket` (`ticket_number`, `flight_number`, `departure`, `destination`, `departure_date`, `departure_time`, `ticket_class`, `seat_number`, `ticket_price`, `ticket_status`, `booking_date`,`user_id`)
VALUES ('2', '2', 'HN', 'HCM', '2023-06-07', '1h', 'thương gia', 'zxc', '30', false, '2023-06-07',null);
INSERT INTO `airline_test`.`ticket` (`ticket_number`, `flight_number`, `departure`, `destination`, `departure_date`, `departure_time`, `ticket_class`, `seat_number`, `ticket_price`, `ticket_status`, `booking_date`,`user_id`)
VALUES ('3', '3', 'HN', 'HCM', '2023-06-07', '1h', 'thương gia', 'zxc', '20', false, '2023-06-07',null);
INSERT INTO `airline_test`.`user_role` (`role_id`, `user_id`) VALUES ('1', '1');
INSERT INTO `airline_test`.`user_role` (`role_id`, `user_id`) VALUES ('2', '2');