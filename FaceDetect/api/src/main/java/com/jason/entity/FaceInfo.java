package com.jason.entity;

public class FaceInfo {
	private String user_id;
	private String recog_time;
	private String recog_type;
	private String photo;
	private String body_temperature;
	private String confidence;
	private int reflectivity;
	private float room_temperature;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRecog_time() {
		return recog_time;
	}
	public void setRecog_time(String recog_time) {
		this.recog_time = recog_time;
	}
	public String getRecog_type() {
		return recog_type;
	}
	public void setRecog_type(String recog_type) {
		this.recog_type = recog_type;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getBody_temperature() {
		return body_temperature;
	}
	public void setBody_temperature(String body_temperature) {
		this.body_temperature = body_temperature;
	}
	public String getConfidence() {
		return confidence;
	}
	public void setConfidence(String confidence) {
		this.confidence = confidence;
	}
	public int getReflectivity() {
		return reflectivity;
	}
	public void setReflectivity(int reflectivity) {
		this.reflectivity = reflectivity;
	}
	public float getRoom_temperature() {
		return room_temperature;
	}
	public void setRoom_temperature(float room_temperature) {
		this.room_temperature = room_temperature;
	}
	@Override
	public String toString() {
		return "FaceInfo [user_id=" + user_id + ", recog_time=" + recog_time + ", recog_type=" + recog_type + ", photo="
				+ photo + ", body_temperature=" + body_temperature + ", confidence=" + confidence + ", reflectivity="
				+ reflectivity + ", room_temperature=" + room_temperature + "]";
	}
	
	
}
