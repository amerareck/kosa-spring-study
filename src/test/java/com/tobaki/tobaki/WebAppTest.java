package com.tobaki.tobaki;

import javax.transaction.Transactional;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.junit4.SpringRunner;

@Transactional
@RunWith(SpringRunner.class)

@SpringJUnitWebConfig(locations={
		"classpath:spring/root/*.xml",
		"classpath:spring/dispatcher/*.xml"
})
public abstract class WebAppTest {
	
}
