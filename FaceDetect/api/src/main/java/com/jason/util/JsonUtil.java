package com.jason.util;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jason.dto.RealData;

public class JsonUtil {
	public static List<RealData> getRealDatas(String strJson){
		List<RealData> realDatas = new ArrayList<>();
		try {
			JsonObject jsonObject = (JsonObject)new JsonParser().parse(strJson);
			String resultStr = jsonObject.get("result").getAsString();
			JsonObject resultObject = (JsonObject) new JsonParser().parse(resultStr);
			String vals = resultObject.get("Value").getAsString();
			System.out.println("vals:"+vals);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("数据解析错误：" + e);
			return null;
		}
		return null;
	}
}
