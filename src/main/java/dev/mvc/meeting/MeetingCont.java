package dev.mvc.meeting;

import java.util.Locale;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MeetingCont {
  
  @Autowired
  @Qualifier("dev.mvc.meeting.MeetingDAO")
  private MeetingDAO meetingDAO;

  public MeetingCont() {
    System.out.println("--> MeetingCont created.");
  }

  @RequestMapping(value = "/meeting/list.do", method = RequestMethod.GET)
  public ModelAndView list() { // int roomno
    ModelAndView mav = new ModelAndView();
    mav.setViewName("/meeting/list"); // /meeting/list.jsp
    mav.addObject("list", meetingDAO.list());
    //mav.addObject("list", meetingDAO.read(roomno));

    return mav;
  }
  
  @ResponseBody
  @RequestMapping(value = "/meeting/list2.do", 
                  method = RequestMethod.POST, 
                  produces = "text/plain;charset=UTF-8")
  public String list2(int roomno, Locale locale, Model model) {
    JSONObject obj = new JSONObject();
    System.out.println("--> start list2.do");
    System.out.println(roomno);
    
    //size, tables, chair, maxpeople, img
    String size = meetingDAO.read1(roomno);
    int tables = meetingDAO.read2(roomno);
    int chair = meetingDAO.read3(roomno);
    int maxpeople = meetingDAO.read4(roomno);
    String img = meetingDAO.read5(roomno);
    
    obj.put("read1", size); // js 에서만 사용 가능
    obj.put("read2", tables); // js 에서만 사용 가능
    obj.put("read3", chair); // js 에서만 사용 가능
    obj.put("read4", maxpeople); // js 에서만 사용 가능
    obj.put("read5", img); // js 에서만 사용 가능
 
    return obj.toJSONString();

  }
  
}