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
    &nbsp; <a class='menu_link' href="<%=root%>/">HOME</a>&nbsp;|
    <%--(==)<a href="<%=root %>/index.jsp">HOME</a>&nbsp;|&nbsp; --%>
    <%
      if (session.getAttribute("id") == null) {
    %>
    <a class='menuLink' href='<%=root%>/member/login.do'>로그인</a>&nbsp;|
    <%
      } else {
    %>
    <a class='menuLink' href='<%=root%>/member/logout.do'>${id}로그아웃</a>&nbsp;|
    <%
      }
    %>
    <a class='menu_link' href="<%=root%>/notice/list.jsp">Notice</a>&nbsp;|
    <a class='menu_link' href="<%=root%>/news/list.jsp">Coffee News</a>&nbsp;|
    <a class='menu_link' href="<%=root%>/url/list.jsp">Cafe Blog</a>&nbsp;|
    <a class='menu_link' href="<%=root%>/pdsv3/grid.jsp">커피 일러스트</a>&nbsp;|
    <a class='menu_link' href="<%=root%>/about/grid.jsp">카페 탐방</a>&nbsp;|
    <a class='menu_link' href="<%=root%>/intro/list.jsp">소개</a>&nbsp;|
    <%
      if (session.getAttribute("act") == null) {
    %>
    <a class='menu_link' href='<%=root%>/admin1/login_ck_form.jsp'>Admin</a>&nbsp;|
    <a class='menu_link' href='<%=root%>/admin1/create_form.jsp'>가입신청</a>&nbsp;|
    <%
      } else {
    %>
    <a class='menu_link' href='<%=root%>/admin1/logout_proc.jsp'>Logout</a>&nbsp;|
    <a class='menu_link' href='<%=root%>/admin1/list.jsp'>관리자</a>&nbsp;|
    <a class='menu_link' href='<%=root%>/query/query.jsp'>SQL</a>&nbsp;|
    <a class='menu_link' href='<%=root%>/log/list.jsp'>Log</a>&nbsp;|
    <%
      }
    %>
    <a class='menu_link'
      href='http://172.16.7.11:9090/blog_v2jq/mweb/index.jsp'>Mobile</a>&nbsp;
  </nav>
</DIV>
