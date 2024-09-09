package com.tobaki.tobaki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tobaki.tobaki.dto.Ch13Account;
import com.tobaki.tobaki.service.Ch15AccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch15")
public class Ch15Controller {
	@Autowired
	private Ch15AccountService accountService;
	
	@ModelAttribute
	public void getChNum(Model model) {
		model.addAttribute("chNum", "ch15");
	}
	
	@GetMapping("/accountList")
	public String accountList(Model model) {
		log.info("실행");
		
		List<Ch13Account> list = accountService.getAccountList();
		model.addAttribute("list", list);
		
		return "ch15/accountList";
	}
	
	@PostMapping("transfer")
	public String transfer(int fromAno, int toAno, int amount) {
		accountService.transfer(fromAno, toAno, amount);
		
		
		return "redirect:/ch15/accountList";
	}
	
	
}
