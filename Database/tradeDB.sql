
/*
--�Ǽ� ������ ���̺� �����
drop table trade cascade constraints

/* 
�ŷ���Ȳ ���̺��ε� ���� ��ȹ�ߴ��� int������, 
���ü��� �������� ȸ�����̵�� ����
*/  

create table trade
(
	p_idx	int,	--��ǰ����
	seller	varchar2(100),	--�Ǹ���
	buyer	varchar2(100),	--������
	t_date  date
)

---------------------- �������� ---------------------

--------�⺻Ű(pk) ����
alter table trade
	add constraint pk_trade_p_idx primary key(p_idx);
	
	


insert into trade values(1,'hong123','haha');






*/

