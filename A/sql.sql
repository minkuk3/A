commit;

CREATE table i_product(
    p_no number not null PRIMARY KEY,
    p_name NVARCHAR2(50),
    p_cnt number DEFAULT 0,
    p_regdate date DEFAULT sysdate
);

SELECT
    *
FROM I_PRODUCT;

INSERT into I_PRODUCT
VALUES
(1, '딸기', 0, '20181101');

INSERT into I_PRODUCT
VALUES
(2, '바나나', 0, '20181102');
INSERT into I_PRODUCT
VALUES
(3, '멜론', 0, '20181103');
INSERT into I_PRODUCT
VALUES
(4, '수박', 0, '20181104');

CREATE TABLE i_import(
    i_no number not null PRIMARY key,
    p_no number,
    i_cnt number DEFAULT 0,
    i_date date DEFAULT sysdate
);

SELECT
    *
FROM I_IMPORT;

insert into I_IMPORT
VALUES
(1, 1, 1, '20181107');

insert into I_IMPORT
VALUES
(2, 2, 2, '20181107');
insert into I_IMPORT
VALUES
(3, 3, 3, '20181107');
insert into I_IMPORT
VALUES
(4, 4, 4, '20181107');

CREATE TABLE i_export(
    e_no number not null PRIMARY key,
    p_no number,
    e_cnt number DEFAULT 0,
    e_date date DEFAULT sysdate
);

SELECT
    *
FROM i_export;

insert into i_export
VALUES
(1, 1, 1, '20181108');

insert into i_export
VALUES
(2, 2, 2, '20181108');
insert into i_export
VALUES
(3, 3, 3, '20181108');
insert into i_export
VALUES
(4, 4, 4, '20181108');

commit;


insert into I_PRODUCT
(p_no, p_name)
VALUES
((SELECT nvl(max(p_no),0)+1 from I_PRODUCT), '테스트');

commit;

SELECT
    *
FROM I_PRODUCT;

DELETE FROM I_PRODUCT WHERE p_no = 5;

CREATE table i_product(
    p_no number not null PRIMARY KEY,
    p_name NVARCHAR2(50),
    p_cnt number DEFAULT 0,
    p_regdate date DEFAULT sysdate
);

SELECT * FROM I_PRODUCT;

SELECT * FROM I_IMPORT ORDER by i_no;

SELECT * FROM I_EXPORT ORDER BY E_NO;

commit;

UPDATE I_PRODUCT 
SET p_cnt = p_cnt + i_cnt 
where p_no = p_no;

DELETE FROM I_EXPORT WHERE e_no = 9;

SELECT 
p_no,p_name,p_cnt, to_char(p_regdate,'YYYY-MM-DD') as p_regdate 
FROM I_PRODUCT;

SELECT
    p_no, p_name, p_cnt, p_regdate
FROM I_PRODUCT
where P_NO = 1;

SELECT
   i.i_no, p.p_name, i.I_CNT, i.I_DATE
FROM I_PRODUCT p
left join I_IMPORT i 
ON p.p_no = i.p_no
GROUP BY i.i_no, p.p_name, i.I_CNT, i.I_DATE 
ORDER by i.I_NO;


SELECT
    e.E_NO, p.P_NAME, e.E_CNT, e.E_DATE
FROM I_PRODUCT p left join I_EXPORT e on p.P_NO = e.P_NO
ORDER by e_no desc;





