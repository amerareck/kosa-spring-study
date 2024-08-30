<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- include 지시자의 역할: 외부의 파일의 내용을 가져와서 삽입시켜줌 --%>    
<%@ include file="/WEB-INF/views/common/top.jsp" %>

<div class="card">
	<div class="card-header">
		파일 다운로드 목록
	</div>
	
	<div class="card-body">
		<ul>
			<c:forEach items="${fileNames}" var="fileName" >
				<%-- 쿼리문자열엔 한글을 읽을 수 없다. (깨짐) url로 읽을 수 있는 문자열로 바꿔주도록 한다. --%>
				<li>
					<%-- 이미지 태그라고 하더라도, 사용자가 업로드한 이미지를 출력할 때에는 바이너리를 받아서 출력하도록 해야한다. --%>
					<img class="rounded-circle" src="downloadFile?fileName=${fileName}" width="30;" height="30;" />
					<a href="downloadFile?fileName=${fileName}">${fileName}</a>
				</li>
			</c:forEach>
			
		</ul>
			
	</div>
</div>

<%-- include 액션의 역할: 외부의 JSP를 실행하고 그 결과를 삽입시켜줌 --%>
<jsp:include page="/WEB-INF/views/common/bottom.jsp"/>





