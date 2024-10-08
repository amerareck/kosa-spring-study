<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/top.jsp" %>

<div class="card">
	<div class="card-header">
		상품 목록
	</div>
							
	<div class="card-body">
		<ul>
			<%-- items에서 요소를 꺼내 var에 할당해주면서 반복문 실행. --%>
			<c:forEach items="${productList}" var="item">
				<li class="m-2">
					<span>${item.pname}</span>
					<a href="cartAdd?pno=${item.pno}&pname=${item.pname}" class="btn btn-info btn-sm">장바구니 넣기</a>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
<jsp:include page="/WEB-INF/views/common/bottom.jsp"></jsp:include>