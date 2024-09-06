package com.tobaki.tobaki.dao;

import org.apache.ibatis.annotations.Mapper;

import com.tobaki.tobaki.dto.Ch13Member;

@Mapper
public interface Ch13MemberDAO {
	
	public int insert(Ch13Member member);
	public Ch13Member selectByMid(String mid);
}
