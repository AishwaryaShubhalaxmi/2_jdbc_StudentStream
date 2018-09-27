package com.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jdbc.dto.StudentDto;
import com.jdbc.entity.Students;
import com.jdbc.exception.Daoexception;
import com.jdbc.utility.Utility;

public class DaoImpl {
	Utility util=new Utility();
	Connection con;
	
	public String getStreamId(String streamName) {
		con=util.openConnection();
		String stream_Id="";
		try {
			String query="select streams.stream_id from streams where streams.stream_name=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,streamName );
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			stream_Id=rs.getString(1);
			System.out.println(stream_Id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stream_Id;
	}
	
    public boolean insertStudents(ArrayList<Students> arr) throws Daoexception{
	con=util.openConnection();
	
	try {
		String query1="insert into students values(?,?,?)";
		PreparedStatement ps=con.prepareStatement(query1);
		for(Students s:arr) {
		ps.setInt(1,s.getStudent_id() );
		ps.setString(2, s.getStudent_name());
	    ps.setString(3,s.getStreams().getStream_Id() );
	    ps.execute();
		}
	} catch (SQLException e) {
		throw new Daoexception("exception");
	}
	return true;
    }
    
	public ArrayList<StudentDto> getsStudentCount() throws Daoexception{
		con=util.openConnection();
		ArrayList<StudentDto> arr1=new ArrayList<StudentDto>();
		
		try {
			String query2=" select stream_id, count(student_id) from students group by stream_id";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query2);
			while(rs.next()) {
			StudentDto stud=new StudentDto(rs.getString(1),rs.getInt(2));
			arr1.add(stud);
			}
		} catch (SQLException e) {
			throw new Daoexception("exception");
		}
		return arr1;
		
	}
	
		
	}


