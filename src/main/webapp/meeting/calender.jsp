<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="web.calender.*" %>
<%
	request.setCharacterEncoding("UTF-8");
%>

<%@ page contentType="text/html; charset=UTF-8"%>
<link href="./css/calender.css" rel="Stylesheet" type="text/css">
<body>
	<%
		myCal C = new myCal();
		Calendar today = Calendar.getInstance();
		Calendar thisCal;

		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH);
		int today_date = today.get(Calendar.DATE);

		today.set(year, month, 1);
		int first_day = today.get(Calendar.DAY_OF_WEEK);

		String s_date = String.valueOf(year) + "-"
				+ String.valueOf(month + 1) + "-"
				+ String.valueOf(today_date);
	%>
	<div>
		<div class="calendar">
			<header>
				<!--  <span class="back"><a href="" ></a></span>  -->
				<span class="month">
					<h1><%=year%></h1>
					<h2><%=C.getMonthName()[month]%>
						<%=today_date%></h2>
				</span>
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
					for (int i = 0; i < week; i++)
						System.out.print(" ");
					for (int i = 1; i <= lastday; i++) {
						System.out.print(i + " ");
						week++;
						if (week % 7 == 1){
							System.out.println();
						}
					}
					System.out.println("시발 위크 : " + sibal_week);
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
	</div>
</body>
