CREATE TABLE dept(
    deptno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    dname VARCHAR(20) NOT NULL,
    position VARCHAR(10) NOT NULL,
    empno INT,
  FOREIGN KEY (empno) REFERENCES member (empno)
);

INSERT INTO dept(dname, position, empno)
VALUE('웹 개발', '주임', 1)