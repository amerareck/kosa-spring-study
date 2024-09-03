package com.tobaki.tobaki.dao.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.tobaki.tobaki.dto.Ch13Board;

@Mapper
public interface Ch13BoardDAO {
	public int insert(Ch13Board board);
}
