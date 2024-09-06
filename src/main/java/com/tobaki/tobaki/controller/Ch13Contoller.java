package com.tobaki.tobaki.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.tobaki.tobaki.dto.Ch13Board;
import com.tobaki.tobaki.dto.Ch13Member;
import com.tobaki.tobaki.dto.Ch13Pager;
import com.tobaki.tobaki.dto.Ch13UpdateBoardForm;
import com.tobaki.tobaki.dto.Ch13WriteBoardForm;
import com.tobaki.tobaki.interceptor.LoginCheck;
import com.tobaki.tobaki.service.Ch13BoardService;
import com.tobaki.tobaki.service.Ch13MemberService;
import com.tobaki.tobaki.service.Ch13MemberService.JoinResult;
import com.tobaki.tobaki.service.Ch13MemberService.LoginResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch13")
public class Ch13Contoller {
	@Autowired
	private Ch13BoardService boardService;
	@Resource
	private Ch13MemberService memberService;
	
	
	@ModelAttribute
	public void getChNum(Model model) {
		model.addAttribute("chNum", "ch13");
	}
	
	@LoginCheck
	@GetMapping("/writeBoardForm")
	public String writeBoardForm() {
		log.info("실행");
		
		return "ch13/writeBoardForm";
	}
	
/*	
 	@PostMapping("/writeBoard")
	public String writeBoard(Ch13WriteBoardForm form) throws IOException {
		Ch13Board board = new Ch13Board();
		board.setBtitle(form.getBcontent());
		board.setBcontent(form.getBcontent());
		board.setMid("user");
		MultipartFile battach = form.getBattach();
		if(!battach.isEmpty()) {
			board.setBattachoname(battach.getOriginalFilename());
			board.setBattachtype(battach.getContentType());
			String fileName = new Date().getTime() + "-" + battach.getOriginalFilename();
			board.setBattachsname(fileName);
			String saveDir = "C:/2024-oti/eclipse-workspace/uploadFiles";
			File file = new File(saveDir, fileName);
			battach.transferTo(file);
		}
		
		boardService.writeBoard(board);
		
		return "redirect:/";
	}
*/
 	@PostMapping("/writeBoard")
	public String writeBoard(Ch13WriteBoardForm form, HttpSession session) throws IOException {
		Ch13Board board = new Ch13Board();
		board.setBtitle(form.getBtitle());
		board.setBcontent(form.getBcontent());
		//board.setMid("user");
		Ch13Member member = (Ch13Member) session.getAttribute("login");
		board.setMid(member.getMid());
		
		MultipartFile battach = form.getBattach();
		if(!battach.isEmpty()) {
			board.setBattachoname(battach.getOriginalFilename());
			board.setBattachtype(battach.getContentType());
			board.setBattachdata(battach.getBytes());
		}
		
		boardService.writeBoard(board);
		
		return "redirect:/ch13/boardList";
	}
	
 	@LoginCheck
	@GetMapping("/boardList")
	public String boardList(Model model, @RequestParam(defaultValue="1") int pageNo, HttpSession session) {
		log.info("실행");
		
		int totalRows = boardService.getTotalRows();
		Ch13Pager pager = new Ch13Pager(10, 5, totalRows, pageNo);
		session.setAttribute("pager", pager);

		List<Ch13Board> list = boardService.getBoardList(pager);
		model.addAttribute("list", list);
		
		return "ch13/boardList";
	}
	
	@LoginCheck
	@GetMapping("/detailBoard")
	public String detailBoard(int bno, Model model) {
		log.info("실행");
		Ch13Board board = boardService.getBoard(bno);
		model.addAttribute("board", board);
		return "ch13/detailBoard";
	}
	
	@LoginCheck
	@GetMapping("/detailBoardAddHitCount")
	public String detailBoardAddHitCount(int bno, Model model) {
		log.info("실행");
		boardService.createHitCount(bno);
		return detailBoard(bno, model);
	}
	
	@LoginCheck
	@GetMapping("/attachDownload")
	public void attachDownload(int bno, HttpServletResponse res) throws IOException {
		log.info("실행");
		Ch13Board board = boardService.getBoardAttach(bno);
		
		String contentType = board.getBattachtype();
		String fileName = board.getBattachoname();
		String encodingFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		res.setContentType(contentType);
		res.setHeader("Content-Disposition", "attachment; filename=\""+encodingFileName+"\"");

		OutputStream out = res.getOutputStream();
		out.write(board.getBattachdata());
		out.flush();
		out.close();
	}
	
	@LoginCheck
	@GetMapping("/updateBoardForm")
	public String updateBoardForm(int bno, Model model) {
		log.info("실행");
		log.info(""+bno);
		Ch13Board board = boardService.getBoard(bno);
		log.info(board.toString());
		model.addAttribute("board", board);
		return "ch13/updateBoardForm";
	}
	
	@PostMapping("/updateBoardForm")
	public String upadteBoardForm(Ch13UpdateBoardForm form) throws IOException {
		log.info("실행");
		Ch13Board board = new Ch13Board();
		board.setBno(form.getBno());
		board.setBtitle(form.getBtitle());
		board.setBcontent(form.getBcontent());
		MultipartFile mf = form.getBattach();
		if(!mf.isEmpty()) {
			board.setBattachoname(mf.getOriginalFilename());
			board.setBattachtype(mf.getContentType());
			board.setBattachdata(mf.getBytes());
		}
		
		boardService.updateBoard(board);
		
		return "redirect:/ch13/detailBoard?bno="+form.getBno();
	}
	
	@LoginCheck
	@GetMapping("/deleteBoard")
	public String deleteBoard(int bno, HttpSession session) {
		log.info("실행");
		Ch13Pager pager = (Ch13Pager) session.getAttribute("pager");
		boardService.deleteBoard(bno);
		
		return "redirect:/ch13/boardList?pageNo="+pager.getPageNo();
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		log.info("실행");
		return "ch13/joinForm";
	}
	
	@PostMapping("/join")
	public String join(Ch13Member member, Model model) {
		log.info("실행");
		member.setMenabled(true);
		log.info(member.toString());
		
		JoinResult joinResult = memberService.join(member);
		if(joinResult == JoinResult.FAIL_DUPLICATED_MID) {
			String errorMessage = "아이디가 존재합니다.";
			model.addAttribute("errorMessage", errorMessage);
			return "ch13/joinForm";
			
		} else { // JoinResult.SUCCESS 일 경우.
			return "redirect:/ch13/loginForm";
		}
	}
	
	@GetMapping("/loginForm")
	public String loginForm() {
		log.info("실행");
		return "ch13/loginForm";
	}
	
	@PostMapping("/login")
	public String login(Ch13Member member, Model model, HttpSession session) {
		log.info("실행");

		LoginResult loginResult = memberService.login(member);
		if(loginResult == LoginResult.FAIL_MID) {
			model.addAttribute("errorMid", "아이디가 존재하지 않습니다.");
			return "ch13/loginForm";
		} else if(loginResult == LoginResult.FAIL_MPASSWORD) {
			model.addAttribute("errorMpassword", "비밀번호가 일치하지 않습니다.");
			return "ch13/loginForm";
		} else if(loginResult == LoginResult.FAIL_ENABLED) {
			return "redirect:/";
		} else { //LoginResult.SUCCESS 일 경우.
			session.setAttribute("login", member);
			return "redirect:/";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:/ch13/loginForm";
	}
}
