
/*
--�Ǽ� ������ ���̺� �����
drop table image cascade constraints

--�̹��� ���̺� ������ ��ü���� (���� ������ ���� �ȵ�!!)
delete from image


create table image
(
	
	p_idx		int, 			--��ǰ��ȣ
	sumimage	varchar2(4000),	--����� ����
	imageFile1	varchar2(4000), --����1
	imageFile2	varchar2(4000), --����2
	imageFile3	varchar2(4000), --����3
	imageFile4	varchar2(4000), --����4
	imageFile5	varchar2(4000)  --����5
);

---------------------- �������� ---------------------

--------�⺻Ű(pk) ����
alter table image
	add constraint pk_image_p_idx primary key(p_idx);


select * from image


insert into image
values(
(select max(p_idx) from product),
cat123.gif,
wow123.jpg,
null,
null,
null,
null
)

select * from image
select p_idx, sumimage from image 
select * from product

*/

