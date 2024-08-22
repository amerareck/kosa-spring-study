package com.tobaki.tobaki.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch02")
public class Ch02Controller {
	private static final Logger logger = LoggerFactory.getLogger(Ch02Controller.class);
	
	@RequestMapping("/getMethod")
	public String getMethod() {
		//log.info("실행");
		logger.info("실행");
		return "ch02/getMethod";
	}
	
	@RequestMapping("/postMethod")
	public String postMethod() {
		log.info("실행");
		return "ch02/postMethod";
	}
	
	@GetMapping("/getAtag")
	public String getAtag(String bno, String bkind) {
		log.info("실행");
		log.info("bno: "+ bno);
		log.info("bkind: "+ bkind);
		return "ch02/getMethod";
	}
	
	@RequestMapping("/getFormTag")
	public String getFormTag(String bno, String bkind) {
		log.info("실행");
		log.info("bno: "+ bno);
		log.info("bkind: "+ bkind);
		return "ch02/getMethod";
	}
}
