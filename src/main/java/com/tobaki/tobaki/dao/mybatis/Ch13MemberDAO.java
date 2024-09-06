package com.tobaki.tobaki.dao.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.tobaki.tobaki.dto.Ch13Member;

@Mapper
public interface Ch13MemberDAO {

	int insert(Ch13Member member);

	Ch13Member selectByMid(String mid);

}
