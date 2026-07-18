package com.studentmgmt;

import java.util.List;

public interface StudentDAO {
	
	void addStudent(Student s);
	void updateStudent(Student s);
	void deleteStudent(int id);
	Student searchStudent(int id);
	List<Student> displayAllStudents();

}
