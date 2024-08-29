package com.tobaki.tobaki.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tobaki.tobaki.dto.Ch03Dto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ch03")
public class Ch03Controller {
	
	@ModelAttribute
	public void chNum(Model model) {
		model.addAttribute("chNum", null);
	}
	
	@GetMapping("/receiveParamData")
	public String receiveParamData(
			String param1, String param2, String param3, 
			String param4, String param5, Model model) {
		
		log.info("param1: "+ param1);
		log.info("param2: "+ param2);
		log.info("param3: "+ param3);
		log.info("param4: "+ param4);
		log.info("param5: "+ param5);
		
		model.addAttribute("param1", param1);
		model.addAttribute("param2", param2);
		model.addAttribute("param3", param3);
		model.addAttribute("param4", param4);
		model.addAttribute("param5", param5);
		
		return "ch03/receiveParamData";
	}
	
	@GetMapping("/postMethodForm")
	public String postMethodForm() {
		
		return "ch03/postMethodForm";
	}
	
	@PostMapping("/receivePostMethodForm")
	public String receivePostMethodForm(
			String param1, int param2, double param3, 
			boolean param4, @DateTimeFormat(pattern="yyyy-MM-dd") Date param5, Model model) {
		
		log.info("param1: "+ param1);
		log.info("param2: "+ param2);
		log.info("param3: "+ param3);
		log.info("param4: "+ param4);
		log.info("param5: "+ param5);
		
		model.addAttribute("param1", param1);
		model.addAttribute("param2", param2);
		model.addAttribute("param3", param3);
		model.addAttribute("param4", param4);
		model.addAttribute("param5", param5);
		
		return "ch03/receiveParamData";
	}
	
	@GetMapping("/defaultValue")
	public String defaultValue(
			String param1, @RequestParam(defaultValue="0") int param2, @RequestParam(defaultValue="0.0") double param3, 
			@RequestParam(defaultValue="false") boolean param4, String param5, Model model) {
		
		log.info("param1: "+ param1);
		log.info("param2: "+ param2);
		log.info("param3: "+ param3);
		log.info("param4: "+ param4);
		log.info("param5: "+ param5);
		
		model.addAttribute("param1", param1);
		model.addAttribute("param2", param2);
		model.addAttribute("param3", param3);
		model.addAttribute("param4", param4);
		model.addAttribute("param5", param5);
		
		return "ch03/receiveParamData";
	}
	
	@GetMapping("/otherArgumentName")
	public String otherArgumentName(
			@RequestParam("param1") String arg1, @RequestParam(value="param2", defaultValue="0") int arg2,
			@RequestParam(value="param3", defaultValue="0.0") double arg3, @RequestParam(value="param4", defaultValue="false") boolean arg4,
			@RequestParam("param5") String arg5, Model model) {
		
		log.info("param1: "+ arg1);
		log.info("param2: "+ arg2);
		log.info("param3: "+ arg3);
		log.info("param4: "+ arg4);
		log.info("param5: "+ arg5);
		
		model.addAttribute("param1", arg1);
		model.addAttribute("param2", arg2);
		model.addAttribute("param3", arg3);
		model.addAttribute("param4", arg4);
		model.addAttribute("param5", arg5);
		
		return "ch03/receiveParamData";
	}
	
	@GetMapping("/ajaxParam")
	public String ajaxParam() {
		log.info("실행");
		return "ch03/ajaxParam";
	}
	
	@GetMapping("/commandObject")
	public String commandObject(Ch03Dto dto, Model model) {
		
		log.info("param1: "+ dto.getParam1());
		log.info("param2: "+ dto.getParam2());
		log.info("param3: "+ dto.getParam3());
		log.info("param4: "+ dto.isParam4());
		log.info("param5: "+ dto.getParam5());
		
		//JSP로 데이터 전달(CommentObject를 사용할 경우, 자동으로 객체를 VIEW에 전달한다.)
		//model.addAttribute("ch03Dto", dto);
		
		return "ch03/receiveCommandObject";
	}
}
