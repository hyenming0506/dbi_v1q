package dev.mvc.news;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import web.tool.Tool;
import web.tool.Upload;


@Controller
public class NewsCont {
  @Autowired
  @Qualifier("dev.mvc.news.NewsDAO")
  private NewsDAO newsDAO;
  
  public NewsCont(){
    System.out.println("-------> NewsCont created.....");
  }
  
  @RequestMapping(value = "/news/create.do", method = RequestMethod.GET)
  public ModelAndView create(NewsVO newsVO) {
    // System.out.println("--> create() GET called.");
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/news/create"); // /webapp/news/create.jsp

    mav.addObject("newsVO", newsVO);
    return mav;
  }
  
  @RequestMapping(value = "/news/create.do", method = RequestMethod.POST)
  public ModelAndView create_proc(NewsVO newsVO, HttpServletRequest request) {
    // System.out.println("--> create() POST called.");
       ModelAndView mav = new ModelAndView();
       mav.setViewName("/news/message");
       
       String file1 = "";

       ArrayList<String> msgs = new ArrayList<String>();
       ArrayList<String> links = new ArrayList<String>();

//-------------------------------------------------------------------
//파일 전송
//-------------------------------------------------------------------
       String file2 = "";
       String upDir = Tool.getRealPath(request, "/news/storage");
       MultipartFile file2MF = newsVO.getFile2MF();
         if (file2MF.getSize() > 0){
           file2 = Upload.saveFileSpring(file2MF, upDir);
           newsVO.setFile2(file2); // 전송된 파일명 저장
         }
       newsVO.setFile2(file2);
//-------------------------------------------------------------------

//-------------------------------------------------------------------
//Thumb 파일 생성
//-------------------------------------------------------------------
       if(Tool.isImage(file2)){
       file1 = Tool.preview(upDir, file2, 200, 150);
       }else{
         file1 = "";
       }
       newsVO.setFile1(file1);
//-------------------------------------------------------------------
       newsVO.setAuth("M");// 회원 연동시 변경
       if (newsDAO.create(newsVO) == 1) {
         //newsDAO.increaseCnt(newsVO.getBlogcategoryno());
         msgs.add("글을 등록했습니다.");
         links.add("<button type='button' onclick=\"location.href='./create.do'\">계속 등록</button>");
       } else {
         msgs.add("글 등록에 실패했습니다.");
         msgs.add("다시 시도해주세요.");
         links.add("<button type='button' onclick=\"history.back()\">다시시도</button>");
       }

       links.add("<button type='button' onclick=\"location.href='./home.do'\">홈페이지</button>");
       links.add("<button type='button' onclick=\"location.href='./list.do'\">목록</button>");
//       links.add("<button type='button' onclick=\"location.href='./list.do?blogcategoryno="+blogVO.getBlogcategoryno()+"'\">목록</button>");
       mav.addObject("msgs", msgs);
       mav.addObject("links", links);

       return mav;
}
  
  
  
  
  
  
}




