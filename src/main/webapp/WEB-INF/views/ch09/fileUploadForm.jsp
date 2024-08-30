<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- include 지시자의 역할: 외부의 파일의 내용을 가져와서 삽입시켜줌 --%>    
<%@ include file="/WEB-INF/views/common/top.jsp" %>

<div class="card">
	<div class="card-header">
		파일 업로드
	</div>
	
	<div class="card-body">
		<form method="post" enctype="multipart/form-data" action="singleFileUpload">
			<div class="form-group">
				<label for="title">File Title</label> 
				<input type="text" class="form-control" id="title" name="title" placeholder="제목">
			</div>
			<div class="mt-2 form-group">
				<label for="desc">File Description</label> 
				<input type="text" class="form-control" id="desc" name="desc" placeholder="설명">
			</div>
			<div class="mt-2 form-group">
			    <label for="attach">File Attach</label>
			    <input type="file" class="form-control-file" id="attach" name="attach">
		  	</div>
		  	
		  	<button type="submit" class="mt-2 btn btn-info btn-sm">싱글 파일 업로드</button>
		</form>
		
		<hr/>
		<%-- multipart(+file) : 서버의 객체, form-data: JS의 객체 호호호... 외우는 꿀팁 --%>
		<form method="post" enctype="multipart/form-data" action="multiFileUpload">
			<div class="form-group">
				<label for="title">File Title</label> 
				<input type="text" class="form-control" id="title" name="title" placeholder="제목">
			</div>
			<div class="mt-2 form-group">
				<label for="desc">File Description</label> 
				<input type="text" class="form-control" id="desc" name="desc" placeholder="설명">
			</div>
			<div class="mt-2 form-group">
			    <label for="attach">File Attach</label>
			    <input type="file" multiple="multiple" class="form-control-file" id="attach" name="attach">
		  	</div>
		  	
		  	<button type="submit" class="mt-2 btn btn-info btn-sm">멀티 파일 업로드</button>
		</form>
		
		<hr />
									
		<form>
			<div class="form-group">
				<label for="title">File Title</label> 
				<input type="text" class="form-control" id="ajaxTitle" placeholder="제목">
			</div>
			<div class="mt-2 form-group">
				<label for="desc">File Description</label> 
				<input type="text" class="form-control" id="ajaxDesc" placeholder="설명">
			</div>
			<div class="mt-2 form-group">
			    <label for="attach">File Attach</label>
			    <input type="file" multiple="multiple" class="form-control-file" id="ajaxAttach">
		  	</div>
			<button type="button" onclick="uploadFileFromAjax()" class="btn btn-info">사진 전송</button>
		</form>
		<script>
			function uploadFileFromAjax() {
				// multipart/form-data의 구조를 갖는 객체
				// 여기서 구조란, http-body에 파일을 전송하는 구조를 말한다. 
				// form태그에서 entype="multipart/form-data" 구조를 생성해준다고 보면 된다.
				const formData = new FormData();
				formData.append('title', $('#ajaxTitle').val());
				formData.append('desc', $('#ajaxDesc').val());
				// $('#attach')의 $객체를 호출한게 아니라, $('#attach')의 element 객체를 호출해야 한다.
				// jquery에서 리턴 객체를 jquery가 아니라 요소 DOM객체 자체를 얻고 싶다면, 배열의 인덱스를 호출하면 된다.
				// multiple 속성이 지정되어 있는 input 태그이므로 file이 여러 개가 존재할 수 있다. (그로므로 배열로 할당됨) 그래서 그 중에 1개를 호출해야 한다.
				formData.append('attach', $('#ajaxAttach')[0].files[0]);
				
				$.ajax({
					url: "uploadFileAjax",
					type: "post",
					data: formData, // formData에 저장한 데이터 그대로가 HTTP 본문의 내용이다.
					cache: false, // 파일의 데이터는 커서 브라우저 캐시에 보관하기 벅차므로 false 설정을 해줘야 한다.
					processData: false, // 요청 HTTP 본문의 내용을 가공처리 하지 말아라. formData 객체가 이미 필요한 가공처리를 했으므로. (쿼리 스트링으로 변환하지 말라)
					contentType: false, // 본문에는 여러 개의 컨텐트 타입이 존재하므로 1개로 표현할 수 없다. 그러므로 컨텐트 타입을 지정하지 않아야 한다. (오히려 혼동을 준다.)
					success: function(data) {
						//{"result":"ok"}
						if (data.status === "ok") {
							location.href = "downloadFileList";
						} else {
							console.log('전송 실패');
						}
					}
				});
			}
		</script>
	</div>
</div>

<%-- include 액션의 역할: 외부의 JSP를 실행하고 그 결과를 삽입시켜줌 --%>
<jsp:include page="/WEB-INF/views/common/bottom.jsp"/>





