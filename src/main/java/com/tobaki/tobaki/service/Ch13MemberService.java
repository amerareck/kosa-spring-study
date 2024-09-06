package com.tobaki.tobaki.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tobaki.tobaki.dao.mybatis.Ch13MemberDAO;
import com.tobaki.tobaki.dto.Ch13Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Ch13MemberService {
	public enum JoinResult {
		SUCCESS,
		FAIL_DUPLICATED_MID
	}
	
	public enum LoginResult {
		SUCCESS,
		FAIL_MID,
		FAIL_MPASSWORD,
		FAIL_ENABLED
	}
	
	@Resource
	private Ch13MemberDAO memberDAO;
	
	public JoinResult join(Ch13Member member) {
		boolean exist = isMid(member.getMid());
		if (exist) {
			return JoinResult.FAIL_DUPLICATED_MID;
		}
		memberDAO.insert(member);
		return JoinResult.SUCCESS;
	}
	
	public boolean isMid(String mid) {
		Ch13Member member = memberDAO.selectByMid(mid);
		return member != null;
	}
	
	public LoginResult login(Ch13Member member) {
		Ch13Member dbMember = memberDAO.selectByMid(member.getMid());
		if(dbMember == null) {
			return LoginResult.FAIL_MID;
		}
		if(!dbMember.isMenabled()) {
			return LoginResult.FAIL_ENABLED;
		}
		if(!dbMember.getMpassword().equals(member.getMpassword())) {
			return LoginResult.FAIL_MPASSWORD;
		}
		return LoginResult.SUCCESS;
	}
	
	public void logout(String mid) {
		// 세션으로 로그아웃을 처리할 것이라면, 컨트롤러에서 처리하면 되므로 굳이 필요는 없음.
	}
}
