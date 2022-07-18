create table if not exists users (
    id int,
    first_name varchar(20),
    last_name varchar(20),
    email varchar(20));

insert into users (id, first_name, last_name, email) values
    ('42f1aa3d-bb87-4f86-9b00-fadeaf4f2b59', 'Frodo', 'Baggins','f.baggins@test.com'),
    ('987187d0-d9b1-4a46-b5ac-7466eaf0cab7', 'Samwise', 'Gamgee','s.gamgee@test.com'),
    ('b1ae5cc2-285f-4e00-91c7-f3b35bc8681b', 'Peregrin', 'Took','p.took@test.com'),
    ('c8adba82-0304-4380-a62f-ed3e1b0bcbd7', 'Merry', 'Brandybuck','m.brandybuck@test.com');


