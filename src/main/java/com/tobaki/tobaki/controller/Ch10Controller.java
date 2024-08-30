package com.tobaki.tobaki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tobaki.tobaki.exception.Ch10CustomException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch10")
public class Ch10Controller {
	@ModelAttribute
	public void setChNum(Model model) {
		model.addAttribute("chNum", "ch10");
	}
	
	@GetMapping("/handlingException1")
	public String handlingException1(String data, RedirectAttributes redi) {
		log.info("실행");
		
		// 이렇게 해도 된다. 단, 다른 메소드 영역에서 같은 널포인터예외가 발생하면 그 메서드에서 다시 작성해줘야 한다...
		try {
			if(data.equals("java")) {
				//data가 제공되지 않을 경우, NullPointerException 발생
			}
		} catch(NullPointerException npe) {
			return "ch10/nullPointerException";
		}

		
		return "redirect:/";
	}
	
	@GetMapping("/handlingException2")
	public String handlingException2(String data, RedirectAttributes redi) {
		log.info("실행");
		
		if(data.equals("java")) {
			//data가 제공되지 않을 경우, NullPointerException 발생
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/handlingException3")
	public String handlingException3(String data, RedirectAttributes redi) {
		log.info("실행");
		
		if(data==null) {
			//Ch10CustomException 발생
			throw new Ch10CustomException("무슨무슨 에러로 인하여 예외 발생.");
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/handlingException4")
	public String handlingException4(String data, RedirectAttributes redi) {
		log.info("실행");
		int value = Integer.parseInt(data);
		
		return "redirect:/"+String.valueOf(value);
	}

}
