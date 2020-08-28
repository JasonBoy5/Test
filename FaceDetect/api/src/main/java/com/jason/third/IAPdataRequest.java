package com.jason.third;

import java.util.List;

import com.jason.dto.RealData;

public interface IAPdataRequest {
	public List<RealData> getRealData(String iap_url,String strs_io) throws Exception;
}
