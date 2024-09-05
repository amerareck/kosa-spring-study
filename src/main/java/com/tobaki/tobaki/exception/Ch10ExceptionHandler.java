package com.tobaki.tobaki.exception;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component // 일반 클래스를 관리 객체(=빈)로 만들기
//@ControllerAdvice // 컨트롤러에서 발생한 에러를 이 객체가 처리하겠다.
public class Ch10ExceptionHandler {
	@ExceptionHandler(NullPointerException.class)
	public String handleNullPointerException(Model model) {
		log.info("실행");
		return "ch10/nullPointerException";
	}
	
	@ExceptionHandler(Ch10CustomException.class)
	public String handleCh10CustomException() {
		log.info("실행");
		return "ch10/customException";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException() {
		log.info("실행");
		return "ch10/Exception";
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handleNoHandlerFoundException() {
		log.info("실행");
		return "ch10/404";
	}
}
