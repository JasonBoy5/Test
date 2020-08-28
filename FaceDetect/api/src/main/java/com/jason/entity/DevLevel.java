package com.jason.entity;

public class DevLevel {
	private String dev_code;
	private String dev_name;
	private String site_code;
	private String io;
	private String addr_data;
	

	public String getDev_code() {
		return dev_code;
	}

	public void setDev_code(String dev_code) {
		this.dev_code = dev_code;
	}

	public String getDev_name() {
		return dev_name;
	}

	public void setDev_name(String dev_name) {
		this.dev_name = dev_name;
	}

	public String getSite_code() {
		return site_code;
	}

	public void setSite_code(String site_code) {
		this.site_code = site_code;
	}

	public String getIo() {
		return io;
	}

	public void setIo(String io) {
		this.io = io;
	}

	public String getAddr_data() {
		return addr_data;
	}

	public void setAddr_data(String addr_data) {
		this.addr_data = addr_data;
	}

	@Override
	public String toString() {
		return "DevLevel [dev_code=" + dev_code + ", dev_name=" + dev_name + ", site_code=" + site_code + ", io=" + io
				+ ", addr_data=" + addr_data + "]";
	}
	
	
}
