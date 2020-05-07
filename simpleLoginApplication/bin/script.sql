create database today09_04_2020;
use today09_04_2020;

create table register(
	name varchar(50),
    email varchar(50),
    password varchar(50)
);

create table registercompany (
	id int AUTO_INCREMENT primary key,
	name varchar(100),
    companyname varchar(100),
    contact bigint,
    gender varchar(100),
    country varchar(100),
    state varchar(100),
    city varchar(100)
);
