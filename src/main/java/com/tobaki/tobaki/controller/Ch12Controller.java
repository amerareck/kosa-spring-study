package com.tobaki.tobaki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch12")
public class Ch12Controller {
	@ModelAttribute
	public void getChNum(Model model) {
		model.addAttribute("chNum", "ch12");
	}
	
	@GetMapping("/createBeanByXML")
	public String createBeanByXML() {
		log.info("실행");
		
		return "ch12/createBeanByXML";
	}
}
