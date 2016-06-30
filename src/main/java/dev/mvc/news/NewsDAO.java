package dev.mvc.news;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dev.mvc.news.NewsDAO")
public class NewsDAO implements NewsInter{
  @Autowired
  private SqlSession sqlSession; // MyBATIS 3 연결 객체
  
  public NewsDAO(){
    System.out.println("----------> NewsDAO created......");
  }
  
  public NewsInter mapper(){
    NewsInter mapper = sqlSession.getMapper(NewsInter.class);    
    
    return mapper;
  }

  @Override
  public int create(NewsVO newsVO) {
    return mapper().create(newsVO);
  }
}
