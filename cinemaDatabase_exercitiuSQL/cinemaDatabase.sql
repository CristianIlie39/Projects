drop database if exists cinema;
create database cinema;
use cinema;

create table if not exists actors(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(30) NOT NULL,
surname VARCHAR(30) NOT NULL,
gender VARCHAR(10) NOT NULL
);

create table if not exists genres(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
genre VARCHAR(20) NOT NULL,
projection VARCHAR(10) NOT NULL
);

create table if not exists directors(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
surname VARCHAR(20) NOT NULL
);

create table if not exists movies(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
title VARCHAR(50) NOT NULL,
launch_year INT NOT NULL,
movie_duration INT NOT NULL,
language VARCHAR(15) NOT NULL,
launch_country VARCHAR(20) NOT NULL,
genres_id INT NOT NULL,
CONSTRAINT fk_movies_genres
FOREIGN KEY (genres_id)
REFERENCES genres(id),
directors_id INT NOT NULL,
CONSTRAINT fk_movies_directors
FOREIGN KEY (directors_id)
REFERENCES directors(id)
);

create table if not exists reviewers(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
name VARCHAR(20) NOT NULL,
surname VARCHAR(20) NOT NULL,
age INT NOT NULL
);

create table if not exists ratings(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
reviewers_id INT NOT NULL,
CONSTRAINT fk_ratings_reviewers
FOREIGN KEY(reviewers_id)
REFERENCES reviewers(id),
movies_id INT NOT NULL,
CONSTRAINT fk_ratings_movie
FOREIGN KEY(movies_id)
REFERENCES movies(id),
stars INT NOT NULL
);

create table if not exists movie_casts(
id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
movies_id INT NOT NULL,
CONSTRAINT fk_movie_casts_movies
FOREIGN KEY(movies_id)
REFERENCES movies(id),
actors_id INT NOT NULL,
CONSTRAINT fk_movie_casts_actors
FOREIGN KEY(actors_id)
REFERENCES actors(id),
role VARCHAR(15) NOT NULL
);

-- aici introducem actorii

insert into actors
(name, surname, gender)
values
('Roberts', 'Julia', 'female');

insert into actors
(name, surname, gender)
values
('Constantin', 'Mihai', 'male');

insert into actors
(name, surname, gender)
values
('Stiller', 'Ben', 'male');

insert into actors
(name, surname, gender)
values
('Diaconu', 'Mircea', 'male');

insert into actors
(name, surname, gender)
values
('DiCaprio', 'Leonardo', 'male');

insert into actors
(name, surname, gender)
values
('Neill', 'Sam', 'male');

insert into actors
(name, surname, gender)
values
('Dinica', 'Gheorghe', 'male');

insert into actors
(name, surname, gender)
values
('Weaver', 'Sigourney', 'female');

insert into actors
(name, surname, gender)
values
('de Funes', 'Louis', 'male');

insert into actors
(name, surname, gender)
values
('Pacino', 'Al', 'male');

-- aici introducem genurile

insert into genres
(genre, projection)
values
('romance', '2D');

insert into genres
(genre, projection)
values
('science fiction', '3D');

insert into genres
(genre, projection)
values
('comedy', '2D');

insert into genres
(genre, projection)
values
('dance', '3D');

insert into genres
(genre, projection)
values
('comedy', '2D');

insert into genres
(genre, projection)
values
('thriller', '2D');

insert into genres
(genre, projection)
values
('thriller', '2D');

insert into genres
(genre, projection)
values
('dark comedy', '2D');

insert into genres
(genre, projection)
values
('comedy', '2D');

insert into genres
(genre, projection)
values
('science fiction', '2D');

-- aici introducem regizorii

insert into directors
(name, surname)
values
('Cameron', 'James');

insert into directors
(name, surname)
values
('Caranfil', 'Nae');

insert into directors
(name, surname)
values
('Speer', 'Scott');

insert into directors
(name, surname)
values
('Ford Copola', 'Francis');

insert into directors
(name, surname)
values
('Marshall', 'Garry');

insert into directors
(name, surname)
values
('Scorsese', 'Martin');

