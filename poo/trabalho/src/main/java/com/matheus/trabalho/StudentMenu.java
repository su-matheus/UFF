package com.matheus.trabalho;

import java.util.List;
import java.util.Scanner;

import com.matheus.model.Student;
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
        	System.out.println("5. Back Menu");
        	
        	int choice = scanner.nextInt();
        	scanner.nextLine();
        	
        	switch(choice) {
	        	case 1:
	        		System.out.println("Enter student name:");
	        		name = scanner.nextLine();
	        		System.out.println("Enter student email:");
	        		email = scanner.nextLine();
	        		student = new Student(name, email);
	        		studentService.addStudent(student);
	        		System.out.println("Student " + student.getId() + " added successfully!");
	        		break;
	        		
	        		
	        	case 2:
	        		System.out.println("Insert student ID you intend to update:");
	        		id = scanner.nextInt();
	        		student = studentService.getStudent(id);
	        		
	        		if(student != null) {
	        			System.out.println("Enter new student name:");
	        			name = scanner.nextLine();
	        			student = new Student(name, student.getEmail());
	        			studentService.updateStudentName(student, name);
		        		System.out.println("Student updated successfully!");
	        		}
	        		break;
	        		
	        	case 3:
	        		System.out.println("Insert student ID you intend to delete:");
	        		id = scanner.nextInt();
	        		studentService.deleteStudent(id);
	        		System.out.println("Student deleted successfully!");
	        		break;
	        		
	        	case 4:
	        		//studentService.getAllStudents().values().forEach(System.out::println);
	        		List<Student> students = studentService.getAllStudents();
	        		for (Student currentStudent : students) {
	        			System.out.println(currentStudent);
	        		}
	        		break;
	        		
	        	case 5:
	        		//printMenu = false;
	        		return;
	        	default:
	        		System.out.println("\n" + "Invalid option!");        		
        	}
        }
	}	
}