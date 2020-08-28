package com.jason.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jason.entity.DevLevel;

/**
 * @author Jason_boy5
 *
 */
public interface DevLevelDao {
	/**
	 * @param dev_code
	 * @return 通过设备编码查询液位计信息
	 */
	DevLevel queryByDevCode(String dev_code);
	
	/**
	 * @param addr  iapdata地址
	 * @param offset 取值起点
	 * @param limit 记录数
	 * @return
	 */
	List<DevLevel> queryAll(@Param("addr_iapdata") String addr_iapdata, @Param("offset") int offset, @Param("limit") int limit);
}
