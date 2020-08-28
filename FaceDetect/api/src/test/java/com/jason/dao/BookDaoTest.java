package com.jason.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jason.BaseTest;
import com.jason.entity.Book;

public class BookDaoTest extends BaseTest{
	
	@Autowired
	private BookDao bookDao;

//	@Test
//	public void testQueryById() throws Exception {
//		long bookId = 1000;
//		Book book = bookDao.queryById(bookId);
//		System.out.println(book);
//	}

	@Test
	public void testQueryAll() throws Exception {
		List<Book> books = bookDao.queryAll(0, 4);
		for (Book book : books) {
			System.out.println(book);
		}
	}

//	@Test
//	public void testReduceNumber() throws Exception {
//		long bookId = 1000;
//		int update = bookDao.reduceNumber(bookId);
//		System.out.println("update=" + update);
//	}
//	
//	@Test
//	public void testBeanIOC() throws Exception{
//		System.out.println("spring bean ioc");
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("main/java/bean-dao.xml");
//		BookDao myBookDao = (BookDao)ctx.getBean("myBookDao");
//		long bId = 1001;
//		int upd = myBookDao.reduceNumber(bId);
//		System.out.println("update="+upd);
//	}
}
