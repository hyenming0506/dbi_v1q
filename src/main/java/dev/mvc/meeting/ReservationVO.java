package dev.mvc.meeting;

public class ReservationVO {
/*
  CREATE TABLE reservation(
      reservationno INT NOT NULL AUTO_INCREMENT PRIMARY KEY,  예약 번호 
      lend INT NOT NULL,                                      대여시작시간 
      addtables INT NULL,                                     추가 테이블 수
      addchair INT NULL,                                      추가 의자 수
      beam BOOLEAN,                                           프로젝트빔 추가
      whiteboard BOOLEAN,                                     화이트보드 추가
      reservationday DATE NOT NULL,                           예약날짜 
      roomno INT,                                             회의실 번호 
      id VARCHAR(20),                                         회원 아이디 
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