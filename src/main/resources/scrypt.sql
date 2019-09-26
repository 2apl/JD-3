create schema library;

create table library.genre (
    id bigserial primary key ,
    name character varying(128) not null
);

create table library.author(
    id bigserial primary key ,
    name character varying(128) not null ,
    date_of_birth date
);

create table library.book (
    id bigserial primary key ,
    name character varying(128),
    creation_year int,
    genre_id bigint not null ,
    author_id bigint not null,
    constraint fk_genre_id foreign key (genre_id) references library.genre(id),
    constraint fk_author_id foreign key (author_id) references library.author(id)
);

insert into library.genre (name)
values
        ('art'),
        ('science'),
        ('poem');

insert into library.author (name, date_of_birth)
values
        ('Pushkin', '1799-05-26'),
        ('Dumas', '1802-07-24'),
        ('Tsiolkovsky', '1857-09-17');

insert into library.book(name, creation_year, genre_id, author_id)
VALUES
       ('Ruslan i Ludmila', 1820, (select id from library.genre where name = 'poem'), (select id from library.author where library.author.name = 'Pushkin')),
       ('Cawcazskiy plennik', 1821, (select id from library.genre where name = 'poem'), (select id from library.author where library.author.name = 'Pushkin')),
       ('Pikovaa dama', 1834, (select id from library.genre where name = 'art'), (select id from library.author where library.author.name = 'Pushkin')),
       ('Le Journal de Madame Giovanni', 1856, (select id from library.genre where name = 'art'), (select id from library.author where library.author.name = 'Dumas')),
       ('The Three Musketeers', 1844, (select id from library.genre where name = 'art'), (select id from library.author where library.author.name = 'Dumas')),
       ('Captain Paul', 1834, (select id from library.genre where name = 'art'), (select id from library.author where library.author.name = 'Dumas')),
       ('On the Moon', 1893, (select id from library.genre where name = 'science'), (select id from library.author where library.author.name = 'Tsiolkovsky'));
