package com.student.management.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Author Md. Talal Wasim
 * 
 * */

public class MainStudentManage {

	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to Student Management App.");
		//taking input from users...
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//Menu Driven Program...
		while (true) {
			System.out.println();
			System.out.println("PRESS 1 to ADD/Insert Student");
			System.out.println("PRESS 2 to Delete Student");
			System.out.println("PRESS 3 to Update Student");
			System.out.println("PRESS 4 to Display Student");
			System.out.println("PRESS 5 to Exit App");
			
			int Userchoice = Integer.parseInt(br.readLine());//throws IOException
			
			if(Userchoice==1) {
				
				//add student
				System.out.println("Enter student name :");
				String name = br.readLine();
				
				System.out.println("Enter student Phone :");
				String phone = br.readLine();
				
				System.out.println("Enter student city :");
				String city = br.readLine();
				
				//create student object to store student
				//we are not using studentsId, Id will auto generated by Database;
				Student st = new Student(name, phone, city);
				StudentDAO.insertStudentToDB(st);
				System.out.println(st);
				
				
				
				
				
				
			}else if (Userchoice == 2) {
				
				//delete student
				//for deleting student you need to take id
				System.out.println("Enter student ID to delete student.");
				int userId = Integer.parseInt(br.readLine());
				StudentDAO.deleteStudent(userId);
				
				
			}else if (Userchoice==3) {
				//Update the student...
				System.out.println("Enter new Name for Updating Student :");
				String name= br.readLine();
				System.out.println("Enter new Phone :");
				String phone= br.readLine();
				System.out.println("Enter new City :");
				String city= br.readLine();
				System.out.println("Enter the Student ID :");
				int id= Integer.parseInt(br.readLine());
				
				Student st = new Student(id, name, phone, city);
				StudentDAO.updateStudent(st);
				
			}else if (Userchoice==4) {
				//Display all Student
				
				StudentDAO.showAllStudenet();
				
				
			}else if (Userchoice==5) {
				//exit App
				break;
			}else {
				//leave it Blank...
			}
			
			
		}
		System.out.println("Thank you for using the APP");


	}

}