insert into directors
(name, surname)
values
('Spielberg', 'Steven');

insert into directors
(name, surname)
values
('Serban', 'Florin');

insert into directors
(name, surname)
values
('Girault', 'Jean');

insert into directors
(name, surname)
values
('Roach', 'Jay');

-- aici introducem filmele

insert into movies 
(title, launch_year, movie_duration, language, launch_country, genres_id, directors_id)
values
('Le gendarme et les gendarmettes', 1982, 95, 'French', 'France', 3, 9);

insert into movies
(title, launch_year, movie_duration, language, launch_country, genres_id, directors_id)
values
('Pretty Woman', 1990, 125, 'English', 'Canada', 1, 5);

insert into movies
(title, launch_year, movie_duration, language, launch_country, genres_id, directors_id)
values
('Meet the Parents', 2000, 108, 'English', 'USA', 9, 10);

insert into movies
(title, launch_year, movie_duration, language, launch_country, genres_id, directors_id)
values
('Avatar', 2009, 162, 'English', 'USA', 2, 1);

insert into movies
(title, launch_year, movie_duration, language, launch_country, genres_id, directors_id)
values
('Eu cand vreau sa fluier, fluier', 2010, 94, 'Romanian', 'Romania', 6, 8);

insert into movies
(title, launch_year, movie_duration, language, launch_country, genres_id, directors_id)
values
('Step Up Revolution', 2012, 99, 'English', 'USA', 4, 3);

insert into movies
(title, launch_year, movie_duration, language, launch_country, genres_id, directors_id)
values
('Filantropica', 2002, 110, 'Romanian', 'Romania', 5, 2);

insert into movies
(title, launch_year, movie_duration, language, launch_country, genres_id, directors_id)
values
('The Godfather', 1972, 175, 'English', 'USA', 7, 4);

insert into movies
(title, launch_year, movie_duration, language, launch_country, genres_id, directors_id)
values
('The Wolf of Wall Street', 2013, 179, 'English', 'USA', 8, 6);

insert into movies
(title, launch_year, movie_duration, language, launch_country, genres_id, directors_id)
values
('Jurassic Park', 1993, 126, 'English', 'USA', 10, 7);

-- aici introducem reviewers

insert into reviewers
(name, surname, age)
values
('Smith', 'John', 32);

insert into reviewers
(name, surname, age)
values
('Munteanu','Razvan', 33);

insert into reviewers
(name, surname, age)
values
('Calinescu', 'Florin', 50);

insert into reviewers
(name, surname, age)
values
('McGraw', 'Phil', 55);

insert into reviewers
(name, surname, age)
values
('Anastasia', 'Carey', 17);

insert into reviewers
(name, surname, age)
values
('Dorina', 'Simion', 16);

insert into reviewers
(name, surname, age)
values
('Seacrest', 'Ryan', 45);

insert into reviewers
(name, surname, age)
values
('Harvey', 'Steve', 61);

insert into reviewers
(name, surname, age)
values
('Petre', 'Mihai', 43);

insert into reviewers
(name, surname, age)
values
('Radulescu', 'Mihaela', 50);

-- aici introducem ratings

insert into ratings
(reviewers_id, movies_id, stars)
values
(10, 2, 4);

insert into ratings
(reviewers_id, movies_id, stars)
values
(8, 6, 2);

insert into ratings
(reviewers_id, movies_id, stars)
values
(7, 8, 3);

insert into ratings
(reviewers_id, movies_id, stars)
values
(9, 5, 4);

insert into ratings
(reviewers_id, movies_id, stars)
values
(1, 3, 4);

insert into ratings
(reviewers_id, movies_id, stars)
values
(2, 7, 2);

insert into ratings
(reviewers_id, movies_id, stars)
values
(4, 9, 3);

insert into ratings
(reviewers_id, movies_id, stars)
values
(6, 10, 2);

insert into ratings
(reviewers_id, movies_id, stars)
values
(3, 4, 4);

insert into ratings
(reviewers_id, movies_id, stars)
values
(5, 1, 4);

-- aici introducem movie_casts

insert into movie_casts
(movies_id, actors_id, role)
values
(3, 3, 'main');

