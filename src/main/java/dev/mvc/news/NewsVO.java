package dev.mvc.news;

public class NewsVO {
  /*
   * CREATE TABLE news(
    newsno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(60) NOT NULL,
    content VARCHAR(6000) NOT NULL,
    id VARCHAR(20) NOT NULL,
    auth VARCHAR(3) NOT NULL,
    cnt INT DEFAULT 0 NOT NULL,
    good INT DEFAULT 0 NOT NULL,
    rdate DATETIME NOT NULL
);
   */
  
  private int newsno;
  private String title;
  private String content;
  private String id;
  private int cnt;
  private int good;
  private String rdate;
  
  
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
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
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
  
  
}
