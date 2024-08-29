package com.tobaki.tobaki.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tobaki.tobaki.dto.Ch06Cart;
import com.tobaki.tobaki.dto.Ch06Item;
import com.tobaki.tobaki.dto.Ch06Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch06")
public class Ch06Controller {
	
	@ModelAttribute
	public void chNum(Model model) {
		model.addAttribute("chNum", null);
	}
	
	@GetMapping("forward")
	public String forward(Model model, HttpServletRequest req) {
		log.info("실행");
		Ch06Member member = new Ch06Member();
		member.setMid("user1");
		member.setMname("사용자1");
		member.setMemail("user@mycompany.com");
		
		//방법 1
		model.addAttribute("member1", member);
		
		//방법 2
		req.setAttribute("member2", member);
		
		return "ch06/forward";
	}
	
	@GetMapping("redirect")
	public String redirect(Model model, HttpServletRequest req, HttpSession session) {
		log.info("실행");
		Ch06Member member = new Ch06Member();
		member.setMid("user1");
		member.setMname("사용자1");
		member.setMemail("user@mycompany.com");
		
		//방법 1
		model.addAttribute("member1", member);
		
		//방법 2
		req.setAttribute("member2", member);
		
		//방법 3
		session.setAttribute("member", member);
		return "redirect:/ch06/sessionData";
	}
	
	@GetMapping("sessionData")
	public String sessionData(String queryString, HttpSession session) {
		log.info("실행");
		
		if(queryString != null && queryString.equals("redirect") || session.getAttribute("member") == null) {
			return "redirect:/ch06/redirect";
		}
		
		Ch06Member member = (Ch06Member) session.getAttribute("member");
		log.info("mid: "+member.getMid());
		log.info("mname: "+member.getMname());
		
		return "ch06/sessionData";
	}
	
	@GetMapping("cartView")
	public String cartView(String pno, HttpSession session) {
		log.info("실행");
		
		return "ch06/cartView";
	}
	
	@GetMapping("productList")
	public String productList(Model model) {
		log.info("실행");
		List<Ch06Item> productList = new ArrayList<Ch06Item>();
		for(int i=1; i<=5; i++) {
			Ch06Item item = new Ch06Item();
			item.setPno("p"+i);
			item.setPname("상품"+i);
			productList.add(item);
		}
		model.addAttribute("productList", productList);
		return "ch06/productList";
	}
	
	@GetMapping("cartAdd")
	public String cartAdd(Ch06Item item, HttpSession session, RedirectAttributes redi) {
		// 세션에서 카트 가져오기
		Ch06Cart cart = (Ch06Cart) session.getAttribute("cart");
		// 세션에 카트가 없다면, 생성해서 삽입
		if(cart == null) {
			cart = new Ch06Cart();
			session.setAttribute("cart", cart);
		}
		
		//상품 아이템을 카트에 추가
		cart.addItem(item);
		return "redirect:/ch06/cartView";
	}
	
	@GetMapping("deleteItem")
	public String deleteItem(String pno, HttpSession session) {
		Ch06Cart cart = (Ch06Cart) session.getAttribute("cart");
		log.info("pno: "+pno);
		
		Iterator<Ch06Item> i = cart.getContents().iterator();
		while(i.hasNext()) {
			Ch06Item item = i.next();
			if(item.getPno().equals(pno)) {
				cart.removeItem(item);
			}
		}
		
		return "ch06/cartView";
	}
	
}
