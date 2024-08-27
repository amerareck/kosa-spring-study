<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="card">
	<div class="card-header">
		Ajax의 HTML 조각 응답
	</div>
	
	<div class="card-body">
		<%-- Ajax를 통한 html 조각을 넘길 때엔, 정적 자료들의 경우 절대 경로로 넘겨주는 것이 좋다. --%>
		<img src="${pageContext.request.contextPath}/resources/image/photos/photo1.jpg" height="100" />
		<img src="${pageContext.request.contextPath}/resources/image/photos/photo2.jpg" height="100" />
		<img src="${pageContext.request.contextPath}/resources/image/photos/photo3.jpg" height="100" />
	</div>
</div>
