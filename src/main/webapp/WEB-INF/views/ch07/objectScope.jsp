<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="/WEB-INF/views/common/top.jsp" %>

<div class="card">
	<div class="card-header">
		데이터 사용 범위
	</div>
							
	<div class="card-body">
		<%-- page 사용 범위 --%>
		<%-- c:set 태그에 변수를 할당하기 위해 사용하는 태그
			 var에 키를 value에 값을 할당하며, scope는 변수의 범위이다. page,request,session,application이 있다.
		 --%>
		<c:set var="key0" value="0" scope="page" />
		
		<%-- 각 범위의 데이터를 얻고 출력 --%>
		<p>key0: ${key0}</p>
		<p>key1: ${key1}</p>
		<p>key2: ${key2}</p>
		<p>key3: ${key3}</p>
		<p>key4: ${key4}</p>
	</div>
</div>
<jsp:include page="/WEB-INF/views/common/bottom.jsp"></jsp:include>