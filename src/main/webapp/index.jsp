<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ include file="./ssi.jsp" %>
<!-- 대문페이지 -->
   
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

    <title>대변인에 오신걸 환영합니다.</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">

    <!-- Custom Fonts -->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="font-awesome/css/font-awesome.min.css" type="text/css">

    <!-- Plugin CSS -->
    <link rel="stylesheet" href="css/magnific-popup.css" type="text/css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/creative.css" type="text/css">
    <style type="text/css">
      .container {
          padding: 80px 120px;
      }
      .person {
          border: 10px solid transparent;
          margin-bottom: 25px;
          width: 80%;
          height: 80%;
          opacity: 0.7;
      }
      .person:hover {
          border-color: #f1f1f1;
      }
      .carousel-inner img {
          -webkit-filter: grayscale(90%);
          filter: grayscale(90%); /* make all photos black and white */
          width: 100%; /* Set width to 100% */
          margin: auto;
      }
      .carousel-caption h3 {
          color: #fff !important;
      }
      @media (max-width: 600px) {
        .carousel-caption {
          display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
        }
      }
      .bg-1 {
          background: #2d2d30;
          color: #bdbdbd;
      }
      .bg-1 h3 {color: #fff;}
      .bg-1 p {font-style: italic;}
      .list-group-item:first-child {
          border-top-right-radius: 0;
          border-top-left-radius: 0;
      }
      .list-group-item:last-child {
          border-bottom-right-radius: 0;
          border-bottom-left-radius: 0;
      }
      .thumbnail {
          padding:0 0 15px 0;
          border: none;
          border-radius: 0;
      }
      .thumbnail p {
          margin-top: 15px;
          color: #555;
      }
      .btn {
          padding: 10px 20px;
          background-color: #333;
          color: #f1f1f1;
          border-radius: 0;
          transition: .2s;
      }
      .btn:hover, .btn:focus {
          border: 1px solid #333;
          background-color: #fff;
          color: #000;
      }
      .modal-header, h4, .close {
          background-color: #333;
          color: #fff !important;
          text-align: center;
          font-size: 30px;
      }
      .modal-header, .modal-body {
          padding: 40px 50px;
      }
    </style>
</head>

<body id="page-top">

    <header>
        <div class="header-content">
            <div class="header-content-inner">
                <h1>WELCOME TO DAEBEUNIN!!!</h1>
                <hr>
                <p>대변인 홈페이지는 로그인이 되어 있어야 사용가능 합니다! 계정이 있으면 로그인을, 계정이 없으시다면 회원가입을 해주세요</p>
               <!--  <a href="#about" class="btn btn-primary btn-xl page-scroll">Find Out More</a> 로그인 창 만들어-->
               <DIV style="margin: 5% auto; text-align: center;">
               <br><br><br><br><br><br><br>
                  ID : <input type="text" name="id" id="id" placeholder="아이디 or 이메일" style="width:20%;">
                  PW : <input type="password" name="passwd" id="passwd" placeholder="비밀번호" style="width:20%;">
                  <button type="submit" style="color: gray">LOGIN</button><br><br>
                <button class="btn btn-primary btn-xl page-scroll" data-toggle="modal" data-target="#myModal">&nbsp; &nbsp; &nbsp; SING UP&nbsp; &nbsp; &nbsp; </button>
               </DIV>
            </div>
        </div>
    </header>
    

    
    
    
    
    
    
 <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    <!-- class="glyphicon glyphicon-shopping-cart" -->
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">×</button>
          <h4><span class="glyphicon glyphicon-lock"></span> SIGN IN </h4>
        </div>
        <div class="modal-body">
          <form role="form">
            <div class="form-group">
              <label for="ename"><span class="glyphicon glyphicon-user"></span> 성명</label>
              <input type="number" class="form-control" id="ename" placeholder="name" name="ename">
            </div>
            <div class="form-group">
              <label for="position"><span class="glyphicon glyphicon-shopping-cart"></span> 직급</label>
              <input type="text" class="form-control" id="position" placeholder="position" name="position">
            </div>
            <div class="form-group">
              <label for='id'><span class="glyphicon glyphicon-user"></span> 아이디</label>
              <input type="text" class="form-control" id="id" placeholder="id"  name='id' required="required">
              <button type='button' onclick="checkId()">중복확인</button>
              <span id='panel_id'></span>
            </div>
            <div class="form-group">
              <label for='passwd'><span class="glyphicon glyphicon-lock"></span> 패스워드</label>
              <input type='password' name='passwd' id='passwd' value='1234' required="required" class="form-control" placeholder="password">
            </div>
            <div class="form-group">
              <label for='passwd_confirm'><span class="glyphicon glyphicon-lock"></span> 패스워드 확인</label>
              <input type='password' name='passwd_confirm' id='passwd_confirm' value='1234' required="required" class="form-control" placeholder="password">
            </div>
            <div class="form-group">
              <label for='email'><span class="glyphicon glyphicon-envelope"></span> 이메일</label>
              <input type="email" name='email' id='email' class="form-control" placeholder="abc@naver.com">
            </div>
            <div class="form-group">
              <label for='phone'><span class="glyphicon glyphicon-phone"></span> 휴대번호</label>
              <input type="tel" name='phone' id='phone' class="form-control" placeholder="01000000000">
            </div>
            <div class="form-group">
               <label for='zipcode'><span class="glyphicon glyphicon-chevron-right"></span> 우편번호</label>
               <input type='text' name='zipcode' id='zipcode' value='' placeholder="우편번호" class="form-control" >
               <input type="button" onclick="DaumPostcode()" value="우편번호 찾기"> 
            </div>
              <div class="form-group">
              <label></label>  
              <!-- ----- DAUM 우편번호 API 시작 ----- -->
               
              <div id="wrap" style="display:none;border:1px solid;width:500px;height:300px;margin:5px 110px;position:relative">
                <img src="//i1.daumcdn.net/localimg/localimages/07/postcode/320/close.png" id="btnFoldWrap" style="cursor:pointer;position:absolute;right:0px;top:-1px;z-index:1" onclick="foldDaumPostcode()" alt="접기 버튼">
              </div>
               
              <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
              <script>
                  // 우편번호 찾기 찾기 화면을 넣을 element
                  var element_wrap = document.getElementById('wrap');
               
                  function foldDaumPostcode() {
                      // iframe을 넣은 element를 안보이게 한다.
                      element_wrap.style.display = 'none';
                  }
               
                  function DaumPostcode() {
                      // 현재 scroll 위치를 저장해놓는다.
                      var currentScroll = Math.max(document.body.scrollTop, document.documentElement.scrollTop);
                      new daum.Postcode({
                          oncomplete: function(data) {
                              // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
               
                              // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                              // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                              var fullAddr = data.address; // 최종 주소 변수
                              var extraAddr = ''; // 조합형 주소 변수
               
                              // 기본 주소가 도로명 타입일때 조합한다.
                              if(data.addressType === 'R'){
                                  //법정동명이 있을 경우 추가한다.
                                  if(data.bname !== ''){
                                      extraAddr += data.bname;
                                  }
                                  // 건물명이 있을 경우 추가한다.
                                  if(data.buildingName !== ''){
                                      extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                                  }
                                  // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                                  fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                              }
               
                              // 우편번호와 주소 정보를 해당 필드에 넣는다.
                              document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
                              document.getElementById('address1').value = fullAddr;
               
                              // iframe을 넣은 element를 안보이게 한다.
                              // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
                              element_wrap.style.display = 'none';
               
                              // 우편번호 찾기 화면이 보이기 이전으로 scroll 위치를 되돌린다.
                              document.body.scrollTop = currentScroll;
                              
                              $('#address2').focus();
                          },
                          // 우편번호 찾기 화면 크기가 조정되었을때 실행할 코드를 작성하는 부분. iframe을 넣은 element의 높이값을 조정한다.
                          onresize : function(size) {
                              element_wrap.style.height = size.height+'px';
                          },
                          width : '100%',
                          height : '100%'
                      }).embed(element_wrap);
               
                      // iframe을 넣은 element를 보이게 한다.
                      element_wrap.style.display = 'block';
                  }
              </script>
              <!-- ----- DAUM 우편번호 API 종료----- -->
            </div> 
            <div class="form-group">
                <label for='zipcode'><span class="glyphicon glyphicon-chevron-right"></span> 주소</label>
                <input type='text' name='address1' id='address1' value='' size='40' placeholder="주소" class="form-control" >  
                <input type='text' name='address2' id='address2' value='' size='15' placeholder="상세 주소" class="form-control" > 
            </div>
              <button type="submit" class="btn btn-block">JOIN
                <span class="glyphicon glyphicon-ok"></span>
              </button>
          </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal">
            <span class="glyphicon glyphicon-remove"></span> Cancel
          </button>
        </div>
      </div>
    </div>
  </div>
    
    
    <!-- jQuery -->
    <script src="js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    <!-- Plugin JavaScript -->
    <script src="js/scrollreveal.min.js"></script>
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/jquery.fittext.js"></script>
    <script src="js/jquery.magnific-popup.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/creative.js"></script>
</body>

<!-- ------------------------------------------------------------------------------------- -->
 
</body>
</html> 