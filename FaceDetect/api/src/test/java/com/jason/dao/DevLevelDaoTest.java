package com.jason.dao;


import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jason.BaseTest;
import com.jason.entity.DevLevel;

public class DevLevelDaoTest extends BaseTest{
	@Autowired
	private DevLevelDao devLevelDao;

	@Test
	public void testQueryById() throws Exception {
		String dev_code = "LM300402";
		DevLevel level = devLevelDao.queryByDevCode(dev_code);
		System.out.println(level.getDev_name());
	}

	@Test
	public void testQueryAll() throws Exception {
		List<DevLevel> levels = devLevelDao.queryAll("10.0.26.56",0, 4);
		System.out.println("success!!!");
		for (DevLevel level : levels) {
			System.out.println(level.getDev_code());
		}
	}
}
