DROP DATABASE IF EXISTS fitness;

CREATE DATABASE fitness;

USE fitness;

CREATE TABLE IF NOT EXISTS subscriptions(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
price INT NOT NULL,
starting_date VARCHAR(15) NOT NULL,
end_date VARCHAR(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS gyms(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS workouts(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
duration INT NOT NULL,
aerobic TINYINT NOT NULL,
gyms_id INT NOT NULL UNIQUE, -- prin introducerea constraint-ului UNIQUE am fortat relatia One To One intre tabelul workouts si tabelul gyms
CONSTRAINT fk_workouts_gyms
FOREIGN KEY(gyms_id)
REFERENCES gyms(id)
);

CREATE TABLE IF NOT EXISTS persons(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
surname VARCHAR(20) NOT NULL,
first_name VARCHAR(20) NOT NULL,
year_of_birth INT NOT NULL,
subscriptions_id INT NOT NULL, -- prin faptul ca nu am folosit constraint-ul UNIQUE am permis ca relatia sa fie Many To One de la tabelul persons catre tabelul subscriptions
CONSTRAINT fk_persons_subscriptions
FOREIGN KEY(subscriptions_id)
REFERENCES subscriptions(id)
);


