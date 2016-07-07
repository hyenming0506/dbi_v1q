package dev.mvc.meeting;

public class RoomVO {
 
/*  
CREATE TABLE room(
    roomno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    roomname VARCHAR(10) NOT NULL,
    size VARCHAR(10) NOT NULL,
    tables INT NOT NULL,
    chair INT NOT NULL,
    img VARCHAR(100),
    maxpeople INT NOT NULL
);
*/
 
  private int roomno;
  private String roomname;
  private String size;
  private int tables;
  private int chair;
  private String img;
  private int maxpeople;
  public int getRoomno() {
    return roomno;
  }
  public void setRoomno(int roomno) {
    this.roomno = roomno;
  }
  public String getRoomname() {
    return roomname;
  }
  public void setRoomname(String roomname) {
    this.roomname = roomname;
  }
  public String getSize() {
    return size;
  }
  public void setSize(String size) {
    this.size = size;
  }
  public int getTables() {
    return tables;
  }
  public void setTables(int tables) {
    this.tables = tables;
  }
  public int getChair() {
    return chair;
  }
  public void setChair(int chair) {
    this.chair = chair;
  }
  public String getImg() {
    return img;
  }
  public void setImg(String img) {
    this.img = img;
  }
  public int getMaxpeople() {
    return maxpeople;
  }
  public void setMaxpeople(int maxpeople) {
    this.maxpeople = maxpeople;
  }
  
}