-- auto-generated definition
create schema airline_test collate utf8mb4_0900_ai_ci;
drop database airline_test;
create database airline_test;
use airline_test;
create table `user`(
                       `id` bigint not null auto_increment,
                       `full_name` varchar(255) not null,
                       `username` varchar(255) not null,
                       `password` varchar(255) not null,
                       `email` varchar(255) not null,
                       `address` varchar(255),
                       `phone` varchar(255),
                       `avatar` varchar(255),
                       `is_status` bit not null check(`is_status` = 0 or `is_status` = 1),
                       `remember_token` varchar(255),
                       PRIMARY KEY (`id`)
);
create table `role`(
                       `id` bigint not null auto_increment,
                       `name` varchar(255) not null,
                       `desc` varchar(255) not null,
                       PRIMARY KEY (`id`)
);
create table `user_role`(
                            `id` bigint primary key auto_increment,
                            `user_id` bigint not null,
                            `role_id` bigint not null
);

ALTER TABLE user_role ADD CONSTRAINT fk_user_role_customer FOREIGN KEY(`user_id`) REFERENCES `user`(`id`);
ALTER TABLE user_role ADD CONSTRAINT fk_user_role_role FOREIGN KEY(`role_id`) REFERENCES role(`id`);
INSERT INTO `user` (full_name, username, `password`, email, is_status)
values
    ('Thành','vip','$2a$12$gk/atUhj2BZWJFmZVJwlCONujBaGj60i0GCeo5DmwMv/FhlVwEicO','thanh@codegym.com',1),
    ('Phú','phu','$2a$12$gk/atUhj2BZWJFmZVJwlCONujBaGj60i0GCeo5DmwMv/FhlVwEicO','phu@codegym.com',1);
INSERT INTO `role`(`name`,`desc`) values
                                      ('ROLE_ADMIN','Quản trị viên'),
                                      ('ROLE_CUSTOMER','Khách hàng');
CREATE TABLE ticket (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        ticket_number VARCHAR(255) NOT NULL,
                        flight_number VARCHAR(255) NOT NULL,
                        departure VARCHAR(255) NOT NULL,
                        destination VARCHAR(255) NOT NULL,
                        departure_date DATE NOT NULL,
                        departure_time VARCHAR(255) NOT NULL,
                        ticket_class VARCHAR(255) NOT NULL,
                        seat_number VARCHAR(255) NOT NULL,
                        ticket_price BIGINT NOT NULL,
                        ticket_status BOOLEAN NOT NULL,
                        booking_date DATE NOT NULL,
                        user_id BIGINT
);
INSERT INTO `airline_test`.`ticket` (`ticket_number`, `flight_number`, `departure`, `destination`, `departure_date`, `departure_time`, `ticket_class`, `seat_number`, `ticket_price`, `ticket_status`, `booking_date`,`user_id`)
VALUES ('123', 'abc', 'HN', 'HCM', '2023-06-07', '1h', 'thương gia', 'zxc', '56', '0', '2023-06-07',null);
INSERT INTO `airline_test`.`ticket` (`ticket_number`, `flight_number`, `departure`, `destination`, `departure_date`, `departure_time`, `ticket_class`, `seat_number`, `ticket_price`, `ticket_status`, `booking_date`,`user_id`)
VALUES ('123', 'abc', 'HN', 'HCM', '2023-06-07', '1h', 'thương gia', 'zxc', '30', '0', '2023-06-07',null);
INSERT INTO `airline_test`.`ticket` (`ticket_number`, `flight_number`, `departure`, `destination`, `departure_date`, `departure_time`, `ticket_class`, `seat_number`, `ticket_price`, `ticket_status`, `booking_date`,`user_id`)
VALUES ('123', 'abc', 'HN', 'HCM', '2023-06-07', '1h', 'thương gia', 'zxc', '20', '0', '2023-06-07',null);
ALTER TABLE ticket  ADD CONSTRAINT fk_user_id FOREIGN KEY(`user_id`) REFERENCES `user`(`id`);

