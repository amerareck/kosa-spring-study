package com.tobaki.tobaki.aspect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class Ch14AspectLoginCheck {
	@Around("@annotation(com.tobaki.tobaki.aspect.LoginCheckAOP)")
	public Object method(ProceedingJoinPoint jointPoint) throws Throwable {
		// 메서드 호출 전에 실행하는 공통 코드
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest req = sra.getRequest();
		HttpSession session = req.getSession();
		
		Object login = session.getAttribute("login");
		if(login == null) {
			// 로그인이 안 된 경우
			return "redirect:/ch13/loginForm";
		} else {
			// 로그인이 된 경우
			Object result = jointPoint.proceed();
			return result;
		}		
	}
}
