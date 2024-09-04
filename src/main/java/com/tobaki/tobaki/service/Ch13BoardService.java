package com.tobaki.tobaki.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobaki.tobaki.dao.mybatis.Ch13BoardDAO;
import com.tobaki.tobaki.dto.Ch13Board;
import com.tobaki.tobaki.dto.Ch13Pager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Ch13BoardService {
	@Autowired
	private Ch13BoardDAO boardDAO;
	
	public List<Ch13Board> getBoardList() {
		return null;
	}
	
	public Ch13Board getBoard(int bno) {
		return null;
	}
	
	public void writeBoard(Ch13Board board) {
		log.info("실행");
		boardDAO.insert(board);
	}
	
	public void updateBoard(Ch13Board board) {
		
	}
	
	public void deleteBoard(int bno) {
		
	}

	public int getTotalRows() {
		return boardDAO.countRows();
	}

	public List<Ch13Board> getBoardList(Ch13Pager pager) {
		return boardDAO.selectList(pager);
	}
}
