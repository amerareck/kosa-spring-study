<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 아코디언 시작 --%>
<div class="accordion" id="accordionMenu">
	<%-- item start --%>
  	<div class="accordion-item">
    	<h2 class="accordion-header">
	      	<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#ch01" aria-expanded="true" aria-controls="ch01">
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
	      	<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#ch02" aria-expanded="false" aria-controls="ch02">
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
	      	<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#ch03" aria-expanded="false" aria-controls="ch03">
	        	Ch03. Controller(RequestParameter)
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
	      	<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#ch04" aria-expanded="false" aria-controls="ch04">
	        	Ch04. Controller(form 유효성 검사)
	      	</button>
	   	</h2>
	   	<div id="ch04" class="accordion-collapse collapse" data-bs-parent="#accordionMenu">
	     		<div class="accordion-body">
	     			<ul>
	     				<li><a href="${pageContext.request.contextPath}/ch04/loginForm">로그인 폼 유효성 검사</a></li>
	     			</ul>
	     		</div>
	   	</div>
 	</div>
<%-- item4 end --%>
 <%-- item5 start --%>
 	<div class="accordion-item">
	   	<h2 class="accordion-header">
	      	<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#ch05" aria-expanded="false" aria-controls="ch05">
	        	Ch05. Controller (헤더 값 및 쿠키 설정)
	      	</button>
	   	</h2>
	   	<div id="ch05" class="accordion-collapse collapse" data-bs-parent="#accordionMenu">
	     		<div class="accordion-body">
	     			<ul>
	     				<li><a href="${pageContext.request.contextPath}/ch05/header">요청 헤더 값 얻기</a></li>
	     				<li><a href="${pageContext.request.contextPath}/ch05/createCookie">쿠키 생성</a></li>
	     				<li><a href="${pageContext.request.contextPath}/ch05/readCookie">쿠키 읽기</a></li>
	     			</ul>
	     		</div>
	   	</div>
 	</div>
<%-- item5 end --%>
<%-- item6 start --%>
 	<div class="accordion-item">
	   	<h2 class="accordion-header">
	      	<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#ch06" aria-expanded="false" aria-controls="ch06">
	        	Ch06. Forward와 Redirect
	      	</button>
	   	</h2>
	   	<div id="ch06" class="accordion-collapse collapse" data-bs-parent="#accordionMenu">
	     		<div class="accordion-body">
	     			<ul>
	     				<li><a href="${pageContext.request.contextPath}/ch06/forward">포워드</a></li>
	     				<li><a href="${pageContext.request.contextPath}/ch06/sessionData?queryString=redirect">리다이렉트</a></li>
	     				<li><a href="${pageContext.request.contextPath}/ch06/sessionData">다른 요청 시 세션 데이터 이용</a></li>
	     				<li><a href="${pageContext.request.contextPath}/ch06/cartView">장바구니</a></li>
	     				<li><a href="${pageContext.request.contextPath}/ch06/productList">상품 목록 보기</a></li>
	     			</ul>
	     		</div>
	   	</div>
 	</div>
<%-- item6 end --%>
<%-- item7 start --%>
 	<div class="accordion-item">
	   	<h2 class="accordion-header">
	      	<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#ch07" aria-expanded="false" aria-controls="ch07">
	        	Ch07. 데이터(객체) 사용 범위 및 데이터 전달 
	      	</button>
	   	</h2>
	   	<div id="ch07" class="accordion-collapse collapse" data-bs-parent="#accordionMenu">
	     		<div class="accordion-body">
	     			<ul>
	     				<li><a href="${pageContext.request.contextPath}/ch07/objectScope">데이터(객체) 사용 범위</a></li>
	     				<li><a href="${pageContext.request.contextPath}/ch07/objectScope2">데이터(객체) 사용 범위</a></li>
	     			</ul>
	     		</div>
	   	</div>
 	</div>
<%-- item7 end --%>
<%-- item8 start --%>
 	<div class="accordion-item">
	   	<h2 class="accordion-header">
	      	<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#ch08" aria-expanded="false" aria-controls="ch08">
	        	Ch08. 세션 지원 API
	      	</button>
	   	</h2>
	   	<div id="ch08" class="accordion-collapse collapse" data-bs-parent="#accordionMenu">
	     		<div class="accordion-body">
	     			<ul>
	     				<li><a href="${pageContext.request.contextPath}/ch08/login">로그인</a></li>
	     				<li><a href="${pageContext.request.contextPath}/ch08/loginInfo">로그인 정보</a></li>
	     				<li><a href="${pageContext.request.contextPath}/ch08/logout">로그아웃</a></li>
	     			</ul>
	     		</div>
	   	</div>
 	</div>
<%-- item8 end --%>
<%-- item9 start --%>
 	<div class="accordion-item">
	   	<h2 class="accordion-header">
	      	<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#ch09" aria-expanded="false" aria-controls="ch09">
	        	Ch09. 파일 업로드와 다운로드
	      	</button>
	   	</h2>
	   	<div id="ch09" class="accordion-collapse collapse" data-bs-parent="#accordionMenu">
     		<div class="accordion-body">
     			<ul>
		        	<li><a href="${pageContext.request.contextPath}/ch09/fileUploadForm">파일 업로드</a></li>
		        	<li><a href="${pageContext.request.contextPath}/ch09/downloadFileList">파일 리스트</a></li>
     			</ul>
     		</div>
	   	</div>
 	</div>
<%-- item9 end --%>
<%-- item10 start --%>
 	<div class="accordion-item">
	   	<h2 class="accordion-header">
	      	<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#ch10" aria-expanded="false" aria-controls="ch10">
	        	Ch10. 예외 처리
	      	</button>
	   	</h2>
	   	<div id="ch10" class="accordion-collapse collapse" data-bs-parent="#accordionMenu">
     		<div class="accordion-body">
     			<ul>
		        	<li><a href="${pageContext.request.contextPath}/ch10/handlingException1">try-catch 이용</a></li>
		        	<li><a href="${pageContext.request.contextPath}/ch10/handlingException2">@ExceptionHandler 이용</a></li>
		        	<li><a href="${pageContext.request.contextPath}/ch10/handlingException3">사용자 정의 예외 처리</a></li>
		        	<li><a href="${pageContext.request.contextPath}/ch10/handlingException4">기타 500 예외 처리</a></li>
		        	<li><a href="${pageContext.request.contextPath}/call404Error">404 처리</a></li>
     			</ul>
     		</div>
	   	</div>
 	</div>
<%-- item10 end --%>
</div>
<%-- 아코디언 끝 --%>

<script>
	const path = '${chNum}';
	console.log(path);
	if(path !== '') {
		$('#'+path).addClass('show');
		$('button[aria-controls='+path+']').removeClass('collapsed');
	}
</script>


