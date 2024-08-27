package com.tobaki.tobaki.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tobaki.tobaki.dto.Ch02LoginResult;
import com.tobaki.tobaki.interceptor.LoginCheck;

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
	
	@GetMapping("/getLocationHref")
	public String getLocationHref(String bno, String bkind) {
		log.info("실행");
		log.info("bno: "+ bno);
		log.info("bkind: "+ bkind);
		return "ch02/getMethod";
	}
	
	@GetMapping("/getAjax1")
	public String getAjax(String bno, String bkind) {
		log.info("실행");
		log.info("bno: "+ bno);
		log.info("bkind: "+ bkind);
		return "ch02/ajaxFragmentHtml";
	}
	
	@GetMapping("/getAjax2")
	public String getAjax2(String bno, String bkind) {
		log.info("실행");
		log.info("bno: "+ bno);
		log.info("bkind: "+ bkind);
		return "ch02/ajaxJson";
	}
	
	@RequestMapping(value="/postFormTag", method=RequestMethod.POST)
	public String postFormTag(String bno, String bkind) {
		log.info("실행");
		log.info("bno: "+ bno);
		log.info("bkind: "+ bkind);
		// redirect:/ - 요청 경로로 다시 요청하라는 리다이렉트 응답.
		return "redirect:/";
	}
	
	@PostMapping("/postAjax1")
	public String postAjax(String bno, String bkind) {
		log.info("실행");
		log.info("bno: "+ bno);
		log.info("bkind: "+ bkind);
		return "ch02/ajaxFragmentHtml";
	}
	
	@PostMapping("/postAjax2")
	public String postAjax2(String bno, String bkind) {
		log.info("실행");
		log.info("bno: "+ bno);
		log.info("bkind: "+ bkind);
		return "ch02/ajaxJson";
	}
	
	@GetMapping("/returnModelAndView")
	public ModelAndView returnModelAndView() {
		log.info("실행");
		ModelAndView mav = new ModelAndView();
		mav.addObject("bno", 15);
		mav.addObject("bkind", "notice");
		mav.addObject("mid", "아이디 전송요");
		mav.addObject("memail", "email@gail.com");
		mav.setViewName("ch02/returnModelAndView");
		return mav;
	}
	
	@GetMapping("/returnVoid")
	public void returnVoid(HttpServletResponse res) throws IOException {
		log.info("실행");
		
		//생성하고자 할 json
		//{"result": "success", "mid": "user1"}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("result", "success");
		jsonObject.put("mid", "user1");
		String json = jsonObject.toString();
		//log.info(json);
		//INFO  com.mycompany.springframework.controller.Ch02Controller.returnVoid() - {"result":"success","mid":"user1"}
		
		//응답 생성
		//헤더 - contentType, 본문 - 데이터를 보내는 것.
		res.setContentType("application/json; charset=UTF-8");
		PrintWriter pw = res.getWriter();
		pw.println(json);
		pw.flush();
		pw.close();
	}
	
	//응답 헤더는 produces에 기술된 내역으로, 응답 본문은 @ResponseBody을 통해 리턴되는 값으로 대응된다.
	@GetMapping(value="/returnObject", produces="application/json; charset=UTF-8")
	@ResponseBody
	public Ch02LoginResult returnObject() {
		log.info("실행");
		
		Ch02LoginResult obj = new Ch02LoginResult();
		obj.setResult("sucess");
		obj.setMid("user1");
		return obj;
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		log.info("실행");
		return "ch02/loginForm";
	}
	
	@PostMapping("/login")
	public String login(String mid, String mpassword, HttpSession session) {
		log.info("실행");
		log.info("mid: " + mid);
		log.info("mpassword: " + mpassword);
		//세션에 로그인 정보 저장
		session.setAttribute("login", mid);
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(String mid, String mpassword, HttpSession session) {
		log.info("실행");
		//세션에 로그인 정보 삭제
		session.removeAttribute("login");
		return "redirect:/ch02/loginForm";
	}
	
	@LoginCheck
	@GetMapping("/mypage")
	public String myPage() {
		log.info("실행");
		return "ch02/mypage";
	}
}
