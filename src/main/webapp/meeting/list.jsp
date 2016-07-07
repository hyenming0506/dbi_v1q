<%@page import="java.util.*"%>
<%@page import="web.tool.*"%>
<%@page import="java.time.Year"%>
<%@page import="dev.mvc.meeting.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/JavaScript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="./js/calendar.js"></script>
<script type="text/javascript" src="../js/tool.js"></script>
<link href="css/style.css" rel="Stylesheet" type="text/css">
<link href="css/calender.css" rel="Stylesheet" type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript">

function send(){
  
  var params = 'roomno=' + $('#sele').val();
  
  // 요청 주소, 전달 값, 응답 처리 함수, 전송 받는 형식
  $.post('./list2.do', params, send_res, 'json');
}

function send_res(data){
  if(data.read1 != 0){
    $('#panel_id1').css('color', '#00AA00');
    $('#panel_id1').html('회의실 크기 = '+data.read1);
    $('#panel_id2').css('color', '#00AA00');
    $('#panel_id2').html('테이블 수 = '+data.read2);
    $('#panel_id3').css('color', '#00AA00');
    $('#panel_id3').html('의자 수 = '+data.read3);
    $('#panel_id4').css('color', '#00AA00');
    $('#panel_id4').html('최대수용인원 = '+ data.read4 + '<br>');
    $('#panel_id5').html('<img class="img-responsive img-hover" height="350" width="400" src="'+data.read5 +'">');
  }
}

</script>
</head>

