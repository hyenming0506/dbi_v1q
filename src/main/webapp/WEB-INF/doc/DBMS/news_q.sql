DROP TABLE news;

CREATE TABLE news(
    newsno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
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


-- 등록

INSERT INTO news(title, content, ename, auth, file1, file2, size2, cnt, good, rdate)
VALUES('제목1', '내용1', '관리자', 'M', 'file1', 'file2', 0, 0, 0, now());


-- 조회

SELECT newsno, title, content, ename, auth, file1, file2, size2, cnt, good, rdate
FROM news
ORDER BY newsno DESC;
 newsno title content ename auth file1 file2 size2 cnt good rdate
 ------ ----- ------- ----- ---- ----- ----- ----- --- ---- ---------------------
      1 ㅁ     ㅁ       최성재   M                    0   0    0 2016-06-30 17:29:38.0
      2 ㅁ     ㅁ       최성재   M                    0   0    0 2016-06-30 17:31:30.0
      3 ㅁ     ㅁ       최성재   M                    0   0    0 2016-06-30 17:31:30.0



