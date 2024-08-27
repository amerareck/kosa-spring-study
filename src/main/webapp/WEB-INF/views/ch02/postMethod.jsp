<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/top.jsp" %>
<div class="card">
	<div class="card-header">
		POST 방식
	</div>
	
	<div class="card-body">
		<div class="mt-2">
			<form method="post" action="postFormTag">
				<div class="mb-3">
					<label for="bno" class="form-label">게시물 번호</label>
					<input type="number" class="form-control" id="bno" name="bno" value="5" />
				</div>
				<div class="mb-3">
					<label for="bkind" class="form-label">게시물 종류</label>
					<input type="text" class="form-control" id="bkind" name="bkind" value="free" />
				</div>
				<%-- 제출 버튼을 만드는 방법1 --%>
				<input type="submit" value="제출" class="btn btn-info btn-sm" /><br/>
				<%-- 제출 버튼을 만드는 방법2 --%>
				<input class="mt-2" type="image" src="${pageContext.request.contextPath}/resources/image/img_submit.gif" value="" />
				<br/>
				<%-- 제출 버튼을 만드는 방법3 --%>
				<%-- 버튼이 form태그 내부에 존재할 경우, submit 효과가 있다. (디폴트: submit) --%>
				<button class="mt-2 btn btn-info btn-sm">제출</button>
			</form>
			
			<hr class="hr"/>
			
			<div class="mt-2">
				<button class="btn btn-info btn-sm mb-2" onclick="requestPost1()">JavaScript: ajax 이용</button>
				<br/>
				<br/>
				<button class="btn btn-info btn-sm mb-2" onclick="requestPost2()">JavaScript: ajax 이용</button>
				<div class="border mt-2" id="ajaxResult">
					Ajax 결과
				</div>
				
				<script>
					function requestPost1() {
						$.ajax({
							url: "postAjax1",
							method: "post",
							//data: "bno=5&bkind=free"
							data: {bno:5, bkind:"free"},
							success: function (data) {
								// data가 HTML 조각일 경우
								$('#ajaxResult').html(data);
								//document.querySelector('#ajaxResult').innerHTML = data;
							}
						});
					}
					
					function requestPost2() {
						$.ajax({
							url: "postAjax2",
							method: "post",
							//data: "bno=5&bkind=free"
							data: {bno:5, bkind:"free"},
							success: function (data) {
								//data가 json 일 경우
								console.log(data);
								let content = "";
								content += "<div class='card'>";
								content += "	<div class='card-header'> AJAX의 JSON 응답</div>";
								content += "	<div class='card-body'>";
								data.data.forEach(function (item) {
									content += "<img src='${pageContext.request.contextPath}/resources/image/photos/"+item+"' class='me-2' height='100' />";
								});
								content += "	</div>";
								content += "</div>";
								$('#ajaxResult').html(content);
							}
						});
					}
				</script>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/common/bottom.jsp" %>