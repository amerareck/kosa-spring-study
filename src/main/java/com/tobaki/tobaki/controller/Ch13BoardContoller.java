package com.tobaki.tobaki.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
import com.tobaki.tobaki.dto.Ch13Pager;
import com.tobaki.tobaki.dto.Ch13WriteBoardForm;
import com.tobaki.tobaki.service.Ch13BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/ch13")
public class Ch13BoardContoller {
	@Autowired
	private Ch13BoardService boardService;
	
	@ModelAttribute
	public void getChNum(Model model) {
		model.addAttribute("chNum", "ch13");
	}
	
	@GetMapping("/writeBoardForm")
	public String writeBoardForm() {
		log.info("실행");
		
		return "ch13/writeBoardForm";
	}
	
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
	
	@GetMapping("/boardList")
	public String boardList(Model model, @RequestParam(defaultValue="1") int pageNo) {
		log.info("실행");
		
		int totalRows = boardService.getTotalRows();
		Ch13Pager pager = new Ch13Pager(10, 5, totalRows, pageNo);
		model.addAttribute("pager", pager);

		List<Ch13Board> list = boardService.getBoardList(pager);
		model.addAttribute("list", list);
		
		return "ch13/boardList";
	}
}
