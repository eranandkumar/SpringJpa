insert into course(id,course_name,course_fee) values (1001,'JAVA',4000.00);
insert into course(id,course_name,course_fee) values (1002,'Spring',5000.00);
insert into course(id,course_name,course_fee) values (1003,'Spring Boot',3000.00);

insert into passport(id,passport_number) values (2001,'P111');
insert into passport(id,passport_number) values (2002,'P222');
insert into passport(id,passport_number) values (2003,'P222');

insert into review(id,description,rating) values (3001,'5','Awesome');
insert into review(id,description,rating) values (3002,'4','Very Good');
insert into review(id,description,rating) values (3003,'3','Good');

insert into student(id, student_name) values (1, 'Anand');
insert into student(id, student_name) values (2, 'Aman');
insert into student(id, student_name) values (3, 'Vivek');

update student SET passport_id=2001 where id=1;
update student SET passport_id=2002 where id=2;
update student SET passport_id=2003 where id=3;

#TO Get Al passport, Student detail
select * from student,passport where student.passport_id = passport.id;
