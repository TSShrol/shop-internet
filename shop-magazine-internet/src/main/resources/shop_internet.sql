DROP DATABASE IF EXISTS  shop_internet;
CREATE DATABASE shop_internet  CHAR SET=utf8;
USE shop_internet;
CREATE TABLE users(
	id INT NOT NULL primary key auto_increment,
    email varchar(50) not null, 
    first_name VARCHAR(50) not null,
    last_name VARCHAR(50) not null,
    role varchar(50) not null,
    password varchar(255) not null
) ;

CREATE TABLE products(
    id INT NOT NULL primary key auto_increment,
    name varchar(50) not null, 
    description VARCHAR(255) not null,
    price double default null
) ;

create table orders (
	id int NOT NULL primary key auto_increment,
    user_id int default null,
    created_date DATETIME DEFAULT NOW(),
    delivery_address text,
    constraint user_id_FK  foreign key (user_id) references users (id) on delete cascade on update restrict
) ;
CREATE TABLE bucket(
	id INT not null primary key auto_increment,
    order_id int default null,
    product_id int default null,
    constraint order_id_FK  foreign key (order_id) references orders (id) on delete cascade on update restrict,
    constraint product_id_FK  foreign key (product_id) references products (id) on delete cascade on update restrict
);
