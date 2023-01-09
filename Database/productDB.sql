/*
--�Ǽ� ������ ���̺� �����
drop table product cascade constraints

--���̺� ������ ��ü����
delete from product


---��ǰ���̺�

create table product
(
	p_idx		int,				    --��ǰ��ȣ(pk)
	u_idx		int,				    --ȸ����ȣ(fk)
	c_idx		int,				    --ī�װ�����ȣ(fk)
	p_name		varchar2(500) not null, --��ǰ��
	p_date		date		  not null, --�����
	p_price		int			  not null,	--��ǰ����
	p_condition varchar2(100), 			--��ǰ����
	p_exp		varchar2(4000),			--��ǰ����
	p_location	varchar2(500),			--�ŷ�����
	p_click		int,		   			--��ȸ��
	p_status	varchar2(100)  			--�ŷ����� (�ŷ�����,�ǸſϷ�)
)

---------------------- �������� ---------------------

--------�⺻Ű(pk) ����
alter table product
	add constraint pk_product_p_idx primary key(p_idx);

--------�ܷ�Ű(fk) ����	
--ȸ�����̺�
alter table product
	add constraint fk_product_u_idx foreign key(u_idx)
	references user_market(u_idx);

--�ܷ�Ű ����	
ALTER TABLE product DROP CONSTRAINT fk_product_u_idx;

--ī�װ��� ���̺�
alter table product
	add constraint fk_product_c_idx foreign key(c_idx)
	references category(c_idx);


---------------------- ���õ����� ----------------------
insert into product 
values( (select nvl(max(p_idx)+1,1) from product),
		1,				--ȸ����ȣ
		1,				--ī�װ�����ȣ
		'�Ѻ��˴ϴ�.',  --��
		sysdate,		--�������
		130000,			--����
		'���ǽ�ǰ',		--��ǰ����
		'���ŷ��� �մϴ�.',	--��ǰ����
		'����� ������',	--�ŷ�����
		10,				--��ȸ��
		'�ŷ�����'		--�ŷ�����
		);
		
		
insert into product 
values( (select nvl(max(p_idx)+1,1) from product),
		1,				--ȸ����ȣ
		2,				--ī�װ�����ȣ
		'�������˴ϴ�.',  --����
		to_date('1970-12-31 12:00:00','yyyy-mm-dd hh24:mi:ss'),		--�������
		30000,			--����
		'�߰�',		--��ǰ����
		'���ŷ��� �մϴ�.',	--��ǰ����
		'����� �д籸',	--�ŷ�����
		2,				--��ȸ��
		'�ŷ�����'		--�ŷ�����
		);
insert into product 
values( (select nvl(max(p_idx)+1,1) from product),
		1,				--ȸ����ȣ
		2,				--ī�װ�����ȣ
		'�������˴ϴ�.',  --����
		sysdate,		--�������
		30000,			--����
		'�߰�',		--��ǰ����
		'���ŷ��� �մϴ�.',	--��ǰ����
		'����� �д籸',	--�ŷ�����
		0,				--��ȸ��
		'�ŷ�����'		--�ŷ�����
		);

------ ��ȸ��
select * from product

update product set p_click=0 where p_idx=5

select p_idx from product when

select 
    p.*,
    floor((sysdate-p_date)*24) as hour,floor(((sysdate-p_date)*24-floor((sysdate-p_date)*24))*60) as minute 
from (select * from product) p

select
	p.* ,
	to_number(floor((sysdate-p_date)*24*60*60)) as p_time
from (select * from product) p order by p_idx desc

select
	p.* ,
	to_number(floor((sysdate-p_date)*24*60*60)) as p_time
from (select * from product) p where u_idx=3 order by p_idx desc

select
	p.* ,
	to_number(floor((sysdate-p_date)*24*60*60)) as p_time
from (select * from product) p where c_idx=3 order by p_idx desc

------------7/6 view����-----------
create or replace view product_user 
as
select u_name, p_name, p_date, p.p_idx 
from user_market, product p

select * from product_user
drop view product_user

select * from (select * from product_user order by p_idx asc) where ROWNUM  <= 6
-----------------------------------

select * from product 

select count(*) from product where to_char(p_date,'dd') = to_char(sysdate, 'dd')



	select p.*,
  	to_number(floor((sysdate-p_date)*24*60*60)) as p_time
  			
  	from(select * from product)	p
  		
  	where	p_name like '%����%' or p_exp like '%����%' 
  	
  	order by p_idx desc



select
			p.* ,
			to_number(floor((sysdate-p_date)*24*60*60)) as p_time
		from (select * from product) p where u_idx=3 order by p_idx desc





*/