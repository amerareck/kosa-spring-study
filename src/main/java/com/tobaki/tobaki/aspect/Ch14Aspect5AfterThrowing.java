package com.tobaki.tobaki.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(1)
@Aspect
@Component
public class Ch14Aspect5AfterThrowing {
	//매개 값으로 들어온 무언가가 실행되고 난 후에 예외가 발생할 경우, 그 예외 객체를 받아서 공통코드를 실행한다.
	//execution(접근제어자/리턴타입모두/패키지경로.클래스.before*메소드모두(매개변수모두허용))
	@AfterThrowing(
			pointcut="execution(public * com.tobaki.tobaki.controller.Ch14Controller.afterThrowing*(..))",
			throwing="e"
	) 
	public void method(Throwable e) {
		log.info("실행");
		log.info("예외 메세지: "+ e.getMessage());
	}
}
