// tool.js version 3.0

/**
 * id값을 가진 태그를 검색합니다.
 * @param id
 * @returns 검색된 id의 태그
 */
function find(id){
  return document.getElementById(id);
}

/**
 * 천단위 콤마를 설정합니다.
 * @param val
 * @returns
 */
function comma(val){
  return Number(val).toLocaleString('en');
}

/**
문자열에서 숫자만 추출합니다. 예) 100,000 --> 100000
정규 표현식
/ ... /  : 정규 표현식 선언 영역
[^0-9]: 0 ~ 9를 제외한 모든 문자 추출
g       : 추출된 문자열 리턴
*/
function getNumber(val){
  var regexp = /[^0-9]/g;  //숫자가 제외된 문자만 나타냄
  var returnval = new String(val); // 새로운 문자열 생성
  returnval = returnval.replace(regexp, ''); //숫자가 제외된 문자열만 추출하여 공백으로 변경 => 문자들 삭제
  
  return returnval;
}

/**
 * input 태그와 관련한 id 값 추출
 * @param id
 * @returns
 */
function val(id){
  return document.getElementById(id).value;
}

/**
 * <span>,<id>태그의 값 추출
 * @param id
 * @returns
 */
function html(id){
  return document.getElementById(id).innerHTML;
}

/**
 * 파일 크기의 단위를 계산합니다.
 * @param length 파일 크기
 */
function unit(length){
  var str = "";
  
  if (length < 1024){  // Byte: 0 ~ 1023
    str = parseInt(length) + " Byte";   
  }else if (length < (1024 * 1024)){ // Byte: 1024 ~ 1048575
    str = parseInt(length / 1024) + " KB";
  }else if(length < (1024 * 1024 * 1024)){ // Byte: 1048576 ~ 1073741823
    str = parseInt(length / 1024 / 1024) + " MB";
  }else if(length < (1024 * 1024 * 1024 * 1024)){ // Byte: 1073741824 ~
    str = parseInt(length / 1024 / 1024 / 1024) + " GB";
  }
  
  return str;
}


//jQuery 사용자 정의 함수
jQuery.fn.center = function () {
//this.css("color","#FFFFFF");
//this.css("backgroundColor","#32c8c8");
this.css("opacity",0.8);
this.css("position","absolute");
//Math.max(1,2): 큰수 비교, 출력은 2
//alert("$(window).height()"+$(window).height());
//alert("$(this).outerHeight()"+$(this).outerHeight());
  this.css("top", Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + $(window).scrollTop()) + "px");
  this.css("left", Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + $(window).scrollLeft()) + "px");
return this;
}

var show_layer = function() {
$("#layer").show();
$("#layer").center();
}




