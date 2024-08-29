package com.tobaki.tobaki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@ModelAttribute
	public void chNum(Model model) {
		model.addAttribute("chNum", null);
	}
	
	@RequestMapping("")
	public String index() {
		log.info("실행");
		return "home";
	}
}
