-- ���̺� ����
CREATE TABLE dept(
    deptno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dname VARCHAR(20) NOT NULL
);



INSERT INTO dept(dname) values('������');
INSERT INTO dept(dname) values('�λ���');
INSERT INTO dept(dname) values('ȸ����');
INSERT INTO dept(dname) values('������');
INSERT INTO dept(dname) values('������');


-- ��ü ��� �˻�
SELECT deptno, dname FROM dept

drop table dept;

desc dept