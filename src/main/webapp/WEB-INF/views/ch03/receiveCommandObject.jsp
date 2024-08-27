<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/top.jsp" %>
<div class="card">
	<div class="card-header">
		Get 방식 데이터 얻기 
	</div>
	
	<div class="card-body">
		<p>param1: ${ch03Dto.param1}</p>
		<%-- el의 값이 null일 경우, null을 출력하는 것이 아니라, 아무것도 출력하지 않는다. --%>
		<p>param2: ${ch03Dto.param2}</p>
		<p>param3: ${ch03Dto.param3}</p>
		<p>param4: ${ch03Dto.param4}</p>
		<p>param5: ${ch03Dto.param5}</p>
	</div>
</div>
<%@ include file="/WEB-INF/views/common/bottom.jsp" %>