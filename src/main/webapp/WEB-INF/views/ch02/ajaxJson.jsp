<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSON으로 응답 값으로 넘기기 위해서는 contentType을 text/html이 아닌, application/json으로 설정해주어야 한다.  
	 보통은 jsp 파일로 json 객체를 생성하지 않는다. (서버에서 json을 생성하고 넘겨준다.)
--%>
{
	"status" : "ok",
	"data" : ["photo1.jpg", "photo2.jpg", "photo3.jpg"]
}