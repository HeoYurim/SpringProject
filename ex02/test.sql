create table tbl_reply(
	rno number(10,0),
	bno number(10,0) not null,
	reply varchar2(1000) not null,
	replyer varchar2(50) not null,
	replyDate date default sysdate,
	updateDate date default sysdate
);

create sequence seq_reply;

alter table tbl_reply add constraint pk_reply primary key(rno);

alter table tbl_reply add constraint fk_reply_board
foreign key(bno) references tbl_board(bno);

select * from tbl_reply order by rno desc;

insert into tbl_board (bno, title, content, writer)
(select seq_board.nextval, title, content, writer from tbl_board);
select * from TBL_BOARD;
select * from TBL_REPLY;

alter table tbl_reply add constraint fk_reply_board
foreign key (bno) references tbl_board (bno);

delete from TBL_REPLY where RNO = 23;

create index idx_reply on tbl_reply (bno desc, rno asc);

select /*+INDEX(tbl_reply idx_reply) */
	rownum rn, bno, rno, reply, replyer, replyDate, updatedate
    from tbl_reply
    where bno = 1310732
    and rno > 0