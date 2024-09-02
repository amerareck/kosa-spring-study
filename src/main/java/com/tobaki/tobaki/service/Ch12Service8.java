package com.tobaki.tobaki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tobaki.tobaki.dao.Ch12DAOInterface;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@Service
public class Ch12Service8 {
	//Ch12DAOInterface를 상속하는 bean이 2개가 있으므로 
	//반드시 특정한 bean의 이름(id)를 작성해서 스프링이 하나의 빈을 주입할 수 있도록 해주어야 한다.
	//@Autowired는 @Qualifier를, @Resource는 속성 name의 값을 빈의 id로 지정해주면 된다.
	@Autowired @Qualifier("ch12DAO4")
	private Ch12DAOInterface dao;
	
	public Ch12Service8() {
		log.info("관리 객체 생성");
	}
}
