create database test
go
use test
go
--���ű�
create table dept(
       did int primary key identity(1,1),
       dname nvarchar(20),
       man int,
       tel varchar(30),
       updept int
)
--Ա����
create table emp(
       eid int primary key identity(1,1),
       ename nvarchar(20),
       sex varchar(1),
       hire varchar(50),
       sar float,
       did int
)
--�˺ű�
create table acc(
       aid int primary key,
       username varchar(20),
       password varchar(20),
       stat int
)
--ְλ��
create table job(
       jid int primary key identity(1,1),
       jname nvarchar(20)
)
--����ְλ���ձ�
create table dept_job(
       did int,
       jid int
)
--����������
create table history(
       hid int primary key identity(1,1),
       startdate varchar(50),
       enddate varchar(50),
       place nvarchar(50),
       job nvarchar(20),
       eid int
)
insert into dept values('���»�',5,'1111111',0)
insert into dept values('�г���',6,'2222222',1)
insert into dept values('����',7,'3333333',1)
insert into dept values('�ɹ���',8,'4444444',1)

insert into emp values('tom','m','1990-09-09',4500.50,1)
insert into emp values('jacky','m','1991-02-19',2982.12,2)
insert into emp values('kelly','f','1992-11-29',3491.32,3)
insert into emp values('red','f','1993-10-11',2700.00,4)
insert into emp values('blue','m','1990-12-21',4500.50,2)
insert into emp values('green','f','1990-04-09',5982.12,2)
insert into emp values('С��','m','1993-06-18',6491.32,3)
insert into emp values('С��','m','1993-01-17',7700.00,4)

insert into acc values(5,'tom','111',0)
insert into acc values(6,'jacky','222',0)
insert into acc values(7,'kelly','333',0)
insert into acc values(8,'red','555',0)

insert into job values('���³�')
insert into job values('�ܾ���')
insert into job values('��������')
insert into job values('�����ܼ�')
insert into job values('���')
insert into job values('����')
insert into job values('��Ŀ����')
insert into job values('��ͨԱ��')






