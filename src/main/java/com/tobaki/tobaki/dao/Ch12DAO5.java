package com.tobaki.tobaki.dao;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class Ch12DAO5 implements Ch12DAOInterface {
	public Ch12DAO5() {
		log.info("관리 객체 생성");
	}
}
