package main;

import java.util.Scanner;

import dao.StudentDao;

public class Client {
	
	static StudentDao sDao = new StudentDao();
	
	public static void menu() {
		System.out.println("\n1. Add Student Details."
				+ "\n2. Show All Student Details."
				+ "\n3. Get Student Details Based on Roll Number."
				+"\n4. Delete Student Details."
				+"\n5. Update Student Details."
				+"\n6. Exit."
				);
	}

	public static void main(String[] args) {
		
		System.out.println("*******Welcome to Student Management Application*******");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int flag=0;
			menu();
			System.out.print("Please enter your choice:");
			int choice = sc.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Please add the below student details:");
					sDao.insertStudent();
					break;
				case 2:
					System.out.println("Showing All Student Details:");
					System.out.println("______________________________________________");
					sDao.showAllStudentDetails();
					break;
				case 3:
					 sDao.showStudentById();
					break;
				case 4:
					sDao.deleteStudentById();
					break;
				case 5:
					System.out.println("Updating Student Details:");
					sDao.updateStudentDetails();
					break;
				case 6:
					System.out.println("Thanks for using the application!!");
					flag=1;
					break;
				default:
					System.out.println("Please enter valid Operation");
					break;
			}
			if(flag==1)
				break;
		}

	}

}
