package dev.mvc.meeting;

public class ReservationVO {
/*
  CREATE TABLE reservation(
      reservationno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,  ���� ��ȣ 
      lend INT NOT NULL,                                      �뿩���۽ð� 
      addtables INT NULL,                                     �߰� ���̺� ��
      addchair INT NULL,                                      �߰� ���� ��
      beam BOOLEAN,                                           ������Ʈ�� �߰�
      whiteboard BOOLEAN,                                     ȭ��Ʈ���� �߰�
      reservationday DATE NOT NULL,                           ���೯¥ 
      roomno INT,                                             ȸ�ǽ� ��ȣ 
      id VARCHAR(20),                                         ȸ�� ���̵� 
        FOREIGN KEY (roomno) REFERENCES councilroom (roomno),
        FOREIGN KEY (id) REFERENCES account (id)
      );
*/
  private int reservationno;
  private int lend;
  private int addtables;
  private int addchair;
  private boolean beam;
  private boolean whiteboard;
  private String reservationday;
  
  private int roomno;
  private String id;
  public int getReservationno() {
    return reservationno;
  }
  public void setReservationno(int reservationno) {
    this.reservationno = reservationno;
  }
  public int getLend() {
    return lend;
  }
  public void setLend(int lend) {
    this.lend = lend;
  }
  public int getAddtables() {
    return addtables;
  }
  public void setAddtables(int addtables) {
    this.addtables = addtables;
  }
  public int getAddchair() {
    return addchair;
  }
  public void setAddchair(int addchair) {
    this.addchair = addchair;
  }
  public boolean isBeam() {
    return beam;
  }
  public void setBeam(boolean beam) {
    this.beam = beam;
  }
  public boolean isWhiteboard() {
    return whiteboard;
  }
  public void setWhiteboard(boolean whiteboard) {
    this.whiteboard = whiteboard;
  }
  public String getReservationday() {
    return reservationday;
  }
  public void setReservationday(String reservationday) {
    this.reservationday = reservationday;
  }
  public int getRoomno() {
    return roomno;
  }
  public void setRoomno(int roomno) {
    this.roomno = roomno;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
}