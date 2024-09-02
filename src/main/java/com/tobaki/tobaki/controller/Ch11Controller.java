package com.tobaki.tobaki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch11")
public class Ch11Controller {
	@ModelAttribute
	public void getChNum(Model model) {
		model.addAttribute("chNum", "ch11");
	}
	
	@GetMapping("/joinForm")
	public String joinForm(Model model) {
		log.info("실행");
		
		return "ch11/joinForm";
	}
}
