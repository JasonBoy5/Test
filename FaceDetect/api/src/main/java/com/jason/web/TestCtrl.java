package com.jason.web;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jason.dao.BookDao;

@Controller
@RequestMapping("/TestCtrl")
public class TestCtrl {
	
	
	
	public TestCtrl() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println(this.getClass().getName());
	}
	
	@SuppressWarnings("resource")
	@RequestMapping("/testBean")
	public void testBean() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-dao.xml");
		BookDao bookDao = (BookDao) ctx.getBean("myBookDao");
		System.out.println(bookDao.queryById(10000));
	}

	@RequestMapping("/test")
	public void test2(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String ip = request.getHeader("x-forwarded-for");
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		System.out.println("request IP addr : "+ip);
		PrintWriter out = response.getWriter();
		out.println("success");
	}
}
