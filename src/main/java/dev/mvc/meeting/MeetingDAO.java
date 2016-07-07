package dev.mvc.meeting;
 
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository("dev.mvc.meeting.MeetingDAO")
public class MeetingDAO implements MeetingInter{
  @Autowired
  private SqlSession sqlSession; // MyBATIS 3 ¿¬°á °´Ã¼
  
  public MeetingDAO(){
    System.out.println("--> MeetingDAO created.");
  }
  
  public MeetingInter mapper(){
    MeetingInter mapper = sqlSession.getMapper(MeetingInter.class);    
    
    return mapper;
  }
  
  @Override
  public ArrayList<RoomVO> list() {
    return mapper().list();
  }

  @Override
  public RoomVO read(int roomno) {
    return mapper().read(roomno);
  }

  @Override
  public String read1(int roomno) {
    return mapper().read1(roomno);
  }

  @Override
  public int read2(int roomno) {
    return mapper().read2(roomno);
  }

  @Override
  public int read3(int roomno) {
    return mapper().read3(roomno);
  }

  @Override
  public int read4(int roomno) {
    return mapper().read4(roomno);
  }

  @Override
  public String read5(int roomno) {
    return mapper().read5(roomno);
  }
}