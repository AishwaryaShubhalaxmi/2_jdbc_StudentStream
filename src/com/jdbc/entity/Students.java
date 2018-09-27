package com.jdbc.entity;

import java.util.stream.Stream;

public class Students {
	private int student_id;
	private String student_name;
	private Streams stream;
	
	public void setStream(Streams stream) {
		this.stream = stream;
	}
	public Students() {
		// TODO Auto-generated constructor stub
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public Streams getStreams() {
		return stream;
	}
   
	
	

}
