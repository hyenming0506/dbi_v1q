package dev.mvc.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.mvc.dbi.DbiInter;


@Repository("dev.mvc.member.MemberDAO")
public class MemberDAO implements DbiInter{

  
  @Autowired
  private SqlSession sqlSession; // MyBATIS 3 ¿¬°á °´Ã¼
  
  public DbiInter mapper(){
    DbiInter mapper = sqlSession.getMapper(DbiInter.class);    
    
    return mapper;
  }
  
  @Override
  public int create(MemberVO vo) {
    return mapper().create(vo);
  }

}
