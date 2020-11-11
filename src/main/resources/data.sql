insert into employee(id,name,salary) 
values(1001,'Dinesh','10000');

insert into employee(id,name,salary) 
values(1002,'Kumar','10000');

insert into employee(id,name,salary) 
values(1003,'Dinesh','10000');

insert into employee(id,name,salary) 
values(1004,'Kumar','10000');

insert into user (email, first_name, last_name, password, id) values ('adminexample@gmail.com','ADMIN','ADMIN','$2a$10$t4.c9w4DmeHyZaCMW4H0neb.5hxckRoGRoDe1hr0pi9sLXzG32MuO', 1001);
insert into role (name, id) values ('ROLE_ADMIN', '1001');
insert into users_roles (user_id, role_id) values (1001, 1001);



