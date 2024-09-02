package com.tobaki.tobaki.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobaki.tobaki.dao.Ch12DAO1;
import com.tobaki.tobaki.dao.Ch12DAO2;
import com.tobaki.tobaki.dao.Ch12DAO3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Ch12Service7 {
	// 필드 주입
	// Autowired, Resource는 기본적으로 타입 주입이다. 타입에 알맞는 빈을 주입시키는 것.
	@Autowired //or @Resource
	private Ch12DAO1 dao1;
	
	// 생성자 주입
	private Ch12DAO2 dao2;
	
	// 세터 주입
	private Ch12DAO3 dao3;
	
	@Autowired // 리소스는 생성자 주입을 할 수 없다.
	public Ch12Service7(Ch12DAO2 dao2) {
		log.info("생성자 주입 실행");
		this.dao2 = dao2;
	}
	
	//@Autowired // 리소스도 올 수 있다.
	@Resource
	public void setCh12DAO3(Ch12DAO3 dao3) {
		log.info("세터 주입 실행");
		this.dao3 = dao3;
	}
}
