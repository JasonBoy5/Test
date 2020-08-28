package com.jason.third.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public void test1() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean");
//		User user = ac.getBean(name, args)
	}
}
