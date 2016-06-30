<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
 
 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
<script type="text/JavaScript"
          src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.cookie.js"></script>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>

<script type="text/javascript" src="../js/tool.js"></script>
 
<script type="text/JavaScript">
  window.onload=function(){
    CKEDITOR.replace('content');  // <TEXTAREA>태그 id 값
  };
</script>
 
</head> 
<!-- ----------------------------------------- -->
<body leftmargin="0" topmargin="0">
<jsp:include page="/menu/top.jsp" flush='false' />
<!-- ----------------------------------------- -->
 
<DIV class='title'>사내 소식 등록</DIV>
 
<DIV class='content' style='width: 90%;'>
  <FORM name='frm' method='POST' action='./create.do'
              enctype="multipart/form-data">
    <input type='hidden' name='newsno' id='newno' value='${newsVO.newsno }'>
      <ul>
      <li>
        <label class='label' for='title'>제목</label>
        <input type='text' name='title' id='title' value='' size='60' required="required">
      </li>
      <li>
        <label class='label' for='content'>내용</label>
        <textarea name='content' id='content'  rows='5' cols='70'></textarea>
      </li>
      <li>
        <label class='label' for='ename'>이름</label>
        <input type='text' name='ename' id='ename' value='최성재' size='20' required="required">
      </li>
      <li>
        <label class='label' for='file1'>Thumb 파일</label>
        Preview(미리보기) 이미지 자동 생성됩니다.
      </li>
      
      <li>
        <label class='label' for='file2MF'>업로드 파일</label>
        <input type="file" name='file2MF' id='file2MF' size='40' >
      </li>
      <li class='right'>
        <button type="submit">등록</button>
        <button type="button" onclick="location.href='./list2.do?blogcategoryno=${blogVO.blogcategoryno }'">목록</button>
      </li>         
    </ul>
  </FORM>
</DIV>
 
<!-- -------------------------------------------- -->
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
<!-- -------------------------------------------- -->
</html> 