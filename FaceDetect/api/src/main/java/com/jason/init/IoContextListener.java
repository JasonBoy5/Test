package com.jason.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class IoContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("开始初始化");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("结束初始化");
	}

}
