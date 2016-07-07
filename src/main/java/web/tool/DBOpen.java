package web.tool;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBOpen {
  // MySQL, Oracle
  // Method는 문자나 숫자뿐만 아니라 클래스의 객체도 생성하여 리턴 가능
  public Connection getConnection() {
    Connection con = null;
    
    String jdbc = "org.gjt.mm.mysql.Driver"; // MySQL 연결 Drvier
    String url = "jdbc:mysql://localhost:3306/web?useUnicode=true&characterEncoding=euckr";
    String user = "root";
    String pass = "1234";
    try {
      Class.forName(jdbc); // memory로 드라이버 클래스를 로딩함.
      con = DriverManager.getConnection(url, user, pass); // MySQL 연결
    } catch (Exception e) {
      e.printStackTrace();
    }
    return con;
  }
}