<body>


	<!-- Page Content -->
	<div class="container">
		<!-- Page Heading/Breadcrumbs -->
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					회의실예약 <small>예약현황</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="index.html">Home</a></li>
					<li class="active"><a href="meeting2.jsp">나의 예약현황/삭제</a></li>
				</ol>
			</div>
		</div>
		<!-- /.row -->
    
		<!-- Project One -->			
	<% Tool tool = new Tool();
    myCal C = new myCal();
    GregorianCalendar today = new GregorianCalendar();
    Calendar thisCal;
    
    int year =  request.getParameter("year") == null ? today.get(Calendar.YEAR) : Integer.parseInt(request.getParameter("year"));
    int month = request.getParameter("month") == null ? today.get(Calendar.MONTH) : (Integer.parseInt(request.getParameter("month")));
    
    int today_date = today.get(Calendar.DATE);
    int prevYear = year;
    int prevMonth = (month) - 1;
    int nextYear = year;
    int nextMonth = (month) + 1;

    
    // 1월인 경우 이전년 12월로 지정
    if (prevMonth < 1) {
        prevYear--;
        prevMonth = 12;
    }

    // 12월인 경우 다음년 1월로 지정
    if (nextMonth > 12) {
        nextYear++;
        nextMonth = 1;
    }
    
    today.set(year, month, 1);
    int first_day = today.get(Calendar.DAY_OF_WEEK);

    String s_date = String.valueOf(year) + "-"
        + String.valueOf(month + 1) + "-"
        + String.valueOf(today_date);
  %>
 
    <div class="calendar">
      <header>
          <span class="month">
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <a href="./list.do?year=<%=prevYear%>&month=<%=prevMonth%>&day=<%=1%>">◁</a>
          <%=year%>          <%=C.getMonthName()[month-1]%>
          <a href="./list.do?year=<%=nextYear%>&month=<%=nextMonth%>&day=<%=1%>">▷</a>
        </span>
        <!--  <span class="back"><a href="" ></a></span>  -->
        
        <!--  <span class="next"></span> -->
      </header>
      <div class="days">
        <span>S</span> <span>M</span> <span>T</span> <span>W</span> <span>T</span>
        <span>F</span> <span>S</span>
      </div>
      <div class="dates">
        <%
          //이달의 마지막 날
          int lastday = today.getActualMaximum(Calendar.DATE);
          int week = first_day; //first_day 
          int sibal_week = first_day;
          for (int i = 0; i < week; i++){
            
          }
          for (int i = 1; i <= lastday; i++) {
            week++;
            if (week % 7 == 1){
            }
          }
          for (int i = 1; i < sibal_week; i++) {
        %><span class="disable"></span>
        <%
          }
        %>
        <%
          for (int i = 1; i <= lastday; i++) {
            if (today_date == i) {
        %>
        <span class="active">
        <a onclick="window.open('./calendar/list.jsp?year=<%=year%>&month=<%=month + 1%>&day=<%=i%>', '', 'width=700, height=630'); return false;"
          href="blog_v1jq/calendar/create_form.jsp"><%=today_date%></a></span>
        <%
          } else {
        %>
        <span>
        <a class="none" onclick="window.open('./calendar/list.jsp?year=<%=year%>&month=<%=month + 1%>&day=<%=i%>', '', 'width=700, height=630'); return false;"
          href="./calendar/create_form.jsp"><%=i%></a></span>
        <%
          }
            sibal_week++;

          }
        %>
      </div>
    </div>

			
			<table>
				<tr>
					<td>
					<SPAN id='panel_id5'></SPAN>
					 <!-- <img class="img-responsive img-hover" height="400" width="320" src="./images/welcome1.jpg" alt=""> -->
					</td>
					<td>
					 <table>
					  <tr>
					   <td>
					     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;사용시간
					   </td>
					   <td>
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;예약
             </td>
             <td>
               &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;옵션
             </td>
					  </tr>
					  <tr>
					  </tr>
            <tr>
							<td class="time full">
							 <h5>&nbsp;&nbsp;&nbsp;09:00 ~ 09:50&nbsp;&nbsp;&nbsp;</h5>
							</td>
							<td class="name full"> <!-- "disabled" 라디오버튼 비활성화 -->
							 
							 <a class="btn btn-primary">예약<input type='radio' name='license' value='y' <%=tool.optionradio(9)%>></a>
							</td>
							<td>
							&nbsp;&nbsp;&nbsp;의자 추가 
							</td>
							</tr>
              <tr>
							<td class="time full">
							 <h5>&nbsp;&nbsp;&nbsp;10:00 ~ 10:50</h5>
							</td>
							<td class="name full">
							 <a class="btn btn-primary">예약<input type='radio' name='license' value='y'<%=tool.optionradio(10)%>></a>
							</td>
							<td>
							&nbsp;&nbsp;&nbsp;<input type="number" value="0" step="1" min="0" max="10" size= 10>개
							</td>
							</tr>
              <tr>
							<td class="time full">
							 <h5>&nbsp;&nbsp;&nbsp;11:00 ~ 11:50</h5>
							</td>
							<td class="name full">
							 <a class="btn btn-primary">예약<input type='radio' name='license' value='y'<%=tool.optionradio(11)%>></a>
							</td>
							<td>
							&nbsp;&nbsp;&nbsp;테이블 추가
							</td>
							</tr>
              <tr>
							<td class="time full">
							 <h5>&nbsp;&nbsp;&nbsp;13:00 ~ 13:50</h5>
							</td>
							<td class="name full">
							 <a class="btn btn-primary">예약<input type='radio' name='license' value='y'<%=tool.optionradio(13)%>></a>
							</td>
							<td>
							&nbsp;&nbsp;&nbsp;<input type="number" value="0" step="1" min="0" max="3">개
              </td>
							</tr>
              <tr>
							<td class="time full">
							 <h5>&nbsp;&nbsp;&nbsp;14:00 ~ 14:50</h5>
							</td>
							<td class="name full">
							 <a class="btn btn-primary">예약<input type='radio' name='license' value='y'<%=tool.optionradio(14)%>></a>
							</td>
							<td>
							&nbsp;&nbsp;&nbsp;프로젝트빔 <input type="checkbox" value='y'>
							</td>
							</tr>
              <tr>
							<td class="time full">
							 <h5>&nbsp;&nbsp;&nbsp;15:00 ~ 15:50</h5>
							</td>
							<td class="name full">
							 <a class="btn btn-primary">예약<input type='radio' name='license' value='y'<%=tool.optionradio(15)%>></a>
							</td>
							<td>
              &nbsp;&nbsp;&nbsp;화이트 보드 <input type="checkbox" value='y'>
              </td>
							</tr>
              <tr>
							<td class="time full">
							 <h5>&nbsp;&nbsp;&nbsp;16:00 ~ 16:50</h5>
							</td>
							<td class="name full">
							 <a class="btn btn-primary">예약<input type='radio' name='license' value='y'<%=tool.optionradio(16)%>></a>
							</td>
							<td>
							&nbsp;&nbsp;&nbsp;<button type="submit" onclick="window.confirm('OOO님 2016/07/08 09:00~09:50 A회의실 대관을 신청하시겠습니까?');">예약</button>
							</td>
							</tr>
              <tr>
							<td class="time full">
							 <h5>&nbsp;&nbsp;&nbsp;17:00 ~ 17:50</h5>
							</td>
							<td class="name full">
							 <a class="btn btn-primary">예약<input type='radio' name='license' value='y'<%=tool.optionradio(17)%>></a>
							</td>
							<td>
              &nbsp;&nbsp;&nbsp;<button type="reset">취소</button>
              </td>
						 </tr>
						</table>
					</td>
				</tr>
				<tr>
				  <td>
				    <form id='frm' name='frm' method="post" action="./list2.do" onchange="send()">
				    <select style="width: 400px; height: 45px" name='sele' id='sele'>
				        <option selected> </option>
				      <c:forEach var="vo" items="${list}">
				        <option value='${vo.roomno}'>
				          ${vo.roomname}
				        </option>
              </c:forEach>
				    </select>
				    </form>
          </td>
				  <td>
				  <p style="text-align: center;">
          <SPAN id='panel_id1'></SPAN>
          <SPAN id='panel_id4'></SPAN>
          <SPAN id='panel_id2'></SPAN>
          <SPAN id='panel_id3'></SPAN>
          </p>
				  </td> 
				</tr>
			</table>
			<div>
       </div>
		</div>
	<!-- /.container -->
	<br><br><br><br><br><br><br>
	<hr>
</body>
<!-- -------------------------------------------- -->
</html>
