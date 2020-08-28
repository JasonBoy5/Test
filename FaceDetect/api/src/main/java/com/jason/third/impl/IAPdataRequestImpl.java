package com.jason.third.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.jason.dto.RealData;
import com.jason.third.IAPdataRequest;
import com.jason.util.JsonUtil;

public class IAPdataRequestImpl implements IAPdataRequest{

	@Override
	public List<RealData> getRealData(String iap_url, String strs_io) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = null;
		String result = "";
		List<RealData> realDatas = new ArrayList<>();
		try{
			URL realURL = new URL(iap_url + "/v1/DoorIntf/GetIOvalues?ioAddrs="+strs_io);
//			URL realURL = new URL("http://192.168.27.128:8055/v1/DoorIntf/GetIOvalues?ioAddrs="+io);
			HttpURLConnection connection = (HttpURLConnection)realURL.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Connection", "keep-Alive");
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while((line = in.readLine()) != null){
				result += line;
			}
			
			realDatas = JsonUtil.getRealDatas(result);
			
		}catch(Exception e){
			realDatas = null;
			System.out.println("iap_url->" + iap_url);
			System.out.println("发送GET请求异常！");
			e.printStackTrace();
		}finally{
			if(null != in){
				in.close();
				in = null;
			}
		}
		return realDatas;
	}


}
