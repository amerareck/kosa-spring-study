package com.tobaki.tobaki.service;

import com.tobaki.tobaki.dao.Ch12DAO1;
import com.tobaki.tobaki.dao.Ch12DAO2;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Ch12Service5 {
	private Ch12DAO1 dao1;
	private Ch12DAO2 dao2;
	private String str;
	private int num;
	
	public Ch12Service5() {
		log.info("관리 객체 생성");
	}
}
