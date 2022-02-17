-- 把创建库的语句都单独放在一个sql文件中
-- 方便未来进行部署
create database javaBookManage;
use javaBookManage;
--创建表
drop table if exists book;
drop table if exists user;

create table book(
    bookId int primary key auto_increment,
    name varchar(50),
    author varchar(50),
    -- 价格用整数来表示，单位为分
    price int,
    type varchar(50),
    isBorrowed int
);
create table user(
    userId int primary key auto_increment,
    name varchar(50) unique,
    password varchar(50),
    -- 0 表示不是管理员，1表示是管理员
    isAdmin int
);

--插入数据
insert into book values(null,"西游记","吴承恩",10000,"古典名著",0);
insert into book values(null,"三国演义","罗贯中",12000,"古典名著",0);
insert into book values(null,"金瓶梅","兰陵笑笑生",9000,"古典名著",0);

--插入用户
insert into user values(null,"admin","123",1);
insert into user values(null,"张三","456",1);