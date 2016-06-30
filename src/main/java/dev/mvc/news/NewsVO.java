package dev.mvc.news;

import org.springframework.web.multipart.MultipartFile;

public class NewsVO {
  /*
   *
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

   */
  
  /* 사내 소식 번호 */
  private int newsno;
  /* 제목 */
  private String title;
  /* 내용 */
  private String content;
  /* 사원 이름 */
  private String ename;
  /* 권한 */
  private String auth;
  /* 썸네일 파일 */
  private String file1;
  /* 업로드된 파일 */
  private String file2;
  /* 업로드된 파일 사이즈 */
  private int size2;
  /* 조회수 */
  private int cnt;
  /* 추천수 */
  private int good;
  /* 시간 */
  private String rdate;
  /* Framework에서 자동 주입되는 파일 객체 */
  private MultipartFile file2MF;
  
  
  public int getNewsno() {
    return newsno;
  }
  public void setNewsno(int newsno) {
    this.newsno = newsno;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public String getEname() {
    return ename;
  }
  public void setEname(String ename) {
    this.ename = ename;
  }
  public String getAuth() {
    return auth;
  }
  public void setAuth(String auth) {
    this.auth = auth;
  }
  public String getFile1() {
    return file1;
  }
  public void setFile1(String file1) {
    this.file1 = file1;
  }
  public String getFile2() {
    return file2;
  }
  public void setFile2(String file2) {
    this.file2 = file2;
  }
  public int getSize2() {
    return size2;
  }
  public void setSize2(int size2) {
    this.size2 = size2;
  }
  public int getCnt() {
    return cnt;
  }
  public void setCnt(int cnt) {
    this.cnt = cnt;
  }
  public int getGood() {
    return good;
  }
  public void setGood(int good) {
    this.good = good;
  }
  public String getRdate() {
    return rdate;
  }
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  public MultipartFile getFile2MF() {
    return file2MF;
  }
  public void setFile2MF(MultipartFile file2mf) {
    file2MF = file2mf;
  }
  
  
  
}
