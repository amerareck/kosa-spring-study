<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getRequestURI();
//	out.println(path);
	if(!path.contains("home.jsp")) {
		path = path.substring(path.indexOf("ch"), path.length());
		path = path.substring(0, path.indexOf("/"));
	} else {
		path = null;
	}
%>
<%-- 아코디언 시작 --%>
<div class="accordion" id="accordionMenu">
	<%-- item start --%>
  	<div class="accordion-item">
    	<h2 class="accordion-header">
      	<button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#ch01" aria-expanded="true" aria-controls="ch01">
        	Ch01. 개발 환경 구축
      	</button>
    	</h2>
    	<div id="ch01" class="accordion-collapse collapse" data-bs-parent="#accordionMenu">
      		<div class="accordion-body">
      			<ul>
      				<li><a href="${pageContext.request.contextPath}/ch01/content">공통 레이아웃 작성</a></li>
      			</ul>
      		</div>
    	</div>
  	</div>
  <%-- item1 end --%>
  <%-- item start --%>
  	<div class="accordion-item">
    	<h2 class="accordion-header">
	      	<button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#ch02" aria-expanded="true" aria-controls="ch02">
	        	Ch02. Controller(RequestMapping)
	      	</button>
    	</h2>
    	<div id="ch02" class="accordion-collapse collapse" data-bs-parent="#accordionMenu">
      		<div class="accordion-body">
      			<ul>
      				<li><a href="${pageContext.request.contextPath}/ch02/getMethod">GET 방식</a></li>
      				<li><a href="${pageContext.request.contextPath}/ch02/postMethod">POST 방식</a></li>
      				<li><a href="${pageContext.request.contextPath}/ch02/returnModelAndView">ModelAndView 리턴</a></li>
      				<li><a href="${pageContext.request.contextPath}/ch02/returnVoid">void 리턴</a></li>
      				<li><a href="${pageContext.request.contextPath}/ch02/returnObject">Object 리턴</a></li>
      				<li><a href="${pageContext.request.contextPath}/ch02/mypage">MyPage (로그인 체크 여부 확인)</a></li>
      				<li><a href="${pageContext.request.contextPath}/ch02/loginForm">로그인/로그아웃</a></li>
      			</ul>
      		</div>
    	</div>
  	</div>
 <%-- item3 end --%>
   <%-- item start --%>
  	<div class="accordion-item">
    	<h2 class="accordion-header">
	      	<button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#ch03" aria-expanded="true" aria-controls="ch03">
	        	Ch03. Controller(RequestParam)
	      	</button>
    	</h2>
    	<div id="ch03" class="accordion-collapse collapse" data-bs-parent="#accordionMenu">
      		<div class="accordion-body">
      			<ul>
      				<li><a href="${pageContext.request.contextPath}/ch03/receiveParamData?param1=문자열&param2=5&param3=3.14&param4=true&param5=2024-08-27">GET 방식 데이터 얻기</a></li>
      				<li><a href="${pageContext.request.contextPath}/ch03/postMethodForm">POST 방식 폼 얻기</a></li>
      				<li><a href="${pageContext.request.contextPath}/ch03/defaultValue?param1=문자열&param5=2024-08-27">파라미터 생략시 디폴트 값 설정</a></li>
      				<li><a href="${pageContext.request.contextPath}/ch03/otherArgumentName?param1=문자열&param5=2024-08-27">파라미터 이름과 매개변수 명이 다를 경우</a></li>
      				<li><a href="${pageContext.request.contextPath}/ch03/commandObject?param1=문자열&param2=5&param3=3.14&param4=true&param5=2024-08-27">하나의 객체로 여러 매개변수 단번에 받기</a></li>
      				<li><a href="${pageContext.request.contextPath}/ch03/ajaxParam">AJAX로 보낸 데이터를 DTO로 받기</a></li>
      			</ul>
      		</div>
    	</div>
  	</div>
 <%-- item3 end --%>
  <%-- item4 start --%>
 	<div class="accordion-item">
	   	<h2 class="accordion-header">
	      	<button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#ch04" aria-expanded="false" aria-controls="ch04">
	        	Ch04. Controller(form 유효성 검사)
	      	</button>
	   	</h2>
	   	<div id="ch04" class="accordion-collapse collapse" data-bs-parent="#accordionMenu">
	     		<div class="accordion-body">
	     			<ul>
	     				<li><a href="${pageContext.request.contextPath}/ch04/loginForm">로그인 폼 유효성 검사</a></li>
	     		</div>
	   	</div>
 	</div>
<%-- item4 end --%>
</div>
<%-- 아코디언 끝 --%>

<%
	if(path != null) {
%>
<script>
	const path = "<%= path %>";
	console.log(path);
	$('#'+path).addClass('show');
</script>

<%
	}
%>


