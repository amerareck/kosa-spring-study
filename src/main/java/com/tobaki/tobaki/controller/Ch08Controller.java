package com.tobaki.tobaki.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tobaki.tobaki.dto.Ch08LoginForm;
import com.tobaki.tobaki.dto.Ch08Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch08")
public class Ch08Controller {
	
	@ModelAttribute
	public void chNum(Model model) {
		model.addAttribute("chNum", "ch08");
	}
	
	@GetMapping("/login")
	public String loginForm() {
		log.info("실행");
		
		return "ch08/loginForm";
	}
	
	@PostMapping("/login")
	public String login(Ch08LoginForm loginForm, HttpSession session, RedirectAttributes redi) {
		log.info("실행");
		Ch08Member member = new Ch08Member();
		member.setMid(loginForm.getMid());
		member.setMpassword(loginForm.getMpassword());
		member.setMname("홍길동");
		member.setMemail("hong@mycompany.com");
		
		session.setAttribute("login", member);
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session, RedirectAttributes redi) {
		log.info("실행");
		session.invalidate();

		return "redirect:/ch08/login";
	}
	
	@GetMapping("/loginInfo")
	public String loginInfo() {
		log.info("실행");
		return "/ch08/loginInfo";
	}
}
