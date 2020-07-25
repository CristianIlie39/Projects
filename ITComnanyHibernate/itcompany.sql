drop database if exists itcompany;

create database itcompany;

use itcompany;

create table if not exists employees(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
surname VARCHAR(20) NOT NULL,
address VARCHAR(20) NOT NULL,
age INT NOT NULL,
department_name VARCHAR(30) NOT NULL,
position VARCHAR (30) NOT NULL
);

create table if not exists departments(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name_of_department VARCHAR(30) NOT NULL,
floor INT NOT NULL,
number_of_employees INT NOT NULL,
name_of_department_head VARCHAR(40) NOT NULL
);

create table if not exists products(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
product_name VARCHAR(30) NOT NULL,
product_version VARCHAR(30) NOT NULL,
number_of_customers INT NOT NULL,
price INT NOT NULL
);




