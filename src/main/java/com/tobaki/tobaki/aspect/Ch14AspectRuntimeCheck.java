package com.tobaki.tobaki.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class Ch14AspectRuntimeCheck {
	@Around("@annotation(com.tobaki.tobaki.aspect.RuntimeCheck)")
	public Object method(ProceedingJoinPoint jointPoint) throws Throwable {
		// 메서드 호출 전에 실행하는 공통 코드
		long start = System.nanoTime();
		
		Object result = jointPoint.proceed();
		
		// 메서드 호출 후에 실행하는 공통 코드
		long end = System.nanoTime();
		
		long howlong = end-start;
		// 실제 실행하는 메서드 이름 얻기
		String methodName = jointPoint.getSignature().toShortString();
		log.info("실행 시간("+methodName+"): "+howlong+"ns");
		return result;
	}
}
