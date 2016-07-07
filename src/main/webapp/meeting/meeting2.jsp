<%@page import="java.time.Year"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Calendar"%>
<%@page import="web.calender.*"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/JavaScript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="./js/calendar.js"></script>
<link href="css/style.css" rel="Stylesheet" type="text/css">
<link href="css/calender.css" rel="Stylesheet" type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet">

<script type="text/javascript">
  $(function() {

  });
</script>
</head>
<!-- ----------------------------------------- -->
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
					<li class="active"><a href="list.do">회의실 예약현황</a></li>
				</ol>
			</div>
		</div>
		<table class='table'>
		  <tr>
		    <td>회의실 이름</td>
		    <td>회의실 대여일&시간</td>
		    <td>회의실 크기</td>
		    <td>테이블 수</td>
		    <td>의자 수</td>
		    <td>프로젝트빔</td>
		    <td>화이트보드</td>
		    <td>최대수용인원</td>
		    <td>예약한 날짜</td>
		    <td>삭제</td>
		  </tr>
		  <tr>
        <td> A회의실</td>
        <td>2016/07/04/09:00~09:50</td>
        <td>300X300 m</td>
        <td>3</td>
        <td>12</td>
        <td>추가</td>
        <td>추가</td>
        <td>16</td>
        <td>2016/07/01/15:35</td>
        <td><button type="button"onclick="window.confirm('지금 예약취소하시면 되돌릴 수 없습니다. 정말 취소하시겠습니까? ');">예약취소</button></td>
      </tr>
		</table>
	</div>
  
	<hr>
	<!-- /.container -->

</body>
<!-- -------------------------------------------- -->
</html>
