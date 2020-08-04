DROP DATABASE IF EXISTS library;

CREATE DATABASE library;

USE library;

DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS sections;
DROP TABLE IF EXISTS persons;
DROP TABLE IF EXISTS books_authors;
DROP TABLE IF EXISTS books_persons;
DROP TABLE IF EXISTS authors_sections;
DROP TABLE IF EXISTS authors_persons;
DROP TABLE IF EXISTS sections_persons;

CREATE TABLE IF NOT EXISTS sections(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS authors(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
surname VARCHAR(20) NOT NULL,
first_name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS books(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
title VARCHAR(30) NOT NULL,
number_of_volumes INT NOT NULL,
borrowed TINYINT NOT NULL,
sections_id INT NOT NULL,      -- prin faptul ca NU am folosit constraint-ul UNIQUE am permis ca relatia sa fie Many To One de la tabelul books catre tabelul sections; invers relatia este este One To Many
CONSTRAINT fk_books_sections   -- cartea are o singura sectiune (sta pe raftul unei sectiuni; o carte nu poate sta pe 2 rafturi separate aferente unor sectiuni separate)
FOREIGN KEY(sections_id)	   
REFERENCES sections(id)
);

CREATE TABLE IF NOT EXISTS books_authors(    -- relatie many to many in ambele sensuri intre tabelele books si authors
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
authors_id INT NOT NULL,
CONSTRAINT fk_books_authors
FOREIGN KEY(authors_id)
REFERENCES authors(id),
books_id INT NOT NULL,
CONSTRAINT fk_authors_books
FOREIGN KEY(books_id)
REFERENCES books(id)
);

CREATE TABLE IF NOT EXISTS persons(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
surname VARCHAR(20) NOT NULL,
first_name VARCHAR(20) NOT NULL,
address VARCHAR(30) NOT NULL,
age INT NOT NULL
);



CREATE TABLE IF NOT EXISTS books_persons(    -- relatie many to many in ambele sensuri intre tabelele books si persons
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
persons_id INT NOT NULL,
CONSTRAINT fk_books_persons
FOREIGN KEY(persons_id)
REFERENCES persons(id),
books_id INT NOT NULL,
CONSTRAINT fk_persons_books
FOREIGN KEY(books_id)
REFERENCES books(id)
);

CREATE TABLE IF NOT EXISTS authors_sections(  -- relatie many to many in ambele sensuri intre tabelele books si persons
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
sections_id INT NOT NULL,
CONSTRAINT fk_authors_sections
FOREIGN KEY(sections_id)
REFERENCES sections(id),
authors_id INT NOT NULL,
CONSTRAINT fk_sections_authors
FOREIGN KEY(authors_id)
REFERENCES authors(id)
);

CREATE TABLE IF NOT EXISTS authors_persons(  -- relatie many to many in ambele sensuri intre tabelele authors si persons
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
persons_id INT NOT NULL,
CONSTRAINT fk_authors_persons
FOREIGN KEY(persons_id)
REFERENCES persons(id),
authors_id INT NOT NULL,
CONSTRAINT fk_persons_authors
FOREIGN KEY(authors_id)
REFERENCES authors(id)
);

CREATE TABLE IF NOT EXISTS sections_persons(  -- relatie many to many in ambele sensuri intre tabelele sections si persons
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
persons_id INT NOT NULL,
CONSTRAINT fk_sections_persons
FOREIGN KEY(persons_id)
REFERENCES persons(id),
sections_id INT NOT NULL,
CONSTRAINT fk_persons_sections
FOREIGN KEY(sections_id)
REFERENCES sections(id)
);









