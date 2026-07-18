package com.studentmgmt;
import java.util.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		StudentDAO dao=new StudentDAOImpl();
		
		int choice;
		do {
			System.out.println("==============STUDENT MANAGEMENT SYSTEM===============");
			System.out.println("1.Add Student");
			System.out.println("2.Update Student");
			System.out.println("3.Delete Student");
			System.out.println("4.Search Student");
			System.out.println("5.Display All students");
			System.out.println("6.Exit");
			System.out.println("Enter your choice:");
			choice=sc.nextInt();	
			switch(choice) {
			case 1:
				Student s1=new Student();
				System.out.println("Enter student id:");
				s1.setId(sc.nextInt());
				sc.nextLine();
				
				System.out.println("Enter name:");
				s1.setName(sc.nextLine());
				
				System.out.println("Enter Course:");
				s1.setCourse(sc.nextLine());
				
				System.out.println("Enter email:");
				s1.setEmail(sc.nextLine());
				System.out.println("Enter mobile:");
				s1.setMobile(sc.nextLine());
				
				dao.addStudent(s1);		
				
				break;
				
			case 2:
				Student s2=new Student();
				System.out.println("Enter student ID to update!!");
				s2.setId(sc.nextInt());
				sc.nextLine();
				System.out.println("Enter name:");
				s2.setName(sc.nextLine());
				
				System.out.println("Enter Course:");
				s2.setCourse(sc.nextLine());
				
				System.out.println("Enter email:");
				s2.setEmail(sc.nextLine());
				System.out.println("Enter mobile:");
				s2.setMobile(sc.nextLine());
				
				dao.updateStudent(s2);
			break;
			
			case 3:
				System.out.println("Enter Id to delete the record");
				int deleteId=sc.nextInt();
				dao.deleteStudent(deleteId);
				break;
				
			case 4:
				System.out.println("Enter student id to search:");
				int searchId=sc.nextInt();
				Student student=dao.searchStudent(searchId);
				if(student!=null) {
					System.out.println("\n Student Found!!");
					System.out.println("========================");
					System.out.println("Id:      "+student.getId());
					System.out.println("Name:    "+student.getName());
					System.out.println("Course:   "+student.getCourse());
					System.out.println("Email:    "+student.getEmail());
					System.out.println("Mobile:     "+student.getMobile());
					
				}else {
					System.out.println("Student Not found!!!");
				}
				
				
				break;
			case 5:
				
				  List<Student> list=dao.displayAllStudents();
				  if(list!=null && !list.isEmpty()) {
					  System.out.println("================Student List==============");
					  for(Student s:list) {
						  System.out.println(
								  s.getId()+ " | "+
								  s.getName()+ " | "+
								  s.getCourse()+ " | "+
								  s.getEmail()+ " | "+
								  s.getMobile());

					  
					  
				  }}
				  else 
				  {
					  System.out.println("No record found!!");
					  }
				 	
				
				break;
				
			default:
				System.out.println("Invalid Input!!");
				break;
			
			}
			
		}while(choice!=6);
		
		
     sc.close();
	}

}
