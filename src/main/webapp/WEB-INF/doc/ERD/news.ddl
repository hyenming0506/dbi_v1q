DROP TABLE news IF EXISTS;

/**********************************/
/* Table Name: 사내 소식 */
/**********************************/
CREATE TABLE news(
		newsno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
		title VARCHAR(60) NOT NULL,
		content VARCHAR(6000) NOT NULL,
		id VARCHAR(20) NOT NULL,
		auth VARCHAR(3) NOT NULL,
		cnt INT DEFAULT 0 NOT NULL,
		good INT DEFAULT 0 NOT NULL,
		rdate DATETIME NOT NULL
);

