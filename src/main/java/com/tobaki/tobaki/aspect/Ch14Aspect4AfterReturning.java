package com.tobaki.tobaki.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(1)
@Aspect
@Component
public class Ch14Aspect4AfterReturning {
	
	// pointcut은 핵심메서드가 실행되고난 뒤, 정상적으로 값이 리턴된다면 그 값을 매개변수로 활용해서 공통메서드 실행.
	//execution(접근제어자/리턴타입모두/패키지경로.클래스.afterReturning*메소드모두(매개변수모두허용))
	@AfterReturning(
			pointcut="execution(public * com.tobaki.tobaki.controller.Ch14Controller.afterReturning*(..))",
			returning="returnValue"
	) 
	public void method(String returnValue) {
		//공통 코드(메소드 호출 전에 실행하는 코드)
		log.info("메소드 호출 후에 실행");
		log.info("리턴값: "+returnValue);
	}
}
