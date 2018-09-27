package com.jdbc.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.jdbc.dao.DaoImpl;
import com.jdbc.dto.StudentDto;
import com.jdbc.entity.Streams;
import com.jdbc.entity.Students;
import com.jdbc.exception.Daoexception;

public class MainClass {

	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	System.out.println("enter your choice: 1)insert into students 2)getStudentCount");
	int choice=sc.nextInt();
	DaoImpl dao= new DaoImpl();
	switch(choice) {
	case 1:
		
		System.out.println("enter the number of students");
		int n= sc.nextInt();
		ArrayList<Students> arr= new ArrayList<Students>();
		for(int i=0;i<n;i++) {
			Students s= new Students();
			Streams stream=new Streams();
			System.out.println("enter id");
			int id=sc.nextInt();
			s.setStudent_id(id);
			System.out.println("enter name");
			String name=sc.next();
			s.setStudent_name(name);
			System.out.println("enter stream_name");
			String stream_name=sc.next();
			
			String stream_id=dao.getStreamId(stream_name);
			stream.setStream_name(stream_name);
			stream.setStream_Id(stream_id);
	        s.setStream(stream);
			arr.add(s);
	     }
		try {
			dao.insertStudents(arr);
		} catch (Daoexception e) {
			e.printStackTrace();
		}
		System.out.println("data inserted");
		break;
		
	case 2:
		try {
			ArrayList<StudentDto> arr1= new ArrayList<StudentDto>();
			arr1=dao.getsStudentCount();
			for(StudentDto stud1:arr1) {
				System.out.println(stud1.getStream_id()+ " "+ stud1.getStudents_count());
			}
		} catch (Daoexception e) {
			e.printStackTrace();
		}
		break;
	}
    
		
	}

}
