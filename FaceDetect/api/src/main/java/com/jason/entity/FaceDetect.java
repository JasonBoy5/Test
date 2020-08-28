package com.jason.entity;

import java.util.List;

public class FaceDetect {
	private String sn;
	private String Count;
	private List<FaceInfo> logs;
	
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getCount() {
		return Count;
	}
	public void setCount(String count) {
		Count = count;
	}
	public List<FaceInfo> getLogs() {
		return logs;
	}
	public void setLogs(List<FaceInfo> logs) {
		this.logs = logs;
	}
	
}
