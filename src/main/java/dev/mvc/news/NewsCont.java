package dev.mvc.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class NewsCont {
  @Autowired
  @Qualifier("dev.mvc.news.NewsDAO")
  private NewsDAO newsDAO;
  
  public NewsCont(){
    System.out.println("-------> NewsCont created.....");
  }
  
  
  
}




