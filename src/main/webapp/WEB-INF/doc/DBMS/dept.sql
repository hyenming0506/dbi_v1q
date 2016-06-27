-- 테이블 생성
CREATE TABLE dept(
    deptno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dname VARCHAR(20) NOT NULL
);



INSERT INTO dept(dname) values('웹개발');
INSERT INTO dept(dname) values('인사팀');
INSERT INTO dept(dname) values('회계팀');
INSERT INTO dept(dname) values('보안팀');
INSERT INTO dept(dname) values('영업팀');


-- 전체 목록 검색
SELECT deptno, dname FROM dept

drop table dept;

desc dept