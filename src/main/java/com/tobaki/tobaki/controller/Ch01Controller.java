package com.tobaki.tobaki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class Ch01Controller {
	
	@ModelAttribute
	public void chNum(Model model) {
		model.addAttribute("chNum", "ch01");
	}
	
	@RequestMapping("/ch01/content")
	public String content() {
		log.info("실행");
		return "ch01/content";
	}
}
