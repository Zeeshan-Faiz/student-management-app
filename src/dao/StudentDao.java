package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import db.DBConnection;
import model.Student;

public class StudentDao {

	private String name;
	private String collegeName;
	private String city;
	private double percentage;
	Student student = new Student();
	Scanner sc = new Scanner(System.in);
	
	
	public void insertStudent() {
		
		boolean flag = false;
		System.out.print("Enter Student Name: ");
		name = sc.next();
		System.out.print("Enter College Name: ");
		collegeName = sc.next();
		sc.nextLine();
		System.out.print("Enter City Name: ");
		city = sc.next();
		sc.nextLine();
		System.out.print("Enter Percentage: ");
		percentage = sc.nextDouble();
		
		try {
			Connection con = DBConnection.createConnection();
			String query = "insert into student_details(student_name,college_name,city,percentage) value(?,?,?,?)";
			PreparedStatement pStatement = con.prepareStatement(query);
			pStatement.setString(1, name);
			pStatement.setString(2, collegeName);
			pStatement.setString(3, city);
			pStatement.setDouble(4, percentage);
			
			pStatement.executeUpdate();
			flag= true;
					
		}
		catch(Exception ex){
			ex.printStackTrace();
			flag = false;
		}
		
		if(flag)
			System.out.println("Student Details inserted Successfully!!!");
		else
			System.out.println("Something went wrong, Please try again!!");
	}
	
	public void showAllStudentDetails() {
		
		try {
			Connection con = DBConnection.createConnection();
			String query = "select * from student_details";
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while(resultSet.next()) {
				System.out.println("Roll Number: " + resultSet.getInt(1) 
				+"\nName :" + resultSet.getString(2)
				+"\nCollege Name: " + resultSet.getString(3)
				+"\nCity: " + resultSet.getString(4)
				+"\nPercentage: " + resultSet.getDouble(5)
				);
				System.out.println("______________________________________________");
				
			}	
		}
		catch(Exception ex){
			ex.printStackTrace();
		}	
	}
	
	
	public void showStudentById() {
		
		int flag = 0;
		System.out.print("Enter Roll Number:");
		int roll_No = sc.nextInt();
		
		try {
			Connection con = DBConnection.createConnection();
			String query = "select * from student_details where roll_number ="+roll_No;
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			System.out.println("______________________________________________");
			
			
				while(resultSet.next()) {
					System.out.println("Roll Number: " + resultSet.getInt(1) 
					+"\nName :" + resultSet.getString(2)
					+"\nCollege Name: " + resultSet.getString(3)
					+"\nCity: " + resultSet.getString(4)
					+"\nPercentage: " + resultSet.getDouble(5)
					);
					
					System.out.println("Getting Student Details Based on Roll Number:");
					System.out.println("______________________________________________");
					flag=1;		
				}
				
			}
			catch(Exception ex){
				ex.printStackTrace();
				flag=0;
			}
		
		if(flag!=1)
			System.out.println("Student with this id is not available in the system.");
	}
	
	public void deleteStudentById() {
		
		System.out.println("Enter Roll Number: ");
		int roll_No = sc.nextInt();
		int flag=0;
		
		try {
			Connection con = DBConnection.createConnection();
			String query = "delete from student_details where roll_number ="+roll_No;
			PreparedStatement pStatement = con.prepareStatement(query);
			
			int res= pStatement.executeUpdate();
			if(res==1)
				flag=1;
			else
				flag=0;
				
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

		if(flag==1) 
			System.out.println("Record deleted successfully!!!");
		else
			System.out.println("Roll Number Doesn't match in the Database.");
	}
	
	public void updateStudentDetails() {
		
		System.out.println("Please select what attributes you want to update: ");
		System.out.println("\n1. Update Name.\n2. Update CollegeName.\n3. Update City.");
		System.out.println("Please enter your choice");
		int choice = sc.nextInt();
		
		switch(choice){
			case 1:
				System.out.print("Enter Roll number: \n");
				int newRoll_No = sc.nextInt();
				System.out.print("Enter New Name: ");
				String newName = sc.next();
				sc.nextLine();
				int flag=0;
				
				try {
					Connection con = DBConnection.createConnection();
					String query = "update student_details set student_name=? where roll_number =?";
					PreparedStatement pStatement = con.prepareStatement(query);
					pStatement.setString(1, newName);
					pStatement.setInt(2, newRoll_No);
					
					int res = pStatement.executeUpdate();
					if(res==1)
						flag=1;
					else
						flag=0;
						
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				if(flag==1)
					System.out.println("Details Updated Successfully!!!");
				else
					System.out.println("Something went wrong!!!Kindly check the Roll Number entered.");
				
			break;
			
			case 2:
				System.out.print("Enter Roll number: \n");
				newRoll_No = sc.nextInt();
				System.out.print("Enter New College Name: ");
				String newCollegeName = sc.next();
				sc.nextLine();
				flag=0;
				
				try {
					Connection con = DBConnection.createConnection();
					String query = "update student_details set college_name=? where roll_number =?";
					PreparedStatement pStatement = con.prepareStatement(query);
					pStatement.setString(1, newCollegeName);
					pStatement.setInt(2, newRoll_No);
					
					int res = pStatement.executeUpdate();
					if(res==1)
						flag=1;
					else
						flag=0;
						
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				if(flag==1)
					System.out.println("Details Updated Successfully!!!");
				else
					System.out.println("Something went wrong!!!Kindly check the Roll Number entered.");
				
			break;
			
			case 3:
				System.out.print("Enter Roll number: \n");
				newRoll_No = sc.nextInt();
				System.out.print("Enter New City Name: ");
				String newCityName = sc.next();
				sc.nextLine();
				flag=0;
				
				try {
					Connection con = DBConnection.createConnection();
					String query = "update student_details set city=? where roll_number =?";
					PreparedStatement pStatement = con.prepareStatement(query);
					pStatement.setString(1, newCityName);
					pStatement.setInt(2, newRoll_No);
					
					int res = pStatement.executeUpdate();
					if(res==1)
						flag=1;
					else
						flag=0;
						
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
				if(flag==1)
					System.out.println("Details Updated Successfully!!!");
				else
					System.out.println("Something went wrong!!!Kindly check the Roll Number entered.");
				
			break; 
				
			default:
				System.out.println("Please enter correct choice.");
				updateStudentDetails();
				break;
		}
		
		
	}

	
}
