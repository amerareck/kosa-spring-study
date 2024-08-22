<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>
	</head>
	<body>
		<div class="d-flex flex-column vh-100">
			<%@ include file="/WEB-INF/views/common/nav.jsp" %>
			<div class="flex-grow-1 m-2">
				<div class="row">
					<aside class="col-md-4">
						<%@ include file="/WEB-INF/views/common/menu.jsp" %>
					</aside>
					<section class="col-md-8">
					