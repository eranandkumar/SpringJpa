create table employee_details (emp_id integer not null, date_of_birth datetime, location varchar(255), emp_name varchar(255), salary double precision not null, primary key (emp_id)) 
insert into employee_details(emp_id,date_of_birth,location,emp_name,salary,phone_num) 
values(10001,'1987-12-09','bettiah','anand',60000.00,123456789);