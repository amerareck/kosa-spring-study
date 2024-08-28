package com.tobaki.tobaki.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch05")
public class Ch05Controller {
	
	@GetMapping("/header")
	public String header(
			@RequestHeader("User-Agent") String userAgent, 
			Model model,
			HttpServletRequest req) {
		log.info("실행");
		log.info("User-Agent: "+userAgent);
		
		//헤더값 얻는 법 1
		String browser = null;
		if(userAgent.contains("Edg")) {
			browser = "Edg";
		} else if(userAgent.contains("Chrome")) {
			browser = "Chrome";
		}
		
		//헤더값 얻는 법 2
		userAgent = req.getHeader("User-Agent");
		log.info("User-Agent2: "+userAgent);
		
		model.addAttribute("browser", browser);
		
		String clientIp = req.getRemoteAddr();
		log.info("client ip: "+clientIp);
		model.addAttribute("clientIp", clientIp);
		
		return "ch05/header";
	}
	
	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse res) {
		log.info("실행");
		
		//쿠키 생성
		Cookie cookie1 = new Cookie("mid", "user1"); 
		cookie1.setMaxAge(60); 
		cookie1.setHttpOnly(true);
		Cookie cookie2 = new Cookie("memail", "user1@mycompany.com");
		cookie2.setMaxAge(60);
		cookie2.setHttpOnly(true);
		
		//쿠키를 응답헤더에 추가해서 브라우저로 보냄
		res.addCookie(cookie1);
		res.addCookie(cookie2);
		
		return "redirect:/";
	}
	
	@GetMapping("/readCookie")
	public String readCookie(
			@CookieValue("mid") String mid,
			@CookieValue("memail") String memail,
			Model model) {
		log.info("실행");
		log.info("mid: "+mid);
		log.info("memail: "+memail);
		
		model.addAttribute("mid", mid);
		model.addAttribute("memail", memail);
		return "ch05/readCookie";
	}
}
