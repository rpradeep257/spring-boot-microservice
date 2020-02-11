insert into address (id, version, address) values (1, 0, 'UK');

insert into customer (id, version, name, address_id) values (1, 0, 'John Wick', 1);


insert into author (id, name) values (1, 'john wick');

insert into book (id, name, author_id) values (1, 'book1', 1);
insert into book (id, name, author_id) values (2, 'book2', 1);
