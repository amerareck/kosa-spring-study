package com.tobaki.tobaki.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginCheckInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("전처리");
		
		HandlerMethod hand = (HandlerMethod) handler;
		LoginCheck loginCheck = hand.getMethodAnnotation(LoginCheck.class);
		
		if(loginCheck == null) {
			log.info("로그인 영역이 아님");
			return true;
		}
		log.info("로그인이 필요함. 검증 시작");
		HttpSession session = request.getSession();
		String getInfo = (String)session.getAttribute("login");
		
		if(getInfo == null) {
			log.info("로그인 정보가 없음. 로그인 화면 이동");
			//response.sendRedirect(session.getServletContext().getContextPath() + "/ch02/loginForm");
			response.sendRedirect(session.getServletContext().getContextPath() + "/ch13/loginForm");
			return false;
		}
		log.info("로그인 정보 확인!");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("후처리");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("컨트롤러 수행 완료");
	}
}
