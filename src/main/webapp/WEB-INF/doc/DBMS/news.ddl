DROP TABLE news IF EXISTS;

/**********************************/
/* Table Name: 사내 소식 */
/**********************************/
CREATE TABLE news(
		newsno INT NOT NULL IDENTITY PRIMARY KEY,
		title VARCHAR(60) NOT NULL,
		content VARCHAR(6000) NOT NULL,
		ename VARCHAR(20) NOT NULL,
		auth VARCHAR(3) NOT NULL,
		file1 VARCHAR(70),
		file2 VARCHAR(70),
		size2 INT,
		cnt INT DEFAULT 0 NOT NULL,
		good INT DEFAULT 0 NOT NULL,
		rdate DATETIME NOT NULL
);

