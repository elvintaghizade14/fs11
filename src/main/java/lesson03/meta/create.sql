create table history
(
    id serial not null
        constraint history_pk
            primary key,
    a  integer,
    b  integer,
    op varchar,
    r  integer
);

INSERT INTO history (id, a, b, op, r) VALUES (DEFAULT, 5, 10, '+', 15);
INSERT INTO history (id, a, b, op, r) VALUES (DEFAULT, 10, 11, '+', 21);
INSERT INTO history (id, a, b, op, r) VALUES (DEFAULT, 10, 12, '+', 22);
INSERT INTO history (id, a, b, op, r) VALUES (DEFAULT, 6, 11, '-', -5);
