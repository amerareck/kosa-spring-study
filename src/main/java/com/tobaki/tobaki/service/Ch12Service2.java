package com.tobaki.tobaki.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch12Service2 {
	
	public static Ch12Service2 getInstance() {
		log.info("인스턴스 호출");
		return new Ch12Service2();
	}
	
	public Ch12Service3 getCh12Service3() {
		return new Ch12Service3();
	}
}
