-- 테이블 생성
CREATE TABLE account(
    accno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id VARCHAR(20) NOT NULL,
    passwd VARCHAR(15) NOT NULL,
    auth VARCHAR(3) DEFAULT 'E' NOT NULL
);

INSERT INTO account(id, passwd, auth)
VALUES('gpdnjs0420', '1234', 'A')

SELECT accno, id, passwd, auth FROM account


-- 테이블 구조확인
DESC account