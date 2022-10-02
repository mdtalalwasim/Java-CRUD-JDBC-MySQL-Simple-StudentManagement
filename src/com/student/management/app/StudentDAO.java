package com.student.management.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDAO {
	
	
	public static void insertStudentToDB(Student st) { 
		////this Student st means...insert this st into db.
		
		try {
			
			//jdbc code write here.....
			//create connection
			Connection con = ConnectionProvider.createConnection();
			
			//create and fire query
			String q = "insert into students(sName, sPhone, sCity) values (?,?,?)";
			//PreparedStatement because of comple type query...
			PreparedStatement pstmt = con.prepareStatement(q);
			//set the value of parameters
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentPhone());
			
			//execute
			pstmt.executeUpdate();
			
			//this will only execute if all is going well
			System.out.println("Succefully Inserted the Student");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	public static void deleteStudent(int userId) {
try {
			
			//jdbc code write here.....
			//create connection
			Connection con = ConnectionProvider.createConnection();
			
			//create and fire query
			String q = "delete from students where sId=?";
			//PreparedStatement because of complete type query...
			PreparedStatement pstmt = con.prepareStatement(q);
			//set the value of parameters
			pstmt.setInt(1, userId);
			//execute
			pstmt.executeUpdate();
			
			//this will only execute if all is going well means pstmt.executeUpdate(); is executed successfully
			System.out.println("Succefully Deleted the Student...");
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

	public static void updateStudent() {
		// TODO Auto-generated method stub
		
	}

	public static void updateStudent(Student st) {
		
		try {
			
			//create connection
			Connection con = ConnectionProvider.createConnection();
			
			//create & fire query...
			
			String q = "update students set sName=?, sPhone=?, sCity=? where sId=? ";
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			pstmt.setInt(4, st.getStudentId());
			
			pstmt.executeUpdate();
			System.out.println("Update Successfully...");
			
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void showAllStudenet() {
		//display all Student
try {
			
			//create connection
			Connection con = ConnectionProvider.createConnection();
			
			//create & fire query...
			
			String q = "select * from students";
			Statement stmt = con.createStatement();
			
			ResultSet set =stmt.executeQuery(q);
			
			while (set.next()) {
				int id=set.getInt(1);
				String name=set.getString(2);
				String phone=set.getString(3);
				//String city=set.getString(4); //or
				String city=set.getString("sCity");
				
				System.out.println("ID :"+id);
				System.out.println("Name :"+name);
				System.out.println("Phone :"+phone);
				System.out.println("City :"+city);
				System.out.println("++++++++++++++++++++++++++++++");
				
				
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//////////////

}
