DROP TABLE news;

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

-- 등록

INSERT INTO news(title, content, id, auth, cnt, good, rdate)
VALUES('제목', '내용', 'user', 'M', 0, 0, now());

INSERT INTO news(title, content, id, auth, cnt, good, rdate)
VALUES('제목2', '내용2', 'user', 'E', 0, 0, now());

INSERT INTO news(title, content, id, auth, cnt, good, rdate)
VALUES('제목3', '내용3', 'user', 'E', 0, 0, now());

-- 조회

SELECT newsno, title, content, id, auth, cnt, good, rdate
FROM news;
