package com.tobaki.tobaki.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Order(1)
@Aspect
@Component
public class Ch14Aspect6AfterAround {
	//매개 값으로 들어온 무언가가 실행되기 전에 점검하고 그 결과값을 받아서 다시 한번 공통 코드를 수행.
	//execution(접근제어자/리턴타입모두/패키지경로.클래스.before*메소드모두(매개변수모두허용))
	@Around("execution(public * com.tobaki.tobaki.controller.Ch14Controller.around*(..))") 
	public Object method(ProceedingJoinPoint joinPoint) throws Throwable {
		//메소드 실행 전에 수행하는 공통 코드
		//...
		log.info("메소드 실행 전에 수행하는 공통 코드");
		
		// Arround 메서드가 핵심 코드를 실행하고 그 결과값을 result에 삽입.
		Object result = joinPoint.proceed();
		
		//메소드 호출 후에 실행하는 공통 코드
		//...
		log.info("메소드 실행 후에 수행하는 공통 코드");
		
		return result;
	}
}
