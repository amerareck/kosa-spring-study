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
		return boardDAO.selectByBno(bno);
	}
	
	public void writeBoard(Ch13Board board) {
		log.info("실행");
		boardDAO.insert(board);
	}
	
	public int updateBoard(Ch13Board board) {
		return boardDAO.update(board);
	}
	
	public int deleteBoard(int bno) {
		return boardDAO.delete(bno);
	}

	public int getTotalRows() {
		return boardDAO.countRows();
	}

	public List<Ch13Board> getBoardList(Ch13Pager pager) {
		return boardDAO.selectList(pager);
	}
	
	public Ch13Board getBoardAttach(int bno) {
		return boardDAO.selectAttachByBno(bno);
	}

	public int createHitCount(int bno) {
		return boardDAO.updateHitCount(bno);
	}
}
