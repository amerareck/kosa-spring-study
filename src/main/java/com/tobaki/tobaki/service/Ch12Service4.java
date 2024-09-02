package com.tobaki.tobaki.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service // Controller, Component, Repository, Service 대표적 4가지 어노테이션은, 선언만으로 bean으로 등록된다.
public class Ch12Service4 {
	public Ch12Service4() {
		log.info("관리 객체 생성");
	}
}
