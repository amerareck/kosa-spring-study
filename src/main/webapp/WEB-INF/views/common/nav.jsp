<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-dark bg-dark">
	<div class="ms-2">
		<%-- pageContext.reqeust.contextPath : root 경로를 리턴해준다. 여기서는 아이피:포트/springframework 가 해당. --%>
		<a href="${pageContext.request.contextPath}" class="navbar-brand">
			<img width="40" src="${pageContext.request.contextPath}/resources/image/logo-spring.png" />
			<span class="align-middle">전자정부프레임워크(Spring Framework)</span>
		</a>
	</div>
	
	<div class="me-2">
		<c:if test="${login==null}">
			<a class="btn btn-success btn-sm" href="${pageContext.request.contextPath}/ch08/login">로그인</a>
		</c:if>
		<c:if test="${login!=null}">
			<img width="40" src="${pageContext.request.contextPath}/resources/image/userLogo.png" />
			<span class="me-2 text-light">${login.mid}</span>
			<a class="btn btn-success btn-sm" href="${pageContext.request.contextPath}/ch08/logout">로그아웃</a>
		</c:if>
	</div>
</nav>