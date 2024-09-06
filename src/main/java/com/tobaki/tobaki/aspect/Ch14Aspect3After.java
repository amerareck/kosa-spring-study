package com.tobaki.tobaki.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(1)
@Aspect
@Component
public class Ch14Aspect3After {
	//매개 값으로 들어온 무언가가 실행되고 난 후에 이 공통코드를 실행한다.
	//execution(접근제어자/리턴타입모두/패키지경로.클래스.before*메소드모두(매개변수모두허용))
	@After("execution(public * com.tobaki.tobaki.controller.Ch14Controller.after*(..))") 
	public void method() {
		//공통 코드(메소드 호출 전에 실행하는 코드)
		log.info("메소드 호출 후에 실행");
	}
}
