CREATE TABLE member(
    empno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ename VARCHAR(20) NOT NULL,
    gender VARCHAR(5) NOT NULL,
    age INT NOT NULL,
    address VARCHAR(100) NOT NULL,
    zipcode VARCHAR(10) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(30) NOT NULL
);

-- 레코드 삽입
INSERT INTO member(ename, gender, age, address, zipcode, phone, email)
VALUE('헨', 'W', 23, '경기도 부천시 오정구 원종동 211-1 현대아파트 나동 201호', '10234', '01077777777', 'gpdnjs@naver.com');

-- 전체 조회
SELECT empno, ename, gender, age, address, zipcode, phone, email FROM member;



drop table member;
desc member;
