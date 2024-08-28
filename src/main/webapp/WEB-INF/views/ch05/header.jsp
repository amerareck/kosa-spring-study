<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- inclide 지시자의 역할 : 외부 파일의 내용을 가져와서 삽입시켜줌. --%>
<%@ include file="/WEB-INF/views/common/top.jsp" %>

<div class="card">
	<div class="card-header">
		헤더 읽기
	</div>

	<div class="card-body">
		<p>브라우저 종류: ${browser}</p>
		<p>클라이언트 IP: ${clientIp}</p>
	</div>
</div>
<jsp:include page="/WEB-INF/views/common/bottom.jsp"></jsp:include>