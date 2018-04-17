insert into user values(1001,'john@example.com');
insert into user values (1002,'andy@example.com');
insert into user values (1003,'tim@example.com');
insert into user values (1004,'jack@example.com');
insert into user_relationship values(1001,1002,FALSE,'FRIEND');
insert into user_relationship values(1002,1001,FALSE,'FRIEND');
insert into user_relationship values(1003,1002,FALSE,'FRIEND');
insert into user_relationship values(1002,1003,FALSE,'FRIEND');
