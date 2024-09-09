package com.tobaki.tobaki.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tobaki.tobaki.dto.Ch13Account;

@Mapper
public interface Ch13AccountDAO {

	public List<Ch13Account> selectAll();

	public Ch13Account selectByAno(int fromAno);

	public int update(Ch13Account toAccount);

}
