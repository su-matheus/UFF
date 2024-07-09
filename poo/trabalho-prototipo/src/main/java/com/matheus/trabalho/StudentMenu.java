package com.matheus.trabalho;

import java.util.List;
import java.util.Scanner;
import com.matheus.exception.*;
import com.matheus.model.Inscription;
import com.matheus.model.Student;
import com.matheus.model.Inscription.Presence;
import com.matheus.service.StudentService;

public class StudentMenu {
	private static Scanner scanner = new Scanner(System.in);
	private static StudentService studentService = new StudentService();
	
	
	public void main() {
		int id;
		String name;
		String email;
		Student student;

        boolean printMenu = true;
        while (printMenu) {
        	System.out.println("------------STUDENT MENU-------------");
        	System.out.println("1. Add Student");
        	System.out.println("2. Update Student");
        	System.out.println("3. Delete Student");
        	System.out.println("4. List All Student");
        	System.out.println("5. List Approved Students");
        	System.out.println("6. Back Menu");
        	
        	int choice = scanner.nextInt();
        	scanner.nextLine();
        	
        	switch(choice) {
	        	case 1:
	        		System.out.println("Enter student name:");
	        		name = scanner.nextLine();
	        		System.out.println("Enter student email:");
	        		email = scanner.nextLine();
	        		
	        		if (!InputHandler.isEmailValid(email)) {
	        			System.out.println("Invalid Email. Email should follow the pattern 'user@email.com'.");
	        			return;
	        		} else if(!InputHandler.isUsernameValid(name)) {
	        			System.out.println("Invalid Username. Username must contain at least 3 words.");
	        			return;
	        		}
	        		student = new Student(name, email);
	        		studentService.addStudent(student);
	        		System.out.println("Student " + student.getId() + " added successfully!");
	        		break;
	        		
	        	case 2:
	        		System.out.println("Insert student ID you intend to update:");
	        		id = scanner.nextInt();
	        		
	        		try {
	            		student = studentService.getStudent(id);
	        			System.out.println("------------UPDATE STUDENT MENU-------------");
	            		System.out.println("Type the option you intend to update:");
	            		System.out.println("1. Update name:");
	            		System.out.println("2. Update email:");
	            		System.out.println("3. Back menu");
	            		int option = scanner.nextInt();
		        		scanner.nextLine();
	            		
	            		switch(option) {
	            		case 1:
	            			System.out.println("Type the new name:");
	            			String newName = scanner.nextLine();
	            			if(!InputHandler.isUsernameValid(newName)) {
	    	        			System.out.println("Invalid Username. Username must contain at least 3 words.");
	    	        			return;
	    	        		}
	            			studentService.updateStudentName(student, newName);
	            			System.out.println("Name updated succesfully!");
	            			break;
	            			
	            		case 2:
	            			System.out.println("Type the new email:");
	            			String newEmail = scanner.nextLine();
	            			if (!InputHandler.isEmailValid(newEmail)) {
	    	        			System.out.println("Invalid Email. Email should follow the pattern 'user@email.com'.");
	    	        			return;
	    	        		}
	            			studentService.updateStudentEmail(student, newEmail);
	            			System.out.println("Email updated succesfully!");
	            			break;
	            			
	            		case 3:
	            			return;
	        			default:
	        				System.out.println("\n" + "Invalid option!");
	            		}
	        		} catch (ObjectDoesntExist e) {
	        			System.out.println("\n" + e.getMessage());
	        		}        		
	        		break;
	        		
	        	case 3:
	        		System.out.println("Insert student ID you intend to delete:");
	        		id = scanner.nextInt();
	        		try {
		        		studentService.deleteStudent(id);
		        		System.out.println("Student deleted successfully!");
	        		} catch (ObjectWithAssociation e) {
	        			System.out.println("\n" + e.getMessage());
	        		}
	        		break;
	        		
	        	case 4:
	        		//studentService.getAllStudents().values().forEach(System.out::println);
	        		List<Student> students = studentService.getAllStudents();
	        		for (Student currentStudent : students) {
	        			System.out.println(currentStudent);
	        		}
	        		break;
	        		
	        	case 5:
	        		List<Student> studentList = studentService.getAllStudents();
	        		
	        		for (Student currentStudent : studentList) {
	        			for (Inscription inscription : currentStudent.getInscriptions()) {
	        				if (inscription.getScore() >= 8) {
	        					System.out.println("Student{name= " + currentStudent.getName() + ", score= " + inscription.getScore() + ", class=" + inscription.getClasses() + "}");
	        				}
	        			}
	        		}
	        		
	        		break;
	        	case 6:
	        		//printMenu = false;
	        		return;
	        	default:
	        		System.out.println("\n" + "Invalid option!");        		
        	}
        }
	}	
}