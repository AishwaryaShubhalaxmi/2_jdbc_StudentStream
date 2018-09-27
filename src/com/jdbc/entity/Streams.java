package com.jdbc.entity;

public class Streams {

	private String stream_Id;
	private String stream_name;
	public Streams(String stream_Id, String stream_name) {
		super();
		this.stream_Id = stream_Id;
		this.stream_name = stream_name;
	}
	public Streams() {
		// TODO Auto-generated constructor stub
	}
	public String getStream_Id() {
		return stream_Id;
	}
	public void setStream_Id(String stream_Id) {
		this.stream_Id = stream_Id;
	}
	public String getStream_name() {
		return stream_name;
	}
	public void setStream_name(String stream_name) {
		this.stream_name = stream_name;
	}
	
}
