package com.tobaki.tobaki.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tobaki.tobaki.dto.Ch13Board;
import com.tobaki.tobaki.dto.Ch13Pager;

@Mapper
public interface Ch13BoardDAO {
	public int insert(Ch13Board board);
	public List<Ch13Board> selectList(Ch13Pager pager);
	public int countRows();
}
