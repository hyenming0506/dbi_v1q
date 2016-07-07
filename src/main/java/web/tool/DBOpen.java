package web.tool;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBOpen {
  // MySQL, Oracle
  // Method�� ���ڳ� ���ڻӸ� �ƴ϶� Ŭ������ ��ü�� �����Ͽ� ���� ����
  public Connection getConnection() {
    Connection con = null;
    
    String jdbc = "org.gjt.mm.mysql.Driver"; // MySQL ���� Drvier
    String url = "jdbc:mysql://localhost:3306/web?useUnicode=true&characterEncoding=euckr";
    String user = "root";
    String pass = "1234";
    try {
      Class.forName(jdbc); // memory�� ����̹� Ŭ������ �ε���.
      con = DriverManager.getConnection(url, user, pass); // MySQL ����
    } catch (Exception e) {
      e.printStackTrace();
    }
    return con;
  }
}