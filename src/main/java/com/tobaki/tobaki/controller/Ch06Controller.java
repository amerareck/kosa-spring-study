package com.tobaki.tobaki.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tobaki.tobaki.dto.Ch06Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch06")
public class Ch06Controller {
	
	@ModelAttribute
	public void chNum(Model model) {
		model.addAttribute("chNum", null);
	}
	
	@GetMapping("forward")
	public String forward(Model model, HttpServletRequest req) {
		log.info("실행");
		Ch06Member member = new Ch06Member();
		member.setMid("user1");
		member.setMname("사용자1");
		member.setMemail("user@mycompany.com");
		
		//방법 1
		model.addAttribute("member1", member);
		
		//방법 2
		req.setAttribute("member2", member);
		
		return "ch06/forward";
	}
	
	@GetMapping("redirect")
	public String redirect(Model model, HttpServletRequest req, RedirectAttributes redi) {
		log.info("실행");
		Ch06Member member = new Ch06Member();
		member.setMid("user1");
		member.setMname("사용자1");
		member.setMemail("user@mycompany.com");
		
		//방법 1
		model.addAttribute("member1", member);
		
		//방법 2
		req.setAttribute("member2", member);
		return "redirect:/ch06/sessionData";
	}
	
	@GetMapping("sessionData")
	public String sessionData() {
		log.info("실행");
		return "ch06/sessionData";
	}
}
