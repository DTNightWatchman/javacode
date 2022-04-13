drop database if exits messagebase;
create database messagebase;
use messagebase;
drop table if exits message;
create table message (
    'from' varchar(50),
    'to' varchar(50),
    'say' varchar(1024)
);
