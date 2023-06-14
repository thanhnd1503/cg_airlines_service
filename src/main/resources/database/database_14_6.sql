create table flight
(
    id             bigint auto_increment
        primary key,
    departure      varchar(255) not null,
    departure_date date         not null,
    departure_time varchar(255) not null,
    destination    varchar(255) not null
);

create table role
(
    id     int auto_increment
        primary key,
    `desc` varchar(100) not null,
    name   varchar(50)  not null
);

create table seat
(
    id          bigint auto_increment
        primary key,
    quantity    int          not null,
    seat_class  varchar(255) not null,
    seat_number varchar(255) not null,
    seat_status bit          not null,
    flight_id   bigint       null,
    constraint FKeda0njvaxhowgf6120eh6hxpq
        foreign key (flight_id) references flight (id)
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
    id            bigint auto_increment
        primary key,
    booking_date  date         not null,
    ticket_number varchar(255) not null,
    ticket_price  bigint       not null,
    ticket_status bit          not null,
    flight_id     bigint       null,
    order_id      bigint       null,
    user_id       bigint       null,
    constraint FK5ni0ffk6ohhlk5wqmidoh065f
        foreign key (order_id) references order_ticket (id),
    constraint FKdvt57mcco3ogsosi97odw563o
        foreign key (user_id) references user (id),
    constraint FKfju27cbcbl1w16qeora1r636q
        foreign key (flight_id) references flight (id)
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
INSERT INTO `airline_test`.`user_role` (`role_id`, `user_id`) VALUES ('1', '1');
INSERT INTO `airline_test`.`user_role` (`role_id`, `user_id`) VALUES ('2', '2');
INSERT INTO `user` (full_name, username, `password`, email, is_status)
values
    ('Thành','vip','$2a$12$gk/atUhj2BZWJFmZVJwlCONujBaGj60i0GCeo5DmwMv/FhlVwEicO','thanh@codegym.com',1),
    ('Phú','phu','$2a$12$gk/atUhj2BZWJFmZVJwlCONujBaGj60i0GCeo5DmwMv/FhlVwEicO','phu@codegym.com',1);
INSERT INTO `role`(`name`,`desc`) values
                                      ('ROLE_ADMIN','Quản trị viên'),
                                      ('ROLE_CUSTOMER','Khách hàng');
INSERT INTO flight (departure, departure_date, departure_time, destination)
VALUES
    ('Hà Nội', '2023-06-14', '08:00', 'Hồ Chí Minh'),
    ('Hà Nội', '2023-06-15', '09:30', 'Hồ Chí Minh'),
    ('Hà Nội', '2023-06-16', '10:45', 'Hồ Chí Minh'),
    ('Hà Nội', '2023-06-17', '11:15', 'Hồ Chí Minh'),
    ('Bình Định', '2023-06-18', '12:30', 'Hồ Chí Minh'),
    ('Bình Định', '2023-06-19', '13:45', 'Hồ Chí Minh'),
    ('Bình Định', '2023-06-20', '14:00', 'Hồ Chí Minh'),
    ('Hồ Chí Minh', '2023-06-21', '15:15', 'Hà Nội'),
    ('Hồ Chí Minh', '2023-06-22', '16:30', 'Hà Nội'),
    ('Hồ Chí Minh', '2023-06-23', '17:45', 'Hà Nội'),
    ('Hà Nội', '2023-06-24', '18:00', 'Bình Định'),
    ('Hà Nội', '2023-06-25', '19:15', 'Bình Định'),
    ('Hà Nội', '2023-06-26', '20:30', 'Bình Định'),
    ('Cần Đước', '2023-06-27', '21:45', 'Bình Định'),
    ('Cần Đước', '2023-06-28', '22:00', 'Bình Định'),
    ('Cần Đước', '2023-06-29', '23:15', 'Bình Định'),
    ('An Giang', '2023-06-30', '00:30', 'Hồ Chí Minh'),
    ('An Giang', '2023-07-01', '01:45', 'Hồ Chí Minh'),
    ('An Giang', '2023-07-02', '02:00', 'Hồ Chí Minh'),
    ('An Giang', '2023-07-03', '03:15', 'Hồ Chí Minh');