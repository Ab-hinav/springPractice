insert into user_table(Id,name,birth_date)
values(1001,'Ranga', current_date()),
(1002,'Ravi', current_date()),
(1003,'Satish', current_date()),
(1004,'Raghu', current_date());

insert into post_table(Id,description,user_id)
values(2001,'Post1', 1001),
(2002,'Post2', 1001),
(2003,'Post3', 1002),
(2004,'Post4', 1002),
(2005,'Post5', 1003),
(2006,'Post6', 1003);

