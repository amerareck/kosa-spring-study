package com.tobaki.tobaki.service;

import com.tobaki.tobaki.dao.Ch12DAO1;
import com.tobaki.tobaki.dao.Ch12DAO2;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor // 매개변수를 갖지 않는 기본 생성자를 생성해라.
//@AllArgsConstructor // 모든 필드를 생성자의 매개변수로 받도록 설정해라.
public class Ch12Service6 {
	private Ch12DAO1 dao1;
	private Ch12DAO2 dao2;
	
	public Ch12Service6(Ch12DAO1 dao1, Ch12DAO2 dao2) {
		super();
		this.dao1 = dao1;
		this.dao2 = dao2;
		log.info("객체 생성");
	}
	
	
}
