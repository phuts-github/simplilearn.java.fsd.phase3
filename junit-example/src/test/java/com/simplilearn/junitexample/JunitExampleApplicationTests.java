package com.simplilearn.junitexample;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.apache.logging.log4j.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Spring Boot Apllication Test Class")
//@Disabled("Class disabled")
class JunitExampleApplicationTests {
	
	static Logger log = LogManager.getLogger();
	
	@BeforeAll
	@Test
	static void setup () {
		log.info("before all test methods - setup");
	}

	@BeforeEach
	@Test
	void initTop() {
		log.info("BeforeEach - inside the initTop");
	}

	@AfterEach
	@Test
	void initMid() {
		log.info("AfterEach - inside the initMid");
	}

	@AfterAll
	@Test
	static void initLast() {
		log.info("AfterAll - inside the initLast");
	}
	
	@Test
	@DisplayName("testMethod1 tets")
	void testMethod1() {
		log.info("Test - inside the test method 1");
	}
	
	@Test	
	@DisplayName("testMethod2 tets")
	void testMethod2() {
		log.info("Test - inside the test mehod 2");
	}

	@Test
	@DisplayName("testMethod3 tets")
	@Disabled("Method displayed")
	void testMethod3() {
		log.info("Test - inside the test mehod 3");
	}
	
	@Test
	@DisplayName("testMethod4 test")
	void testMethod4() {
		log.info("Test - inside the test mehod 4");
	}
	
}
