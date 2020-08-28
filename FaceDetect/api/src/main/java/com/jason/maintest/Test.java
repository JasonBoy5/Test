package com.jason.maintest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jason.dao.BookDao;

public class Test {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-dao.xml");
		BookDao temp = (BookDao)ctx.getBean("myBookDao",BookDao.class);
		long bookId = 1000;
		int update = temp.reduceNumber(bookId);
		System.out.println("update=" + update);
	}
}
