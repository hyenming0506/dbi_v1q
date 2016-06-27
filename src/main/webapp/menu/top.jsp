<%@ page contentType="text/html; charset=UTF-8"%>
<!-- 화면 상단 메뉴 -->
<%
  String root = request.getContextPath(); //프로젝트 경로
  //out.println("root:"+root);
%>
<DIV id="top_Menu"
  style="background-position:center bottom;
      background-image:url('<%=root%>/menu/images/top_image.jpg');
      background-size:100% 100%;">
  <div class='top_menu_label'>Coffee Blog 0.6</div>
  <nav class='top_menu_list'>
  </nav>
</DIV>
