package dev.mvc.meeting;

import java.util.ArrayList;

public interface MeetingInter {
  
  //<select id="list" resultType="RoomVO">
  public ArrayList<RoomVO> list();
  
  //<select id="read" resultType="RoomVO" parameterType="int">
  public RoomVO read(int roomno);
  
  public String read1(int roomno);
  public int read2(int roomno);
  public int read3(int roomno);
  public int read4(int roomno);
  public String read5(int roomno);
  
}