/*
--�Ǽ� ������ ���̺� �����
drop table JJim cascade constraints

create table jjim
(
	j_idx	int, 	 --�������ȣ(pk)
	p_idx	int,	 --��ǰ��ȣ(fk)
	u_idx	int		 --ȸ�����̵�(fk)
)


---------------------- �������� ---------------------

--------�⺻Ű(pk) ����
alter table jjim
	add constraint pk_jjim_j_idx primary key(j_idx);

--------�ܷ�Ű(fk) ����	
--��ǰ���̺�
alter table jjim
	add constraint fk_jjim_p_idx foreign key(p_idx)
	references product(p_idx);

--ȸ�����̺�
alter table jjim
	add constraint fk_jjim_u_idx foreign key(u_idx)
	references user_market(u_idx);

select * from jjim where u_idx=1
insert into jjim values( 1,1,1)

*/