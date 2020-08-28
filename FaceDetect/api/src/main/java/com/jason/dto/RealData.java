package com.jason.dto;

public class RealData {
	
	private String io;
	private String val;
	
	public String getIo() {
		return io;
	}
	public void setIo(String io) {
		this.io = io;
	}
	public String getVal() {
		return val;
	}
	public void setVal(String val) {
		this.val = val;
	}
	@Override
	public String toString() {
		return "RealData [io=" + io + ", val=" + val + "]";
	}
	
}
