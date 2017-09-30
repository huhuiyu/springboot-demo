use mysql;

drop database if exists HuhuiyuDemo;

create database HuhuiyuDemo default charset utf8 collate utf8_general_ci;

use HuhuiyuDemo;

create table TblStatus
(
	sid integer auto_increment primary key not null,
	stype integer not null comment '状态类别,1是预约状态',
	status varchar(50) not null comment '状态信息',
	deleted char(1) default 'n' not null comment '是否删除'
)comment '状态信息表';

insert into TblStatus(stype,status) values(1,'预约成功');
insert into TblStatus(stype,status) values(1,'预约取消');
insert into TblStatus(stype,status) values(1,'服务完成');
insert into TblStatus(stype,status) values(1,'预约过期');
insert into TblStatus(stype,status) values(1,'支付中');

select * from TblStatus;