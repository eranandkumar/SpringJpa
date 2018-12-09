create table person(
id integer not null,
first_name varchar(255) not null,
last_name varchar(255),
location varchar(255),
primary key(id)
);

insert into person(id,first_name,last_name,location) values(10001,'Anand','Kumar','TRV');
insert into person(id,first_name,last_name,location) values(10002,'Aman','akash','Delhi');
insert into person(id,first_name,last_name,location) values(10003,'vivek','Ranjan','Patna');