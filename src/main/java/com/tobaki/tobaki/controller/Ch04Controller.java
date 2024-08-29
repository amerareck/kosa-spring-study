package com.tobaki.tobaki.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tobaki.tobaki.dto.Ch04LoginForm;
import com.tobaki.tobaki.dto.Ch04LoginFormValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch04")
public class Ch04Controller {
	
	@ModelAttribute
	public void chNum(Model model) {
		model.addAttribute("chNum", null);
	}
	
	@GetMapping("loginForm")
	public String loginForm() {
		log.info("실행");
		return "ch04/loginForm";
	}
	
	@InitBinder("ch04LoginForm") // 타겟 DTO 작성, 카멜로 작성.
	public void loginFormValidator(WebDataBinder binder) {
		// 바인딩할 Validator 객체 생성해서 바인더에 등록.
		binder.setValidator(new Ch04LoginFormValidator());
	}
	
	@PostMapping("/login")
	public String login(@Valid Ch04LoginForm form, Errors errors, RedirectAttributes redi) {
		log.info("실행");
		
		// 유효성 검증
		if(errors.hasErrors()) {
			return "ch04/loginForm";
		}
		log.info("mid: "+ form.getMid());
		log.info("mpassword: "+ form.getMpassword());
		return "redirect:/";
	}
}
