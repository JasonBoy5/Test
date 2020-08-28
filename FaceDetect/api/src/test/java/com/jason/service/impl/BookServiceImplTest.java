package com.jason.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jason.BaseTest;
import com.jason.dto.AppointExecution;
import com.jason.service.BookService;

public class BookServiceImplTest extends BaseTest {

	@Autowired
	private BookService bookService;

	@Test
	public void testAppoint() throws Exception {
		long bookId = 1001;
		long studentId = 12345678910L;
		AppointExecution execution = bookService.appoint(bookId, studentId);
		System.out.println(execution);
	}

}
