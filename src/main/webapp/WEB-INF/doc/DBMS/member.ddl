DROP TABLE account IF EXISTS;
DROP TABLE dept IF EXISTS;
DROP TABLE member IF EXISTS;

/**********************************/
/* Table Name: ���(ȸ��) */
/**********************************/
CREATE TABLE member(
		empno INT NOT NULL IDENTITY PRIMARY KEY,
		ename VARCHAR(20) NOT NULL,
		gender VARCHAR(5) NOT NULL,
		age INT NOT NULL,
		address VARCHAR(100) NOT NULL,
		zipcode VARCHAR(10) NOT NULL,
		phone VARCHAR(20) NOT NULL,
		email VARCHAR(30) NOT NULL
);

/**********************************/
/* Table Name: �μ� */
/**********************************/
CREATE TABLE dept(
		deptno INT NOT NULL IDENTITY PRIMARY KEY,
		dname VARCHAR(20) NOT NULL,
		position VARCHAR(10) NOT NULL,
		empno INT,
  FOREIGN KEY (empno) REFERENCES member (empno)
);

/**********************************/
/* Table Name: ���� */
/**********************************/
CREATE TABLE account(
		accno INT NOT NULL IDENTITY PRIMARY KEY,
		id VARCHAR(20) NOT NULL,
		passwd VARCHAR(15) NOT NULL,
		auth VARCHAR(3) DEFAULT 'E' NOT NULL,
		empno INT,
  FOREIGN KEY (empno) REFERENCES member (empno)
);

