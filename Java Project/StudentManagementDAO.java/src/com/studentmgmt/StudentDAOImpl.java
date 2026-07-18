package com.studentmgmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO{
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	

	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		try {
			con=DBConnection.getConnection();
			String sql="INSERT INTO Student VALUES(?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1, s.getId());
			ps.setString(2,s.getName());
			ps.setString(3,s.getCourse());
			ps.setString(4,s.getEmail());
			ps.setString(5,s.getMobile());
			int i=ps.executeUpdate();
			
			if(i>0) {
				System.out.println("student added successfully!!!");
			}
			else
			{
				System.out.println("Student not added!!");
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		
		try {
			con=DBConnection.getConnection();
			String sql="UPDATE Student set name=?,course=?,email=?,mobile=? where id=?";
			ps=con.prepareStatement(sql);
			
			ps.setString(1,s.getName());
			ps.setString(2,s.getCourse());
			ps.setString(3,s.getEmail());
			ps.setString(4,s.getMobile());
			ps.setInt(5, s.getId());
			int i=ps.executeUpdate();
			
			
			if(i>0) {
				System.out.println("student updated successfully!!!");
			}
			else
			{
				System.out.println("Student not found!!");
			}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		try {
			
			con=DBConnection.getConnection();
			String sql="delete from Student where id=?";
			
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.println("Record deleted successfully!!!");
			}else
			{
				System.out.println("Student Id not found!!");
			}
			
			
		}catch(Exception e)
		{
			e.printStackTrace();		}
		
				
		}

	@Override
	public Student searchStudent(int id) {
		// TODO Auto-generated method stub
		Student s=null;
		try {
			con=DBConnection.getConnection();
			String sql="select * from student where id=?";
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setCourse(rs.getString("course"));
				s.setEmail(rs.getString("email"));
				s.setMobile(rs.getString("mobile"));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
			return s;
	}

	@Override
	public List<Student> displayAllStudents() {
		
		// TODO Auto-generated method stub
		List<Student> list=new ArrayList<Student>();
		try {
            con=DBConnection.getConnection();
			String sql="select * from Student";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Student s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setCourse(rs.getString("course"));
				s.setEmail(rs.getString("email"));
				s.setMobile(rs.getString("mobile"));
				
				list.add(s);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
		
		return list;
	}

}