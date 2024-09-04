<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/WEB-INF/views/common/top.jsp" %>

<div class="card">
	<div class="card-header">
		게시물 목록
	</div>
	
	<div class="card-body">
		<table class="table table-sm table-bordered">
			<tr>
				<th style="width:30px">번호</th>
				<th style="width:300px">제목</th>
				<th style="width:70px">글쓴이</th>
				<th style="width:70px">날짜</th>
				<th style="width:70px">조회수</th>
			</tr>
			
			<c:forEach items="${list}" var="element">
				<tr>
					<td>${element.bno}</td>
					<td>${element.btitle}</td>
					<td>${element.mid}</td>
					<td><fmt:formatDate value="${element.bdate}" pattern="yy-MM-dd hh:mm:ss" /></td>
					<td>${element.bhitcount}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" class="text-center">
					<%-- [처음] [이전] 1 2 3 4 5 [다음] [마지막] --%>
					<div>
						<a href="boardList?pageNo=1" class="btn btn-outline-primary btn-sm" >처음</a>
						<c:if test="${pager.groupNo>1}" > 
							<a href="boardList?pageNo=${pager.startPageNo-1}" class="btn btn-outline-info btn-sm" >이전</a>
						</c:if>
						
						<%-- 
							begin: 시작 인덱스(포함)
							end: 마지막 인덱스(포함)
							step: 인덱스 증가량 (생략가능)
							var: 현재 인덱스를 담은 변수
						 --%>
						<c:forEach begin="${pager.startPageNo}" end="${pager.endPageNo}" var="i" >
							<c:if test="${pager.pageNo == i}" >
								<a href="boardList?pageNo=${i}" class="btn btn-dark btn-sm">${i}</a>
							</c:if>
							<c:if test="${pager.pageNo != i}" >
								<a href="boardList?pageNo=${i}" class="btn btn-outline-dark btn-sm">${i}</a>
							</c:if>
						</c:forEach>
						
						<c:if test="${pager.groupNo<pager.totalGroupNo}" >
							<a href="boardList?pageNo=${pager.endPageNo+1}" class="btn btn-outline-info btn-sm" >다음</a>
						</c:if>
						<a href="boardList?pageNo=${pager.totalPageNo}" class="btn btn-outline-primary btn-sm" >마지막</a>
					</div>
				</td>
			</tr>
		</table>
	</div>
</div>
<jsp:include page="/WEB-INF/views/common/bottom.jsp"></jsp:include>
