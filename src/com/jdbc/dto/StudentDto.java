package com.jdbc.dto;

public class StudentDto {
	private String stream_id;
	private int students_count;

	
	public StudentDto(String stream_id, int students_count) {
		super();
		this.stream_id = stream_id;
		this.students_count = students_count;
	}
	public String getStream_id() {
		return stream_id;
	}
	public void setStream_id(String stream_id) {
		this.stream_id = stream_id;
	}
	public int getStudents_count() {
		return students_count;
	}
	public void setStudents_count(int students_count) {
		this.students_count = students_count;
	}
		
	

}
