package com.tobaki.tobaki.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch07")
public class Ch07Controller {
	
	@ModelAttribute
	public void chNum(Model model) {
		model.addAttribute("chNum", "ch07");
	}
	
	@GetMapping("objectScope")
	public String objectScope(HttpServletRequest req, HttpSession session, Model model) {
		log.info("실행");
		
		//Request 사용 범위(요청과 헤더 사이에 사용할 수 있는 범위)
		req.setAttribute("key1", "value2");
		model.addAttribute("key2", "value2");
		
		//Session 사용 범위(동일한 브라우저라면 사용할 수 있는 범위)
		session.setAttribute("key3", "value3");
		
		//Application 사용 범위(모든 브라우저에서 사용할 수 있는 범위)
		ServletContext application = req.getServletContext();
		application.setAttribute("key4", "value4");
		
		return "ch07/objectScope";
	}
	
	@GetMapping("objectScope2")
	public String objectScope2(HttpServletRequest req, HttpSession session, Model model) {
		log.info("실행");
		
		
		return "ch07/objectScope";
	}
}
