create databases if not exists systemdemo;
use systemdemo;
create table if not exists table_exam(
       id int auto_increment,
       answer varchar(255) not null,
       result varchar(255),
       primary key(id)
       ) engine = innodb default charset = utf8;
use systemdemo;
create table if not exists tb_stu(
       id int auto_increment,
       stuId int not null,
       stuName varchar(20),
       pwd varchar(30),
       cPwd varchar(30),
       question varchar(255),
       result varchar(255),
       primary key(id)
       ) engine = innodb default charset = utf8;