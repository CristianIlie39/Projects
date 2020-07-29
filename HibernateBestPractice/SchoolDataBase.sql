DROP DATABASE IF EXISTS school;
CREATE DATABASE school;
use school;

CREATE TABLE IF NOT EXISTS addresses(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
city VARCHAR(30) NOT NULL,
street VARCHAR(40) NOT NULL
); 

CREATE TABLE IF NOT EXISTS classes(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(10) NOT NULL
);

CREATE TABLE IF NOT EXISTS identifiers(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
number INT NOT NULL
);

CREATE TABLE IF NOT EXISTS students(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
first_name VARCHAR(50) NOT NULL,
year_of_birth INT NOT NULL,
electives VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS teachers(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
surname VARCHAR(20) NOT NULL,
age INT NOT NULL,
subject VARCHAR(20) NOT NULL,
tenure TINYINT NOT NULL,
group_master VARCHAR(20) NOT NULL
);

ALTER TABLE students
ADD COLUMN address_id INT NOT NULL UNIQUE, -- cu ajutorul constraint-ului UNIQUE am facut o relatie One To One cu tabelul addresses 
ADD CONSTRAINT fk_students_addresses       -- relatiea este One To One de la tabelul students catre tabelul addresses si invers
FOREIGN KEY(address_id)
REFERENCES addresses(id);

ALTER TABLE students
ADD COLUMN identifier_id INT NOT NULL UNIQUE, -- cu ajutorul constraint-ului UNIQUE am facut o relatie One To One cu tabelul identifiers
ADD CONSTRAINT fk_students_identifiers        -- relatia este One To One de la tabelul students catre tabelul identifiers si invers
FOREIGN KEY(identifier_id)
REFERENCES identifiers(id);

ALTER TABLE students
ADD COLUMN class_id INT NOT NULL,  -- prin faptul ca data aceasta nu mai avem constraint-ul UNIQUE, relatia este Many To One de la students la addresses
ADD CONSTRAINT fk_students_classes -- relatia este Many To One de la tabelul students catre tabelul classes si One To Many invers
FOREIGN KEY(class_id)
REFERENCES classes(id); 

ALTER TABLE teachers
ADD COLUMN address_id INT NOT NULL UNIQUE, -- cu ajutorul constraint-ului UNIQUE am facut o relatie One To One cu tabelul addresses
ADD CONSTRAINT fk_teachers_addresses       -- relatiea este One To One de la tabelul teachers catre tabelul addresses si invers
FOREIGN KEY(address_id)
REFERENCES addresses(id);  

ALTER TABLE teachers
ADD COLUMN identifier_id INT NOT NULL UNIQUE, -- cu ajutorul constraint-ului UNIQUE am facut o relatie One To One cu tabelul identifiers                                            
ADD CONSTRAINT fk_teachers_identifiers        -- relatia este One To One de la tabelul teachers catre tabelul identifiers si invers
FOREIGN KEY(identifier_id)
REFERENCES identifiers(id);

