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

-- ���ڵ� ����
INSERT INTO member(ename, gender, age, address, zipcode, phone, email)
VALUE('��', 'W', 23, '��⵵ ��õ�� ������ ������ 211-1 �������Ʈ ���� 201ȣ', '10234', '01077777777', 'gpdnjs@naver.com');

-- ��ü ��ȸ
SELECT empno, ename, gender, age, address, zipcode, phone, email FROM member;



drop table member;
desc member;