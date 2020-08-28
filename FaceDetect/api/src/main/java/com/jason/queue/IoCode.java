package com.jason.queue;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

@Component
public class IoCode {
	
//	@Autowired
//	private static BookDao bookDao;
	
	public static Map<String, String> bookMap;
	
	
	
	public IoCode() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass().getName());
	}



	static {
		bookMap = new TreeMap<String,String>();
//		long bookId = 1000;
//		int update = bookDao.reduceNumber(bookId);
//		System.out.println("IoCode update=" + update);
		System.out.println("IoCode update=");
	}
}
