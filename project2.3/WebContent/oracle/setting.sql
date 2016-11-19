select * from tab;

create table BAN(
	BAN_NUM number primary key,
	BAN_NAME varchar2(20),
	BAN_INONE number,
	BAN_PERIOD varchar2(20),
	BAN_TEACHER varchar2(50)
);

create table MEM(
	MEM_NUM number,
	BAN_NUM number,
	MEM_NAME varchar2(20),
	MEM_ID varchar2(20),
	MEM_PW varchar2(20),
	MEM_BIRTH number,
	MEM_GRADE number,
	MEM_PH varchar2(20),
	CONSTRAINT MEM_MEM_NUM_pk PRIMARY KEY(MEM_NUM),
	CONSTRAINT MEM_BAN_NUM_fk FOREIGN KEY(BAN_NUM) REFERENCES BAN(BAN_NUM)
);

create table BRD(
	BRD_NUM number,
	MEM_NAME varchar2(10),
	BRD_TITLE varchar2(100),
	BRD_DATE date,
	BRD_CONTENT varchar2(1024),
	CONSTRAINT BRD_BRD_NUM_pk PRIMARY KEY(BRD_NUM)
);

create table ATT(
	BAN_NUM number,
	MEM_NUM number,
	MEM_NAME varchar2(10),
	ATT_DATE date,
	ATT_LOG date,
	ATT_OUT date,
	CONSTRAINT ATT_BAN_NUM_fk FOREIGN KEY(BAN_NUM) REFERENCES BAN(BAN_NUM),
	CONSTRAINT ATT_MEM_NUM_fk FOREIGN KEY(MEM_NUM) REFERENCES MEM(MEM_NUM)
);

create table JUMSU(
   BAN_NUM number,
   MEM_NUM number,
   MEM_NAME varchar2(10),
   JUMSU_SCORE1 number,
   JUMSU_SCORE2 number,
   JUMSU_SCORE3 number,
   CONSTRAINT JUMSU_BAN_NUM_fk FOREIGN KEY(BAN_NUM) REFERENCES BAN(BAN_NUM),
   CONSTRAINT JUMSU_MEM_NUM_fk FOREIGN KEY(MEM_NUM) REFERENCES MEM(MEM_NUM)
);

create table FINDHEWON(
	BAN_NUM number,
	MEM_NUM number,
	MEM_NAME varchar2(10),
	MEM_PH varchar2(20),
	CONSTRAINT FINDHEWON_BAN_NUM_fk FOREIGN KEY(BAN_NUM) REFERENCES BAN(BAN_NUM),
	CONSTRAINT FINDHEWON_MEM_NUM_fk FOREIGN KEY(MEM_NUM) REFERENCES MEM(MEM_NUM)
);

create sequence MEM_seq start with 4 increment by 1;
create sequence BRD_seq start with 1 increment by 1;
create sequence SW_seq start with 10000 increment by 1;
create sequence PR_seq start with 20000 increment by 1;
create sequence PA_seq start with 30000 increment by 1;

drop sequence MEM_seq;
drop sequence BRD_seq;
drop sequence SW_seq;
drop sequence PR_seq;
drop sequence PA_seq;

SELECT * from MEM;
SELECT * from BAN;
SELECT * from ATT;
SELECT * from FINDHEWON;
SELECT * from JUMSU;
SELECT * from BRD;

drop table MEM CASCADE CONSTRAINT;
drop table BAN CASCADE CONSTRAINT;
drop table FINDHEWON;
drop table ATT;
drop table JUMSU;
drop table BRD;

insert into BAN values (10000,'SW',0,'10102020','no');
insert into BAN values (20000,'PA',0,'10102020','no');
insert into BAN values (30000,'PR',0,'10102020','no');
insert into BAN values (0,'dumi',0,'10102020','no');
insert into MEM values (0,0,'aaaa','admin1','1234',19910729,1,'01033931474');
insert into MEM values (1,0,'aaaa','admin2','1234',19910729,2,'01033931474');
insert into MEM values (2,0,'aaaa','admin3','1234',19910729,3,'01033931474');
insert into MEM values (3,0,'aaaa','admin4','1234',19910729,4,'01033931474');
insert into MEM values (4,0,'aaaa','admin5','1234',19910729,5,'01033931474');
insert into JUMSU values (10000,0,'aaaa',50,50,50);
insert into ATT values (10000, 3, 'aaaa', sysdate, sysdate, sysdate);
insert into BRD values (0,'관리자','공지사항',sysdate,'공지사항입니다.');
insert into FINDHEWON values (10000,0,'aaaa','01010101010');