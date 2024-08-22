<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="accordion" id="accordionMenu">
  	<div class="accordion-item">
    	<h2 class="accordion-header">
      	<button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#ch01" aria-expanded="true" aria-controls="ch01">
        	Ch01. 개발 환경 구축
      	</button>
    	</h2>
    	<div id="ch01" class="accordion-collapse collapse show" data-bs-parent="#accordionMenu">
      		<div class="accordion-body">
      			<ul>
      				<li><a href="${pageContext.request.contextPath}/ch01/content">공통 레이아웃 작성</a></li>
      			</ul>
      		</div>
    	</div>
  	</div>

  	<div class="accordion-item">
    	<h2 class="accordion-header">
	      	<button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#ch02" aria-expanded="true" aria-controls="ch02">
	        	Ch02. Controller(RequestMapping)
	      	</button>
    	</h2>
    	<div id="ch02" class="accordion-collapse collapse show" data-bs-parent="#accordionMenu">
      		<div class="accordion-body">
      			<ul>
      				<li><a href="${pageContext.request.contextPath}/ch02/getMethod">GET 방식</a></li>
      				<li><a href="${pageContext.request.contextPath}/ch02/postMethod">POST 방식</a></li>
      			</ul>
      		</div>
    	</div>
  	</div>

</div>

