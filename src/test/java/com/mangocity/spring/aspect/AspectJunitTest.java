package com.mangocity.spring.aspect;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class AspectJunitTest {
	@Autowired
	private TestBean test;

	@Before
	public void before() {
	}

	@Test
	public void testAspect() {
		test.test();
	}
}