insert into movie_casts
(movies_id, actors_id, role)
values
(4, 8, 'secondary');

insert into movie_casts
(movies_id, actors_id, role)
values
(5, 2, 'secondary');

insert into movie_casts
(movies_id, actors_id, role)
values
(7, 4, 'main');

insert into movie_casts
(movies_id, actors_id, role)
values
(2, 1, 'main');

insert into movie_casts
(movies_id, actors_id, role)
values
(8, 10, 'main');

insert into movie_casts
(movies_id, actors_id, role)
values
(7, 7, 'secondary');

insert into movie_casts
(movies_id, actors_id, role)
values
(9, 5, 'main');

insert into movie_casts
(movies_id, actors_id, role)
values
(1, 9, 'main');

insert into movie_casts
(movies_id, actors_id, role)
values
(10, 6, 'main');

-- 3.Sa se afiseze toti actorii de gen masculin
select * from actors
where gender = 'male';

-- 4.Sa se afiseze toti actorii de gen feminin
select * from actors
where gender = 'female';

-- 5.Sa se afiseze filmele lansate inainte de 1990
select title, launch_year from movies
where launch_year < 1990;

-- 6.Sa se afiseze filmele drama si comedie 
select title, genre from movies inner join genres on movies.genres_id = genres.id 
where genre = 'drama' and 'comedy';
-- 6.1. Sa se afiseze filmele drama
select title, genre from movies inner join genres on movies.genres_id = genres.id
where genre = 'drama';
-- 6.2. Sa se afiseze filmele comedie
select title, genre from movies inner join genres on movies.genres_id = genres.id
where genre = 'comedy';

-- 7.Sa se afiseze filmele care nu au fost lansate in Romania
select title, launch_country from movies 
where launch_country <> 'Romania';

-- 8.Sa se afiseze filmele care au fost regizate de Martin Scorsese
select title, surname, name from movies inner join directors on movies.directors_id = directors.id 
where name = 'Scorsese' and surname = 'Martin';

-- 9.Sa se afiseze filmele care dureaza mai mult de 2 ore
select title, movie_duration from movies 
where movie_duration > 120;

-- 10.Sa se afiseze cate filme dureaza intre o ora si 2 ore
select title, movie_duration from movies 
where movie_duration >= 60 and movie_duration <= 120;

-- 11.Sa se afiseze toti reviewerii mai mari de 18 ani
select surname, name, age from reviewers 
where age > 18;

-- 12.Sa se afiseze cati revieweri sunt mai mici de 18 ani
select surname, name, age from reviewers
where age < 18;

-- 13.Sa se afiseze filmele care au mai mult de 3 stele
select title, stars from movies inner join ratings on ratings.movies_id = movies.id
where stars > 3;

-- 14.Sa se afiseze cate filme au mai putin de 3 stele
select title, stars from movies inner join ratings on ratings.movies_id = movies.id 
where stars < 3;

-- 15.Sa se afiseze media de varsta a tuturor reviewerilor
select avg(age) from reviewers;

-- 16.Sa se afiseze durata medie a tuturor filmelor
select avg(movie_duration) from movies;

-- 17.Sa se afiseze actorii din filmul Pretty Woman
select surname, name, title from actors inner join movie_casts on movie_casts.actors_id = actors.id inner join movies on movie_casts.movies_id = movies.id 
where title = 'Pretty Woman';

-- 18.Sa se afiseze filmele in care un anumit actor a avut rolul principal
select title, surname, name, role from movies inner join movie_casts on movie_casts.movies_id = movies.id inner join actors on movie_casts.actors_id = actors.id 
where role = 'main';

-- 19.Sa se afiseze filmele comedie
select title, genre from movies inner join genres on movies.genres_id = genres.id 
where genre = 'comedy';

-- 20.Sa se afiseze filmele care nu sunt 3D
select title, projection from movies inner join genres on movies.genres_id = genres.id 
where projection <> '3D';

-- 21.Sa se afiseze filmele comedie 2D
select title, genre, projection from movies inner join genres on movies.genres_id = genres.id 
where genre = 'comedy' and projection = '2D';




































